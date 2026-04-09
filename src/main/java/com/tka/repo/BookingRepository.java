package com.tka.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.tka.entity.Booking;
import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Long> {
    List<Booking> findAllByOrderByIdDesc();
}