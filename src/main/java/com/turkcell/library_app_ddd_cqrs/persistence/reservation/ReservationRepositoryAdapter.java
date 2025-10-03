package com.turkcell.library_app_ddd_cqrs.persistence.reservation;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

import com.turkcell.library_app_ddd_cqrs.domain.reservation.model.Reservation;
import com.turkcell.library_app_ddd_cqrs.domain.reservation.model.ReservationId;
import com.turkcell.library_app_ddd_cqrs.domain.reservation.repository.ReservationRepository;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class ReservationRepositoryAdapter implements ReservationRepository {

	private final SpringDataReservationRepository repository;
	private final ReservationEntityMapper reservationEntityMapper;

	@Override
	public Optional<Reservation> findById(ReservationId id) {
		return repository
				.findById(id.value())
				.map(reservationEntityMapper::toDomain);

	}

	@Override
	public List<Reservation> findAll() {
		return repository
				.findAll()
				.stream()
				.map(reservationEntityMapper::toDomain)
				.toList();
	}

	@Override
	public List<Reservation> findAllPaged(Integer pageIndex, Integer pageSize) {
		return repository
				.findAll(PageRequest.of(pageIndex, pageSize))
				.stream()
				.map(reservationEntityMapper::toDomain)
				.toList();
	}

	@Override
	public Reservation save(Reservation reservation) {
		JpaReservationEntity entity = reservationEntityMapper.toEntity(reservation);
		entity = repository.save(entity);
		return reservationEntityMapper.toDomain(entity);
	}

	@Override
	public void delete(ReservationId id) {
		repository.deleteById(id.value());
	}

}
