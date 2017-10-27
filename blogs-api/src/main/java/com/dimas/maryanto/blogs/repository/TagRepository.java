package com.dimas.maryanto.blogs.repository;

import com.dimas.maryanto.blogs.model.Tag;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface TagRepository extends PagingAndSortingRepository<Tag, String> {

    List<Tag> findAll();

    @Query("from Tag where id not in ?1")
    List<Tag> cariBerdasarkanYangUdahAda(List<String> notIn);
}
