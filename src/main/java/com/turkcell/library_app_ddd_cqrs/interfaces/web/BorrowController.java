package com.turkcell.library_app_ddd_cqrs.interfaces.web;

import java.util.List;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.turkcell.library_app_ddd_cqrs.application.borrow.command.CreateBorrowCommand;
import com.turkcell.library_app_ddd_cqrs.application.borrow.command.UpdateBorrowCommand;
import com.turkcell.library_app_ddd_cqrs.application.borrow.dto.BorrowResponse;
import com.turkcell.library_app_ddd_cqrs.application.borrow.dto.CreatedBorrowResponse;
import com.turkcell.library_app_ddd_cqrs.application.borrow.dto.UpdatedBorrowResponse;
import com.turkcell.library_app_ddd_cqrs.application.borrow.query.FindByCustomerIdBorrowQuery;
import com.turkcell.library_app_ddd_cqrs.application.borrow.query.FindByIdBorrowQuery;
import com.turkcell.library_app_ddd_cqrs.application.borrow.query.ListBorrowsPagedQuery;
import com.turkcell.library_app_ddd_cqrs.core.cqrs.CommandHandler;
import com.turkcell.library_app_ddd_cqrs.core.cqrs.QueryHandler;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
@Validated
public class BorrowController {
	private final QueryHandler<ListBorrowsPagedQuery, List<BorrowResponse>> listBorrowQueryHandler;
	private final QueryHandler<FindByIdBorrowQuery, BorrowResponse> findByIdBorrowQueryHandler;
	private final QueryHandler<FindByCustomerIdBorrowQuery, List<BorrowResponse>> findByCustomerIdBorrowQueryHandler;
	private final CommandHandler<CreateBorrowCommand, CreatedBorrowResponse> createBorrowCommandHandler;
	private final CommandHandler<UpdateBorrowCommand, UpdatedBorrowResponse> updateBorrowCommandHandler;

	public BorrowController(
			QueryHandler<ListBorrowsPagedQuery, List<BorrowResponse>> listBorrowQueryHandler,
			QueryHandler<FindByIdBorrowQuery, BorrowResponse> findByIdBorrowQueryHandler,
			QueryHandler<FindByCustomerIdBorrowQuery, List<BorrowResponse>> findByCustomerIdBorrowQueryHandler,
			CommandHandler<CreateBorrowCommand, CreatedBorrowResponse> createBorrowCommandHandler,
			CommandHandler<UpdateBorrowCommand, UpdatedBorrowResponse> updateBorrowCommandHandler) {
		this.listBorrowQueryHandler = listBorrowQueryHandler;
		this.findByIdBorrowQueryHandler = findByIdBorrowQueryHandler;
		this.findByCustomerIdBorrowQueryHandler = findByCustomerIdBorrowQueryHandler;
		this.createBorrowCommandHandler = createBorrowCommandHandler;
		this.updateBorrowCommandHandler = updateBorrowCommandHandler;
	}

	@GetMapping("/v1/borrows")
	public List<BorrowResponse> getBorrowsPaged(@Valid ListBorrowsPagedQuery query) {
		return listBorrowQueryHandler.handle(query);
	}

	@GetMapping("/v1/borrows/{id}")
	public BorrowResponse getBorrowById(@Valid FindByIdBorrowQuery query) {
		return findByIdBorrowQueryHandler.handle(query);
	}

	@GetMapping("/v1/borrows/customers/{customerId}")
	public List<BorrowResponse> getBorrowsByCustomerId(@Valid FindByCustomerIdBorrowQuery query) {
		return findByCustomerIdBorrowQueryHandler.handle(query);
	}

	@PostMapping("/v1/borrows")
	public CreatedBorrowResponse createBorrow(@RequestBody @Valid CreateBorrowCommand command) {
		return createBorrowCommandHandler.handle(command);
	}

	@PutMapping("/v1/borrows/{id}")
	public UpdatedBorrowResponse updateBorrow(@PathVariable String id, @RequestBody @Valid UpdateBorrowCommand command) {
		return updateBorrowCommandHandler.handle(command);
	}

}

