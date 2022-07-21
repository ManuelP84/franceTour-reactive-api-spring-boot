package com.sofka.franceTour.route.team;

import com.sofka.franceTour.dto.CyclistDTO;
import com.sofka.franceTour.dto.TeamDTO;
import com.sofka.franceTour.usecase.cyclist.UpdateCyclistUseCase;
import com.sofka.franceTour.usecase.team.UpdateTeamUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.PUT;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class UpdateTeamRoute {

    @Bean
    public RouterFunction<ServerResponse> updateTeam(UpdateTeamUseCase useCase){
        return route(
                PUT("/v1/api/update/team").and(accept(MediaType.APPLICATION_JSON)),
                request -> request.bodyToMono(TeamDTO.class)
                        .flatMap(teamDTO -> useCase.apply(teamDTO))
                        .flatMap(teamDTO -> ServerResponse
                                .status(HttpStatus.ACCEPTED)
                                .contentType(MediaType.APPLICATION_JSON)
                                .bodyValue(teamDTO))
                        .onErrorResume(error -> ServerResponse.status(HttpStatus.BAD_REQUEST).build())
        );
    }
}
