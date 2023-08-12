package com.arcone.learning.repository;

import com.arcone.learning.model.CoursePO;
import com.arcone.learning.model.CourseStatusEnum;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

@Repository
public interface CourseRepository extends JpaRepository<CoursePO, String> {

    boolean existsByName(String name);

    Page<CoursePO> findAllStatusNotEqual(CourseStatusEnum status, Pageable pageable);
}
