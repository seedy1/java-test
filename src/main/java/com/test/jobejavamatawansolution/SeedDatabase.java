package com.test.jobejavamatawansolution;

import com.test.jobejavamatawansolution.model.Player;
import com.test.jobejavamatawansolution.model.Team;
import com.test.jobejavamatawansolution.repo.TeamRepo;
import com.test.jobejavamatawansolution.service.TeamService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SeedDatabase implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(SeedDatabase.class);

    @Autowired
    private TeamRepo teamRepo;

    @Override
    public void run(String... args) throws Exception {
        logger.info("Seeding teams and players.");
        Team teamNice = new Team();
        teamNice.setName("Nice");
        teamNice.setAcronym("NCE");
        teamNice.setBudget(1000000);
        Player player1 = new Player();
        player1.setName("Player One");
        player1.setPosition("Forward");
        player1.setTeam(teamNice);
        Player player2 = new Player();
        player2.setName("Player Two");
        player2.setPosition("Midfielder");
        player2.setTeam(teamNice);
        teamNice.setPlayers(List.of(player1, player2));
        teamRepo.save(teamNice);

        Team teamPSG = new Team();
        teamPSG.setName("Paris Saint-Germain");
        teamPSG.setAcronym("PSG");
        teamPSG.setBudget(5000000);

        teamRepo.save(teamPSG);

        Player psg1 = new Player();
        psg1.setName("Player psg1");
        psg1.setPosition("Midfielder");
        psg1.setTeam(teamNice);
        teamPSG.setPlayers(List.of(psg1));
        teamRepo.save(teamPSG);

        Team teamLyon = new Team();
        teamLyon.setName("Olympique Lyonnais");
        teamLyon.setAcronym("AOL");
        teamLyon.setBudget(200000);
        teamRepo.save(teamLyon);

        logger.info("Seeding successful.");
    }
}
