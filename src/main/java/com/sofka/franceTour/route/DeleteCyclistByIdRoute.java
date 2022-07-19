package com.sofka.franceTour.route;

import com.sofka.franceTour.usecase.DeleteCyclistByIdUsecase;
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
public class DeleteCyclistByIdRoute {

    @Bean
    public RouterFunction<ServerResponse> deleteCyclistById(DeleteCyclistByIdUsecase usecase){
        return route(
                DELETE("/v1/api/delete/cyclist/{id}").and(accept(MediaType.APPLICATION_JSON)),
                request -> usecase.apply(request.pathVariable("id"))
                        .flatMap(unused -> ServerResponse.status(HttpStatus.ACCEPTED).build())
                        .onErrorResume(error -> ServerResponse.status(HttpStatus.NOT_FOUND).build())
        );
    }
}
