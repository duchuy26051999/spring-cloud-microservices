package com.fnkaya.mentorship.mentorship.repository;

import com.fnkaya.mentorship.common.model.Account;
import com.fnkaya.mentorship.mentor.domain.Mentor;
import com.fnkaya.mentorship.mentorship.domain.Mentorship;
import com.fnkaya.mentorship.mentorship.domain.MentorshipStatus;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MentorshipRepository extends JpaRepository<Mentorship, String> {

    Optional<Mentorship> findByMenteeAndCategoryNameAndStatusIn(Account mentee, String categoryName, Collection<MentorshipStatus> mentorshipStatusList);

    List<Mentorship> findByMentorAndStatusIn(Mentor mentor, Collection<MentorshipStatus> mentorshipStatusList);

    List<Mentorship> findByMenteeIdOrderByStartDateDesc(String menteeId);

    List<Mentorship> findByMentorOrderByStartDateDesc(Mentor mentor);
}
