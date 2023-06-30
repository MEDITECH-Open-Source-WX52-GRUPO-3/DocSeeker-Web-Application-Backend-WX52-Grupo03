package com.meditech.healthapp.DockSeeker.healing.mapping;


import com.meditech.healthapp.DockSeeker.healing.domain.model.entity.Patient;
import com.meditech.healthapp.DockSeeker.healing.resource.CreatePatientResource;
import com.meditech.healthapp.DockSeeker.healing.resource.PatientResource;
import com.meditech.healthapp.DockSeeker.healing.resource.UpdatePatientResource;
import com.meditech.healthapp.DockSeeker.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.List;

public class PatientMapper implements Serializable {

    @Autowired
    EnhancedModelMapper mapper;

    public PatientResource toResource(Patient model){
        return mapper.map(model,PatientResource.class);
    }

    public Page<PatientResource> modelListPage(List<Patient> modelList, Pageable pageable){
        return new PageImpl<>(mapper.mapList(modelList, PatientResource.class),pageable, modelList.size());
    }

    public Patient toModel(CreatePatientResource resource){
        return mapper.map(resource, Patient.class);
    }

    public Patient toModel(UpdatePatientResource resource){
        return mapper.map(resource, Patient.class);
    }

}
