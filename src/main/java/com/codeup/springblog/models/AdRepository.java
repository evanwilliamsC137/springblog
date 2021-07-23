package com.codeup.springblog.models;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

//Extension gives us auto magic like findAll()
public interface AdRepository extends JpaRepository<Ad, Long> {

    Ad findById(long id);

//    using query annotation to get a custom query
    @Query("from Ad a where a.title like %:term%")

    Ad findFirstByTitle(String term);
//    Ad findFirstByTitle(String title);
}
