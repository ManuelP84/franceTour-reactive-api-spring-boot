package com.sofka.franceTour.reporitory;

import com.sofka.franceTour.entity.Cyclist;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface ICyclistRepository  extends ReactiveMongoRepository<Cyclist, String> {
    Flux<Cyclist> findAllByTeamId(String id);
}