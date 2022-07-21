package com.sofka.franceTour.usecase.team;

import com.sofka.franceTour.dto.TeamDTO;
import com.sofka.franceTour.mapper.TeamMapper;
import com.sofka.franceTour.reporitory.ITeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.function.Function;

@Service
@RequiredArgsConstructor
public class GetAllTeamsByCountryUseCase implements Function<String, Flux<TeamDTO>> {

    private final ITeamRepository teamRepository;
    private final TeamMapper teamMapper;


    @Override
    public Flux<TeamDTO> apply(String country) {
        return teamRepository
                .findAllByCountry(country)
                .map(team -> teamMapper.turnEntityToDTO().apply(team));
    }
}
