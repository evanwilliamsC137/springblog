package com.codeup.springblog.models;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post,Long> {

    Post findById(long id);
    void deleteById(long id);

    void delete(Post post);
    Post save(Post post);
//    void editById(long id, String title, String body);
}
