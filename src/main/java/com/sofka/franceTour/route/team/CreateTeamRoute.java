package com.sofka.franceTour.route.team;

import com.sofka.franceTour.dto.TeamDTO;
import com.sofka.franceTour.usecase.team.CreateTeamUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class CreateTeamRoute {

    @Bean
    public RouterFunction<ServerResponse> createTeam(CreateTeamUseCase useCase){
        return route(
                POST("/v1/api/create/team").and(accept(MediaType.APPLICATION_JSON)),
                request -> request.bodyToMono(TeamDTO.class)
                        .flatMap(teamDTO -> useCase.apply(teamDTO))
                        .flatMap(teamDTO -> ServerResponse.status(HttpStatus.OK)
                                .contentType(MediaType.APPLICATION_JSON)
                                .bodyValue(teamDTO))
        );
    }
}
