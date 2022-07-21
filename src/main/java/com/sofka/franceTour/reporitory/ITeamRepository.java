package com.sofka.franceTour.reporitory;

import com.sofka.franceTour.entity.Team;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface ITeamRepository extends ReactiveMongoRepository<Team, String> {
    Mono<Team> findAllByCountry(String country);
}
