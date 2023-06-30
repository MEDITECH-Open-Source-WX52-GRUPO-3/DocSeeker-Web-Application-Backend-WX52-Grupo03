package com.meditech.healthapp.DockSeeker.healing.api;

import com.meditech.healthapp.DockSeeker.healing.domain.service.PatientService;
import com.meditech.healthapp.DockSeeker.healing.mapping.PatientMapper;
import com.meditech.healthapp.DockSeeker.healing.resource.CreatePatientResource;
import com.meditech.healthapp.DockSeeker.healing.resource.PatientResource;
import com.meditech.healthapp.DockSeeker.healing.resource.UpdatePatientResource;
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
@RequestMapping(value = "api/v1/patients", produces = "application/json")
@Tag(name = "patients", description = "Create, read, update and delete patients")
public class PatientController {
    private final PatientService patientService;
    private final PatientMapper mapper;

    public PatientController(PatientService patientService, PatientMapper mapper){
        this.patientService = patientService;
        this.mapper = mapper;
    }

    @PostMapping
    @Operation(summary = "Create patient", responses = {
            @ApiResponse(description = "Patient successfully created", responseCode = "201",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = PatientResource.class)))
    })
    public ResponseEntity<PatientResource> createPatient(CreatePatientResource resource){
        return new ResponseEntity<>(mapper.toResource(patientService.create(mapper.toModel(resource))),
                HttpStatus.CREATED);
    }

    @GetMapping
    @Operation(summary = "Get all Patients")
    public Page<PatientResource> getAllPatients(Pageable pageable){
        return mapper.modelListPage(patientService.getAll(),pageable);
    }

    @GetMapping("{patientId}")
    @Operation(summary = "Get patients By Id")
    public PatientResource getPatientById(@PathVariable Long patientId){
        return mapper.toResource(patientService.getById(patientId));
    }

    @PutMapping("{patientId}")
    public PatientResource updatePatient(@PathVariable Long patientId, UpdatePatientResource resource){
        return mapper.toResource(patientService.update(patientId, mapper.toModel(resource)));
    }

    @DeleteMapping("{patientId}")
    public ResponseEntity<?> deletePatient(Long patientId) { return patientService.delete(patientId);}
}
