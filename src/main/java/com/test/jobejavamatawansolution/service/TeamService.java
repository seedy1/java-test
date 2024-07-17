package com.test.jobejavamatawansolution.service;

import com.test.jobejavamatawansolution.model.Team;
import com.test.jobejavamatawansolution.repo.TeamRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

/**
 * Team service class
 */
@Service
public class TeamService {

    private static final Logger logger = LoggerFactory.getLogger(TeamService.class);
    @Autowired
    private TeamRepo teamRepo;

    public Page<Team> getAllTeamsPaginated(int page, int size, String sortBy){
        if(page < 0 || size <= 0 ){
            logger.error("TeamService: page or size is/are invalid");
            return null;
        }
        return teamRepo.findAll(PageRequest.of(page, size, Sort.by(sortBy))); // defaults are defined in the controller
    }

    public Team addNewTeam(Team team){
        // team must have all attr; only players is not mandatory
        if(team.getAcronym().isEmpty() || team.getName().isEmpty() || team.getBudget() <0){
            logger.error("TeamService: invalid data");
            return null;
        }
        logger.info("TeamService: Adding new team");
        return teamRepo.save(team);
    }
}
