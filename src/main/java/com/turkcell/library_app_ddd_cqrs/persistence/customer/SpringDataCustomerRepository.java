package com.turkcell.library_app_ddd_cqrs.persistence.customer;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataCustomerRepository extends JpaRepository<JpaCustomerEntity, UUID> {

}
