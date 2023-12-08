package com.bruansk.repository;

import com.bruansk.entity.Test;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TestRepository {//extends CrudRepository<Test, Integer> {

//    @Query("Select b from BatteryScooter b where b.scooters.id = :id")
//    List<BatteryScooter> my_findByIdScooters(int id);

}
