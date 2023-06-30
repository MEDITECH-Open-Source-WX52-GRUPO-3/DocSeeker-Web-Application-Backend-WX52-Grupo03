package com.meditech.healthapp.DockSeeker.healing.api;

import com.meditech.healthapp.DockSeeker.healing.domain.service.DoctorService;
import com.meditech.healthapp.DockSeeker.healing.mapping.DoctorMapper;
import com.meditech.healthapp.DockSeeker.healing.resource.CreateDoctorResource;
import com.meditech.healthapp.DockSeeker.healing.resource.DoctorResource;
import com.meditech.healthapp.DockSeeker.healing.resource.UpdateDoctorResource;
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
@RequestMapping(value = "api/v1/doctors", produces = "application/json")
@Tag(name = "doctors", description = "Create, read, update and delete doctors")
public class DoctorController {

    private final DoctorService doctorService;
    private final DoctorMapper mapper;


    public DoctorController(DoctorService doctorService, DoctorMapper mapper) {
        this.doctorService = doctorService;
        this.mapper = mapper;
    }

    @PostMapping
    @Operation(summary = "Create Doctor", responses = {
            @ApiResponse(description = "Doctor successfully created", responseCode = "201",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = DoctorResource.class)))
    })
    public ResponseEntity<DoctorResource> createNew(CreateDoctorResource resource){
        return new ResponseEntity<>(mapper.toResource(doctorService.create(mapper.toModel(resource))),
                HttpStatus.CREATED);
    }

    @GetMapping
    @Operation(summary = "Get all Doctor")
    public Page<DoctorResource> getAllDoctors(Pageable pageable){
        return mapper.modelListPage(doctorService.getAll(), pageable);
    }

    @GetMapping("{doctorId}")
    @Operation(summary = "Get doctors By Id")
    public DoctorResource getDoctorById(@PathVariable Long doctorId){
        return mapper.toResource(doctorService.getById(doctorId));
    }

    @PutMapping("{doctorId}")
    public DoctorResource updateDoctor(@PathVariable Long doctorId, UpdateDoctorResource resource){
        return mapper.toResource(doctorService.update(doctorId, mapper.toModel(resource)));
    }

    @DeleteMapping("{doctorId}")
    public ResponseEntity<?> deleteDoctor(Long doctorId){
        return doctorService.delete(doctorId);
    }


}
