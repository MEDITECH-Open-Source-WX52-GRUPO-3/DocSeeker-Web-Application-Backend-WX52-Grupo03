package com.meditech.healthapp.DockSeeker.healing.api;

import com.meditech.healthapp.DockSeeker.healing.domain.service.NewService;
import com.meditech.healthapp.DockSeeker.healing.mapping.NewMapper;
import com.meditech.healthapp.DockSeeker.healing.resource.CreateNewResource;
import com.meditech.healthapp.DockSeeker.healing.resource.NewResource;
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
@RequestMapping(value = "api/v1/news", produces = "application/json")
@Tag(name = "news", description = "Create, read, update and delete news")
public class NewController {

    private final NewService newService;
    private final NewMapper mapper;


    public NewController(NewService newService, NewMapper mapper) {
        this.newService = newService;
        this.mapper = mapper;
    }

    @PostMapping
    @Operation(summary = "Create New", responses = {
            @ApiResponse(description = "New successfully created", responseCode = "201",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = NewResource.class)))
    })
    public ResponseEntity<NewResource> createNew(CreateNewResource resource){
        return new ResponseEntity<>(mapper.toResource(newService.create(mapper.toModel(resource))),
                HttpStatus.CREATED);
    }
}
