package com.dimas.maryanto.blogs.repository;

import com.dimas.maryanto.blogs.model.Tag;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface TagRepository extends PagingAndSortingRepository<Tag, String> {
}
