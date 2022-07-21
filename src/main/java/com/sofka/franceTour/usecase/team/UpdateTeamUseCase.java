package com.sofka.franceTour.usecase.team;

import com.sofka.franceTour.dto.TeamDTO;
import com.sofka.franceTour.mapper.TeamMapper;
import com.sofka.franceTour.reporitory.ITeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.function.Function;

@Service
@RequiredArgsConstructor
public class UpdateTeamUseCase implements Function<TeamDTO, Mono<TeamDTO>> {

    private final ITeamRepository teamRepository;
    private final TeamMapper teamMapper;


    @Override
    public Mono<TeamDTO> apply(TeamDTO teamDTO) {
        return teamRepository
                .findById(teamDTO.getId())
                .flatMap(team -> teamRepository.save(teamMapper.turnDTOtoEntity().apply(teamDTO)))
                .map(team -> teamMapper.turnEntityToDTO().apply(team))
                .switchIfEmpty(Mono.error(() -> new Throwable("No team found...Sorry")));
    }
}
