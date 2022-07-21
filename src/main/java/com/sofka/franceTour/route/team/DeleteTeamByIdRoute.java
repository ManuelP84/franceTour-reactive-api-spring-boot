package com.sofka.franceTour.route.team;

import com.sofka.franceTour.usecase.cyclist.DeleteAllCyclistsByTeamIdUseCase;
import com.sofka.franceTour.usecase.team.DeleteTeamByIdUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.DELETE;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class DeleteTeamByIdRoute {

    @Bean
    public RouterFunction<ServerResponse> deleteTeamById(
            DeleteTeamByIdUseCase deleteTeamByIdUseCase,
            DeleteAllCyclistsByTeamIdUseCase deleteAllCyclistsByTeamIdUseCase
    ){
        return route(
                DELETE("/v1/api/delete/team/{id}").and(accept(MediaType.APPLICATION_JSON)),
                request -> deleteTeamByIdUseCase.apply(request.pathVariable("id"))
                        .flatMap(unused -> ServerResponse.status(HttpStatus.ACCEPTED).build())
                        .onErrorResume(error -> ServerResponse.status(HttpStatus.BAD_REQUEST).build())
        );
    }
}
