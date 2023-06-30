package com.meditech.healthapp.DockSeeker.healing.api;

import com.meditech.healthapp.DockSeeker.healing.domain.service.ReviewService;
import com.meditech.healthapp.DockSeeker.healing.mapping.ReviewMapper;
import com.meditech.healthapp.DockSeeker.healing.resource.CreateNewResource;
import com.meditech.healthapp.DockSeeker.healing.resource.CreateReviewResource;
import com.meditech.healthapp.DockSeeker.healing.resource.NewResource;
import com.meditech.healthapp.DockSeeker.healing.resource.ReviewResource;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api/v1/review", produces = "application/json")
@Tag(name = "review", description = "Create, read, update and delete news")
public class ReviewController {

    private final ReviewService reviewService;
    private final ReviewMapper mapper;


    public ReviewController(ReviewService reviewService, ReviewMapper mapper) {
        this.reviewService = reviewService;
        this.mapper = mapper;
    }

    @PostMapping
    @Operation(summary = "Create New", responses = {
            @ApiResponse(description = "Review successfully created", responseCode = "201",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ReviewResource.class)))
    })
    public ResponseEntity<ReviewResource> createReview(CreateReviewResource resource){
        return new ResponseEntity<>(mapper.toResource(reviewService.create(mapper.toModel(resource))),
                HttpStatus.CREATED);
    }


}
