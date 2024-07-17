package com.test.jobejavamatawansolution.repo;

import com.test.jobejavamatawansolution.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface TeamRepo extends JpaRepository<Team, Long>, PagingAndSortingRepository<Team, Long>{}