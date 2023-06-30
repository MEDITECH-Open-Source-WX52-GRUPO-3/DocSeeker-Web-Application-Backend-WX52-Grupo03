package com.meditech.healthapp.DockSeeker.healing.api;

import com.meditech.healthapp.DockSeeker.healing.domain.service.NewService;
import com.meditech.healthapp.DockSeeker.healing.mapping.NewMapper;
import com.meditech.healthapp.DockSeeker.healing.resource.CreateNewResource;
import com.meditech.healthapp.DockSeeker.healing.resource.NewResource;
import com.meditech.healthapp.DockSeeker.healing.resource.UpdateNewResource;
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

    @GetMapping
    @Operation(summary = "Get all News")
    public Page<NewResource> getAllNews(Pageable pageable){
        return mapper.modelListPage(newService.getAll(), pageable);
    }

    @GetMapping("{newId}")
    @Operation(summary = "Get news By Id")
    public NewResource getNewById(@PathVariable Long newId){
        return mapper.toResource(newService.getById(newId));
    }

    @PutMapping("{newId}")
    public NewResource updateNew(@PathVariable Long newId, UpdateNewResource resource){
        return mapper.toResource(newService.update(newId, mapper.toModel(resource)));
    }

    @DeleteMapping("{newId}")
    public ResponseEntity<?> deleteNew(Long newId){
        return newService.delete(newId);
    }


}
