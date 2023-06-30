package com.meditech.healthapp.DockSeeker.healing.domain.presistence;

import com.meditech.healthapp.DockSeeker.healing.domain.model.entity.Date;
import com.meditech.healthapp.DockSeeker.healing.domain.model.entity.New;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DateRepository extends JpaRepository<Date, Long> {
    Date getByDate(String date);


}
