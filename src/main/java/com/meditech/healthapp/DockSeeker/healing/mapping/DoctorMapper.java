package com.meditech.healthapp.DockSeeker.healing.mapping;

import com.meditech.healthapp.DockSeeker.healing.domain.model.entity.Doctor;
import com.meditech.healthapp.DockSeeker.healing.resource.CreateDoctorResource;
import com.meditech.healthapp.DockSeeker.healing.resource.DoctorResource;
import com.meditech.healthapp.DockSeeker.healing.resource.UpdateDoctorResource;
import com.meditech.healthapp.DockSeeker.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.List;


public class DoctorMapper implements Serializable {

    @Autowired
    EnhancedModelMapper mapper;

    public DoctorResource toResource(Doctor model) { return mapper.map(model, DoctorResource.class);}

    public Page<DoctorResource> modelListPage(List<Doctor>modelList, Pageable pageable){
        return new PageImpl<>(mapper.mapList(modelList, DoctorResource.class), pageable, modelList.size());
    }

    public Doctor toModel(CreateDoctorResource resource) {
        return mapper.map(resource, Doctor.class);
    }

    public Doctor toModel(UpdateDoctorResource resource) {
        return mapper.map(resource, Doctor.class);
    }
}
