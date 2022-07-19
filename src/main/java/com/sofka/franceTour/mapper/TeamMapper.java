package com.sofka.franceTour.mapper;

import com.sofka.franceTour.dto.TeamDTO;
import com.sofka.franceTour.entity.Team;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
@RequiredArgsConstructor
public class TeamMapper {

    private final ModelMapper modelMapper;

    public Function<Team, TeamDTO> turnEntityToDTO(){
        return team -> modelMapper.map(team, TeamDTO.class);
    }

    public Function<TeamDTO, Team> turnDTOtoEntity(){
        return teamDTO -> modelMapper.map(teamDTO, Team.class);
    }
}
