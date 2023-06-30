package com.meditech.healthapp.DockSeeker.healing.api;

import com.meditech.healthapp.DockSeeker.healing.domain.service.DateService;
import com.meditech.healthapp.DockSeeker.healing.domain.service.NewService;
import com.meditech.healthapp.DockSeeker.healing.mapping.DateMapper;
import com.meditech.healthapp.DockSeeker.healing.mapping.NewMapper;
import com.meditech.healthapp.DockSeeker.healing.resource.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/v1/dates", produces = "application/json")
@Tag(name = "dates", description = "Create, read, update and delete dates")
public class DateController {

    private final DateService dateService;
    private final DateMapper mapper;


    public DateController(DateService dateService, DateMapper mapper) {
        this.dateService = dateService;
        this.mapper = mapper;
    }

    @PostMapping
    @Operation(summary = "Create Date", responses = {
            @ApiResponse(description = "Date successfully created", responseCode = "201",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = DateResource.class)))
    })
    public ResponseEntity<DateResource> createDate(CreateDateResource resource){
        return new ResponseEntity<>(mapper.toResource(dateService.create(mapper.toModel(resource))),
                HttpStatus.CREATED);
    }

    @GetMapping
    @Operation(summary = "Get all Dates")
    public Page<DateResource> getAllDates(Pageable pageable){
        return mapper.modelListPage(dateService.getAll(), pageable);
    }

    @GetMapping("{dateId}")
    @Operation(summary = "Get dates By Id")
    public DateResource getDateById(@PathVariable Long dateId){
        return mapper.toResource(dateService.getById(dateId));
    }


}
