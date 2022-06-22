package com.company.repository;


import com.company.model.Church;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ChurchRepo extends JpaRepository<Church, String> {

}
