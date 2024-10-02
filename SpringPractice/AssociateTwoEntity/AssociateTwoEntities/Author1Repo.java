package com.Acciojob_Practice_Project.July2024.AssociateTwoEntities;

import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

@Repository
public interface Author1Repo extends JpaRepository<Author1, Integer> {
}
