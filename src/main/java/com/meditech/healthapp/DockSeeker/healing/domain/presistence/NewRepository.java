package com.meditech.healthapp.DockSeeker.healing.domain.presistence;

import com.meditech.healthapp.DockSeeker.healing.domain.model.entity.New;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

@Repository
public interface NewRepository extends JpaRepository<New, Long> {
    New findByTitle(String title);


}
