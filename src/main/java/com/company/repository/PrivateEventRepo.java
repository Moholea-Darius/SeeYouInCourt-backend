package com.company.repository;

import com.company.model.PrivateEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrivateEventRepo extends JpaRepository<PrivateEvent, Integer> {

}
