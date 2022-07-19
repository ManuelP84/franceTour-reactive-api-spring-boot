package com.sofka.franceTour.usecase.cyclist;

import com.sofka.franceTour.dto.CyclistDTO;
import com.sofka.franceTour.mapper.CyclistMapper;
import com.sofka.franceTour.reporitory.ICyclistRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.function.Supplier;

@Service
@RequiredArgsConstructor
public class GetAllCyclistsUseCase implements Supplier {

    private final ICyclistRepository cyclistRepository;
    private final CyclistMapper cyclistMapper;

    @Override
    public Flux<CyclistDTO> get() {
        return cyclistRepository
                .findAll()
                .map(cyclist -> cyclistMapper.turnEntityToDTO().apply(cyclist));
    }
}
