package com.dimas.maryanto.blogs.repository;

import com.dimas.maryanto.blogs.model.Page;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface PageRepository extends PagingAndSortingRepository<Page, String> {

    List<Page> findAll();
}
