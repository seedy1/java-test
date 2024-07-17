package com.test.jobejavamatawansolution.controller;

import com.test.jobejavamatawansolution.model.Team;
import com.test.jobejavamatawansolution.service.TeamService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Team controller with routes as /api/teams/
 */
@RestController
@RequestMapping("/api/teams")
public class TeamController{

    private static final Logger logger = LoggerFactory.getLogger(TeamController.class);

    private final TeamService teamService;
    @Autowired
    public TeamController(TeamService ts){
        this.teamService = ts;
    }

    @PostMapping
    public ResponseEntity<?> addNewTeam(@RequestBody Team team){
        try {
            Team newTeam = teamService.addNewTeam(team);
            return new ResponseEntity<>(newTeam, HttpStatus.CREATED);
        }catch (Exception e){
            logger.error("TeamController: {}", e.getMessage());
            // not advice to return e.getMessage() to user
            return new ResponseEntity<>("Error, Try again", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping
    public Page<?> getAllTeamsPaginated(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "2") int size,
            @RequestParam(defaultValue = "name") String sortBy){
        try {
            return teamService.getAllTeamsPaginated(page, size, sortBy);
        }catch (Exception e){
            logger.error("TeamController: {}", e.getMessage());
            return null;
        }
    }

}
