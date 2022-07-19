package com.sofka.franceTour.mapper;

import com.sofka.franceTour.dto.CyclistDTO;
import com.sofka.franceTour.entity.Cyclist;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
@RequiredArgsConstructor
public class CyclistMapper {

    private final ModelMapper modelMapper;

    public Function<Cyclist, CyclistDTO> turnEntityToDTO(){
        return cyclist -> modelMapper.map(cyclist, CyclistDTO.class);
    }

    public Function<CyclistDTO, Cyclist> turnDTOToEntity(){
        return cyclistDTO -> modelMapper.map(cyclistDTO, Cyclist.class);
    }
}


