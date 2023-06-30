package com.meditech.healthapp.DockSeeker.healing.domain.presistence;

import com.meditech.healthapp.DockSeeker.healing.domain.model.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {

    Review findByCustomerName(String customerName);
}
