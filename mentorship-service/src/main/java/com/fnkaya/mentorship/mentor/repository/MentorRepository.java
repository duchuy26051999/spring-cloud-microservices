package com.fnkaya.mentorship.mentor.repository;

import com.fnkaya.mentorship.mentor.domain.Mentor;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MentorRepository extends JpaRepository<Mentor, String> {

    Optional<Mentor> findByAccountId(String accountId);
}
