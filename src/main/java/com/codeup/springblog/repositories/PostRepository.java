package com.codeup.springblog.repositories;

import com.codeup.springblog.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post,Long> {

    Post findById(long id);

    void delete(Post post);
    Post save(Post post);

    Post findByTitle(String post_to_be_deleted);
//    void editById(long id, String title, String body);
}
