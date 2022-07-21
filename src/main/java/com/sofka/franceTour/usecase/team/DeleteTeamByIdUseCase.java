package com.sofka.franceTour.usecase.team;

import com.sofka.franceTour.reporitory.ITeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.function.Function;

@Service
@RequiredArgsConstructor
public class DeleteTeamByIdUseCase implements Function<String, Mono<Void>> {

    private final ITeamRepository teamRepository;

    @Override
    public Mono<Void> apply(String teamId) {
        return teamRepository
                .findById(teamId)
                .switchIfEmpty(Mono.error(() -> new Throwable("No team found, sorry...")))
                .flatMap(team -> teamRepository
                        .deleteById(teamId));
    }
}
