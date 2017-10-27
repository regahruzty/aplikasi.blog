package com.dimas.maryanto.blogs.repository;

import com.dimas.maryanto.blogs.model.Lecture;
import com.dimas.maryanto.blogs.model.Page;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface LectureRepository extends PagingAndSortingRepository<Lecture, String> {

    List<Lecture> findByPage(Page page);
}
