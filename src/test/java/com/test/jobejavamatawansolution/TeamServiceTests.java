package com.test.jobejavamatawansolution;

import com.test.jobejavamatawansolution.model.Team;
import com.test.jobejavamatawansolution.repo.TeamRepo;
import com.test.jobejavamatawansolution.service.TeamService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.*;

public class TeamServiceTests {
    @Mock
    private TeamRepo teamRepo;

    @InjectMocks
    private TeamService teamService;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void addTeamSuccess(){
        Team testTeam = new Team();
        testTeam.setName("paris SG");
        testTeam.setAcronym("PSG");
        testTeam.setBudget(50000000);

        Mockito.when(teamRepo.save(testTeam)).thenReturn(testTeam);
        Team testRes = teamService.addNewTeam(testTeam);
        assertEquals(testTeam.getName(), testRes.getName());
        assertEquals(testTeam.getAcronym(), testRes.getAcronym());

    }
}
