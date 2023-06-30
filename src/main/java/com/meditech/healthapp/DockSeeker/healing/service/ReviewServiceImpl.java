package com.meditech.healthapp.DockSeeker.healing.service;

import com.meditech.healthapp.DockSeeker.healing.domain.model.entity.Review;
import com.meditech.healthapp.DockSeeker.healing.domain.presistence.ReviewRepository;
import com.meditech.healthapp.DockSeeker.healing.domain.service.ReviewService;
import com.meditech.healthapp.DockSeeker.shared.exception.ResourceNotFoundException;
import com.meditech.healthapp.DockSeeker.shared.exception.ResourceValidationException;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class ReviewServiceImpl implements ReviewService {

    private static final String ENTITY = "Review";
    private ReviewRepository reviewRepository;
    private final Validator validator; //jakarta.validation.validator no confundir

    public ReviewServiceImpl(ReviewRepository reviewRepository, Validator validator){
        this.reviewRepository = reviewRepository;
        this.validator = validator;
    }

    @Override
    public List<Review> getAll() {
        return reviewRepository.findAll();
    }

    @Override
    public Review getById(Long reviewId) {
        return reviewRepository.findById(reviewId).
                orElseThrow(()->new ResourceNotFoundException(ENTITY,reviewId));
    }

    @Override
    public Page<Review> getAll(Pageable pageable) {
        return reviewRepository.findAll(pageable);
    }

    @Override
    public Review create(Review review) {

        Set<ConstraintViolation<Review>> violations = validator.validate(review);

        if(!violations.isEmpty()){
            throw new ResourceValidationException(ENTITY,violations);
        }
        //Name Uniques Validation


        return reviewRepository.save(review);

    }

    @Override
    public Review update(Long reviewId, Review request) {

        //Violation
        Set<ConstraintViolation<Review>> violations = validator.validate(request);
        if(!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);

        // Validation --> Name
        //Review newWithName = reviewRepository.findByCustomerName(request.getCustomerName());
        /*if(newWithName != null && !newWithName.getId().equals(reviewId))
            throw new ResourceValidationException(ENTITY,
                    "An New with the same title already exits.");*/

        return reviewRepository.findById(reviewId).map(newapp ->
                        reviewRepository.save(newapp
                                .withCustomerName(request.getCustomerName())
                                .withProfilePhotoUrl(request.getProfilePhotoUrl())
                                .withCustomerReview(request.getCustomerReview())
                                .withCustomerScore(request.getCustomerScore())
                                ))
                .orElseThrow(()->new ResourceNotFoundException(ENTITY,reviewId));

    }

    @Override
    public ResponseEntity<?> delete(Long reviewId) {
        return reviewRepository.findById(reviewId).map(reviewapp->{
            reviewRepository.delete(reviewapp);
            return ResponseEntity.ok().build();
        }).orElseThrow(()-> new ResourceNotFoundException(ENTITY, reviewId));
    }
}
