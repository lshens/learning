package com.arcone.learning.repository;

import com.arcone.learning.model.CoursePO;
import com.arcone.learning.model.CourseStatusEnum;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<CoursePO, String> {

    boolean existsByName(String name);

    Page<CoursePO> findAllByStatusIsNot(CourseStatusEnum status, Pageable pageable);
}
