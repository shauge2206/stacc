package com.example.stacc.controller;

import com.example.stacc.DTO.GoalStatusDTO;
import com.example.stacc.model.Goal;
import com.example.stacc.services.GoalService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Goals", description = "Controller for retrieval of Goal entities based on specified criteria.")
@RestController
@RequestMapping("/api")
public class GoalController {

  private final GoalService goalservice;

  @Autowired
  public GoalController(GoalService goalService) {
    this.goalservice = goalService;
  }

  @Operation(summary = "Get all goals", description = "Gets all goals")
  @RequestMapping(value = "/goals", method = RequestMethod.GET)
  public List<Goal> getAllGoals() {
    return goalservice.getGoals();
  }

  @Operation(summary = "Get goals for account", description = "Gets goal associated with account")
  @RequestMapping(value = "/goals/{accountId}", method = RequestMethod.GET)
  public Goal getGoal(@PathVariable String accountId) {
    return goalservice.findGoalByAccountId(accountId);
  }

  @Operation(summary = "Get goals status", description = "Gets associated with account")
  @RequestMapping(value = "/goals/status/{accountId}", method = RequestMethod.GET)
  public GoalStatusDTO getGoalStatus(@PathVariable String accountId) {
    return goalservice.getGoalStatus(accountId);
  }
}
