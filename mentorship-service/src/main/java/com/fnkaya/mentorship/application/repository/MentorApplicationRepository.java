package com.fnkaya.mentorship.application.repository;

import com.fnkaya.mentorship.application.domain.ApplicationStatus;
import com.fnkaya.mentorship.application.domain.MentorApplication;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MentorApplicationRepository extends JpaRepository<MentorApplication, String> {

    Optional<MentorApplication> findByOwnerIdAndCategoryNameAndStatusNot(String ownerId, String categoryName, ApplicationStatus status);

    Page<MentorApplication> findAllByStatus(ApplicationStatus status, Pageable pageable);

    Page<MentorApplication> findAllByOwnerId(String ownerId, Pageable pageable);
}
