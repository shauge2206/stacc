package com.example.stacc.repository;

import com.example.stacc.model.Goal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface GoalRepository extends JpaRepository<Goal, String> {
  Optional<Goal> findByAccountId(String accountId);
}