package com.meditech.healthapp.DockSeeker.healing.mapping;

import com.meditech.healthapp.DockSeeker.healing.domain.model.entity.New;
import com.meditech.healthapp.DockSeeker.healing.domain.model.entity.Date;

import com.meditech.healthapp.DockSeeker.healing.resource.*;
import com.meditech.healthapp.DockSeeker.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.List;


public class DateMapper implements Serializable {

    @Autowired
    EnhancedModelMapper mapper;

    public DateResource toResource(Date model){
        return mapper.map(model,DateResource.class);
    }

    public Page<DateResource> modelListPage(List<Date>modelList, Pageable pageable){
        return new PageImpl<>(mapper.mapList(modelList, DateResource.class),pageable, modelList.size());
    }

    public Date toModel(CreateDateResource resource){
        return mapper.map(resource, Date.class);
    }

}
