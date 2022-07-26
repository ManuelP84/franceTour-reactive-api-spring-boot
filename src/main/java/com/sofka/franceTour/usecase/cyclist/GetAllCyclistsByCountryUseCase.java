package com.sofka.franceTour.usecase.cyclist;

import com.sofka.franceTour.dto.CyclistDTO;
import com.sofka.franceTour.mapper.CyclistMapper;
import com.sofka.franceTour.reporitory.ICyclistRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.function.Function;

@Service
@RequiredArgsConstructor
public class GetAllCyclistsByCountryUseCase implements Function<String, Flux<CyclistDTO>> {

    private final ICyclistRepository cyclistRepository;
    private final CyclistMapper cyclistMapper;

    @Override
    public Flux<CyclistDTO> apply(String country) {
        return cyclistRepository
                .findAllByCountry(country)
                .map(cyclist -> cyclistMapper.turnEntityToDTO().apply(cyclist));
    }
}
