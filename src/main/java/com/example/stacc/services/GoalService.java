package com.example.stacc.services;

import com.example.stacc.DTO.GoalStatusDTO;
import com.example.stacc.model.Goal;
import com.example.stacc.repository.GoalRepository;
import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GoalService {

  private final GoalRepository goalRepository;

  @Autowired
  public GoalService(GoalRepository goalRepository) {
  this.goalRepository = goalRepository;
  }

  public List<Goal> getGoals() {
    return goalRepository.findAll();
  }

  public Goal findGoalByAccountId(String id) {
    return goalRepository.findByAccountId(id).orElseThrow(() -> new NoSuchElementException("Goal with ID " + id + " not found"));
  }

  public GoalStatusDTO getGoalStatus(String id) {
    Goal goal = this.findGoalByAccountId(id);
    return new GoalStatusDTO(
        goal.getDescription(),
        goal.getTargetAmount(),
        goal.getAmount(),
        goal.getCurrency(),
        goal.getStatus()
    );
  }

}
