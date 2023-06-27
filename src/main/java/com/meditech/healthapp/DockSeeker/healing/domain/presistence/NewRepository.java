package com.meditech.healthapp.DockSeeker.healing.domain.presistence;

import com.meditech.healthapp.DockSeeker.healing.domain.model.entity.New;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NewRepository extends JpaRepository<New, Long> {

}
