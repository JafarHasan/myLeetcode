package com.Acciojob_Practice_Project.July2024.AssociateTwoEntities;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Book1Repo extends JpaRepository<Book1,Integer> {
}
