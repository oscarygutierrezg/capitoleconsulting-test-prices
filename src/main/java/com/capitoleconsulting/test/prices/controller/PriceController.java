package com.capitoleconsulting.test.prices.controller;

import com.capitoleconsulting.test.prices.dto.ApiResponseErrorDto;
import com.capitoleconsulting.test.prices.dto.PriceDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;

@Tag(name = "Price Controller", description = "Se encarga de manejar las tarifas.")
@RequestMapping(value = "/v1/price")
public interface PriceController {

    @GetMapping("/current")
    @Operation(summary = "Obtiene la tarifa actual", description = "Este servicio retorna la tarifa actual de un producto, cadena y fecha")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Datos encontrados", content = {
                    @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = PriceDto.class)))}),
            @ApiResponse(responseCode = "404", description = "Resultado vacío", content = {
                    @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = ApiResponseErrorDto.class)))}),
            @ApiResponse(responseCode = "500", description = "Error interno en el servidor al buscar los datos", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ApiResponseErrorDto.class))})})
    ResponseEntity<PriceDto> finrCurrentPrice(
            @RequestParam @NotNull @Positive Long productId,
            @RequestParam @NotNull @Positive Long brandId,
            @RequestParam @NotNull LocalDateTime now
    );
}
