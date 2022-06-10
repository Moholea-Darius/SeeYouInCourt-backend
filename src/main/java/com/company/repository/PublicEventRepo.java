package com.company.repository;

import com.company.model.PublicEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PublicEventRepo extends JpaRepository<PublicEvent, Integer> {

}
