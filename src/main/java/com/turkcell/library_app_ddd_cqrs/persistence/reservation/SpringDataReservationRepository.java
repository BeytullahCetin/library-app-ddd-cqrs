package com.turkcell.library_app_ddd_cqrs.persistence.reservation;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataReservationRepository extends JpaRepository<JpaReservationEntity, UUID> {

}
