package com.sofka.franceTour.route.cyclist;

import com.sofka.franceTour.usecase.cyclist.DeleteAllCyclistsByTeamIdUseCase;
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
public class DeleteAllCyclistsByTeamIdRoute {

    @Bean
    public RouterFunction<ServerResponse> deleteAllCyclistsByTeamId(DeleteAllCyclistsByTeamIdUseCase useCase){
        return route(
                DELETE("/v1/api/delete/all/cyclist/{id}").and(accept(MediaType.APPLICATION_JSON)),
                request -> useCase.apply(request.pathVariable("id"))
                        .flatMap(unused -> ServerResponse.status(HttpStatus.ACCEPTED).build())
                        .onErrorResume(error -> ServerResponse.status(HttpStatus.NOT_FOUND).build())
        );
    }
}
