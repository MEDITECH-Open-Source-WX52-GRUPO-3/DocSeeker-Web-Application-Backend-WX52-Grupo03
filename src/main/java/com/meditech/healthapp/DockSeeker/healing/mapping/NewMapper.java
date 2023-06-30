package com.meditech.healthapp.DockSeeker.healing.mapping;

import com.meditech.healthapp.DockSeeker.healing.domain.model.entity.New;
import com.meditech.healthapp.DockSeeker.healing.resource.CreateNewResource;
import com.meditech.healthapp.DockSeeker.healing.resource.NewResource;
import com.meditech.healthapp.DockSeeker.healing.resource.UpdateNewResource;
import com.meditech.healthapp.DockSeeker.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.List;


public class NewMapper implements Serializable {

    @Autowired
    EnhancedModelMapper mapper;

    public NewResource toResource(New model){
        return mapper.map(model,NewResource.class);
    }

    public Page<NewResource> modelListPage(List<New>modelList, Pageable pageable){
        return new PageImpl<>(mapper.mapList(modelList, NewResource.class),pageable, modelList.size());
    }

    public New toModel(CreateNewResource resource){
        return mapper.map(resource, New.class);
    }

    public New toModel(UpdateNewResource resource){
        return mapper.map(resource, New.class);
    }
}
