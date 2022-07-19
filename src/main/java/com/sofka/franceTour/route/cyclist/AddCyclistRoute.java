package com.sofka.franceTour.route.cyclist;

import com.sofka.franceTour.dto.CyclistDTO;
import com.sofka.franceTour.usecase.cyclist.AddCyclistUseCase;
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
public class AddCyclistRoute {

    @Bean
    public RouterFunction<ServerResponse> addCyclist(AddCyclistUseCase useCase){
        return route(
                POST("/v1/api/add/cyclist").and(accept(MediaType.APPLICATION_JSON)),
                request -> request.bodyToMono(CyclistDTO.class)
                        .flatMap(cyclistDTO -> useCase.apply(cyclistDTO))
                        .flatMap(cyclistDTO -> ServerResponse.status(HttpStatus.CREATED)
                                .contentType(MediaType.APPLICATION_JSON)
                                .bodyValue(cyclistDTO))
        );
    }
}
