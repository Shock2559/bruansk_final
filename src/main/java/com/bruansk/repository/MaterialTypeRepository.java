package com.bruansk.repository;

import com.bruansk.entity.MaterialLink;
import com.bruansk.entity.MaterialType;
import jdk.jfr.Registered;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

@Registered
public interface MaterialTypeRepository extends CrudRepository<MaterialType, Integer> {

    @Query("select m from MaterialType m where m.id = :id")
    List<Object> my_get_type_by_id(int id);

}
