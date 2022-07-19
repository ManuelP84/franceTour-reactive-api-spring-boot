package com.sofka.franceTour.route;

import com.sofka.franceTour.usecase.DeleteAllCyclistsUseCase;
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
public class DeleteAllCyclistsRoute {

    @Bean
    public RouterFunction<ServerResponse> deleteAllCyclists(DeleteAllCyclistsUseCase useCase){
        return route(
                DELETE("/v1/api/delete/cyclist/all").and(accept(MediaType.APPLICATION_JSON)),
                request -> useCase.get().flatMap(unused -> ServerResponse.status(HttpStatus.ACCEPTED).build())
        );
    }
}
