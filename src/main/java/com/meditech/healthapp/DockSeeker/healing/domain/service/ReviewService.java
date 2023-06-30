package com.meditech.healthapp.DockSeeker.healing.domain.service;

import com.meditech.healthapp.DockSeeker.healing.domain.model.entity.Review;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ReviewService {

    Page<Review> getAll(Pageable pageable);

    Review getById(Long reviewId);

    List<Review> getAll();

    Review create(Review review);

    Review update(Long reviewId, Review request);

    ResponseEntity<?> delte(Long reviewId);
}
