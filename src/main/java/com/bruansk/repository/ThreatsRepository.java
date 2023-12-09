package com.bruansk.repository;

import com.bruansk.entity.Threats;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ThreatsRepository extends CrudRepository<Threats, Integer> {



}
