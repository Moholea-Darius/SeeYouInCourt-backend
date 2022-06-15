package com.company.repository;

import com.company.model.Announcement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Id;
import java.util.List;

@Repository

public interface AnnouncementRepo extends JpaRepository<Announcement, Integer> {

    List<Announcement> findByIDAnnouncements (Id id);
}
