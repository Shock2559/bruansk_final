package com.bruansk.repository;

import com.bruansk.entity.MaterialLink;
import com.bruansk.entity.Scammers;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;

@Repository
public interface ScammerCheckRepository extends CrudRepository<Scammers, Integer> {

    @Query("select s from Scammers s where s.type = :type and s.name = :name")
    List<Object>  get_scammers_by_type_and_name(int type, String name);

}
