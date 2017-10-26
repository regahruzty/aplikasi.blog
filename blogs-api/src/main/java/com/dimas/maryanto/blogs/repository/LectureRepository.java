package com.dimas.maryanto.blogs.repository;

import com.dimas.maryanto.blogs.model.Lecture;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface LectureRepository extends PagingAndSortingRepository<Lecture, String> {
}
