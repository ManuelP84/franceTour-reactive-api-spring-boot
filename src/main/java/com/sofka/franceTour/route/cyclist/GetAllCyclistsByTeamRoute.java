package com.sofka.franceTour.route.cyclist;

import com.sofka.franceTour.dto.CyclistDTO;
import com.sofka.franceTour.usecase.cyclist.GetAllCyclistsByTeamUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class GetAllCyclistsByTeamRoute {

    @Bean
    public RouterFunction<ServerResponse> getCyclistByTeam(GetAllCyclistsByTeamUseCase useCase){

        return route(
                GET("/v1/api/get/cyclist/{id}").and(accept(MediaType.APPLICATION_JSON)),
                request -> ServerResponse
                        .status(HttpStatus.OK)
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromPublisher(useCase.apply(request.pathVariable("id")), CyclistDTO.class))
        );
    }
}
