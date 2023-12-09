package com.bruansk.repository;


import com.bruansk.entity.Calendar;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;


@Repository
public interface CalendarRepository extends CrudRepository<Calendar, Integer> {

    @Query("select c from Calendar c where c.actionDate >= :dateStart and c.actionDate <= :dateEnd")
    List<Object> get_task_by_date(Date dateStart, Date dateEnd);

}
