package com.sofka.franceTour.usecase;

import com.sofka.franceTour.dto.CyclistDTO;
import com.sofka.franceTour.mapper.CyclistMapper;
import com.sofka.franceTour.reporitory.ICyclistRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.function.Function;

@Service
@RequiredArgsConstructor
public class AddCyclistUseCase implements Function<CyclistDTO, Mono<CyclistDTO>> {

    private final ICyclistRepository cyclistRepository;
    private final CyclistMapper cyclistMapper;

    @Override
    public Mono<CyclistDTO> apply(CyclistDTO cyclistDTO) {
        return cyclistRepository
                .save(cyclistMapper.turnDTOToEntity().apply(cyclistDTO))
                .map(cyclist -> cyclistMapper.turnEntityToDTO().apply(cyclist));
    }
}
