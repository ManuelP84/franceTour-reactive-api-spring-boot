package com.sofka.franceTour.usecase.cyclist;

import com.sofka.franceTour.reporitory.ICyclistRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Mono;

import java.util.function.Function;

@Configuration
@RequiredArgsConstructor
public class DeleteAllCyclistsByTeamIdUseCase implements Function<String, Mono<Void>> {

    private final ICyclistRepository cyclistRepository;

    @Override
    public Mono<Void> apply(String teamId) {
        return cyclistRepository.deleteAllByTeamId(teamId);
    }
}
