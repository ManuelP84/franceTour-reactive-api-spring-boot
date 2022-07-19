package com.sofka.franceTour.route;

import com.sofka.franceTour.dto.CyclistDTO;
import com.sofka.franceTour.usecase.UpdateCyclistUseCase;
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
public class UpdateCyclistRoute {

    @Bean
    public RouterFunction<ServerResponse> updateCyclist(UpdateCyclistUseCase useCase){
        return route(
                PUT("/v1/api/update/cyclist").and(accept(MediaType.APPLICATION_JSON)),
                request -> request.bodyToMono(CyclistDTO.class)
                        .flatMap(cyclistDTO -> useCase.apply(cyclistDTO))
                        .flatMap(cyclistDTO -> ServerResponse
                                .status(HttpStatus.ACCEPTED)
                                .contentType(MediaType.APPLICATION_JSON)
                                .bodyValue(cyclistDTO))
                        .onErrorResume(error -> ServerResponse.status(HttpStatus.BAD_REQUEST).build())
        );
    }
}
