package com.sofka.franceTour.usecase;

import com.sofka.franceTour.reporitory.ICyclistRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.function.Supplier;

@Service
@RequiredArgsConstructor
public class DeleteAllCyclistsUseCase implements Supplier<Mono<Void>> {

    private final ICyclistRepository cyclistRepository;

    @Override
    public Mono<Void> get() {
        return cyclistRepository.deleteAll();
    }
}
