package com.Acciojob_Practice_Project.July2024.Practice;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DrRepo extends JpaRepository<Doctor,Integer> {
}
