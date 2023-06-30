package com.meditech.healthapp.DockSeeker.healing.mapping;

import com.meditech.healthapp.DockSeeker.healing.domain.model.entity.Review;
import com.meditech.healthapp.DockSeeker.healing.resource.CreateReviewResource;
import com.meditech.healthapp.DockSeeker.healing.resource.ReviewResource;
import com.meditech.healthapp.DockSeeker.healing.resource.UpdateReviewResource;
import com.meditech.healthapp.DockSeeker.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.List;

public class ReviewMapper implements Serializable {

    @Autowired
    EnhancedModelMapper mapper;

    public ReviewResource toResource(Review model){return mapper.map(model,ReviewResource.class);}

    public Page<ReviewResource> modelListPage(List<Review> modelList, Pageable pageable){
        return new PageImpl<>(mapper.mapList(modelList,ReviewResource.class), pageable,modelList.size());
    }

    public Review toModel(CreateReviewResource resource){return mapper.map(resource,Review.class);}

    public Review toModel(UpdateReviewResource resource){return mapper.map(resource,Review.class);}

}
