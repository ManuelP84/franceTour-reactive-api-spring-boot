package com.sofka.franceTour.usecase.cyclist;

import com.sofka.franceTour.reporitory.ICyclistRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.function.Function;

@Service
@RequiredArgsConstructor
public class DeleteCyclistByIdUsecase implements Function<String, Mono<Void>> {

    private final ICyclistRepository cyclistRepository;

    @Override
    public Mono<Void> apply(String cyclistId) {
        return cyclistRepository
                .findByCyclistId(cyclistId)
                .switchIfEmpty(Mono.error(() -> new Throwable("No cyclist found, sorry...")))
                .flatMap(cyclist -> cyclistRepository.deleteByCyclistId(cyclistId));
    }
}
