package com.bruansk.repository;

import com.bruansk.entity.MaterialLink;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MaterialLinkRepository extends CrudRepository<MaterialLink, Integer> {

    @Query("select m from MaterialLink m where m.materialType.id = 2")
    List<Object> my_get_article_list();

    @Query("select m from MaterialLink m where m.materialType.id = 3")
    List<Object> my_get_video_link_list();

    @Query("select m from MaterialLink m")
    List<Object> get_all_article();

    @Query("select m from MaterialLink m where m.idTestCategory = :id")
    List<Object> get_all_article_by_age(int id);

    @Query("select m from MaterialLink m where m.idTestCategory = :id and m.materialType.id = 2")
    List<Object> get_article_by_age(int id);

    @Query("select m from MaterialLink m where m.idTestCategory = :id and m.materialType.id = 3")
    List<Object> get_video_link_by_age(int id);

}
