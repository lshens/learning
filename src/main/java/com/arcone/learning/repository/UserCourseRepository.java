package com.arcone.learning.repository;

import com.arcone.learning.model.CoursePO;
import com.arcone.learning.model.CourseStatusEnum;
import com.arcone.learning.model.UserCoursePO;
import com.arcone.learning.model.UserCoursePOId;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserCourseRepository extends JpaRepository<UserCoursePO, UserCoursePOId> {

    Page<CoursePO> findAllByUserId(String userId, Pageable pageable);
}