package com.accenture.applicationlocationvehicule.controller;

import com.accenture.applicationlocationvehicule.controller.advice.ErrorDto;
import com.accenture.applicationlocationvehicule.service.dto.VehicleRequestDto;
import com.accenture.applicationlocationvehicule.service.dto.VehicleResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Vehicle", description = "API management Vehicle")
@RequestMapping("/vehicles")
public interface VehicleApi {

    @Operation(summary = "List all vehicles")
    @ApiResponse(responseCode = "200", description = "List of vehicles")
    @GetMapping
    ResponseEntity<List<VehicleResponseDto>> getVehicles();

    @Operation(summary = "Recovered vehicle by id")
    @ApiResponse(responseCode = "200", description = "Vehicle found")
    @ApiResponse(responseCode = "404", description = "Vehicle not found",
            content = @Content(schema = @Schema(implementation = ErrorDto.class)))
    @GetMapping("/{id}")
    ResponseEntity<VehicleResponseDto> getVehicleById(
            @Parameter(description = "ID vehicle", required = true)
            @PathVariable("id") int idVehicle);

    @Operation(summary = "Add new vehicle")
    @ApiResponse(responseCode = "201", description = "Vehicle created")
    @ApiResponse(responseCode = "400", description = "Invalid request",
            content = @Content(schema = @Schema(implementation = ErrorDto.class)))
    @PostMapping
    ResponseEntity<Void> addVehicle(@RequestBody VehicleRequestDto requestDto);

    @Operation(summary = "Delete vehicle by id")
    @ApiResponse(responseCode = "204", description = "Vehicle deleted")
    @ApiResponse(responseCode = "404", description = "Vehicle not found",
            content = @Content(schema = @Schema(implementation = ErrorDto.class)))
    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteVehicle(
            @Parameter(description = "ID vehicle", required = true)
            @PathVariable("id") int idVehicle);

    @Operation(summary = "Completely replace vehicle (PUT)")
    @ApiResponse(responseCode = "200", description = "Vehicle updated")
    @ApiResponse(responseCode = "404", description = "Vehicle not found",
            content = @Content(schema = @Schema(implementation = ErrorDto.class)))
    @ApiResponse(responseCode = "400", description = "Invalid request",
            content = @Content(schema = @Schema(implementation = ErrorDto.class)))
    @PutMapping("/{id}")
    ResponseEntity<VehicleResponseDto> putVehicle(
            @Parameter(description = "ID vehicle", required = true)
            @PathVariable("id") int idVehicle,
            @RequestBody VehicleRequestDto requestDto);

    @Operation(summary = "Partially update vehicle (PATCH)")
    @ApiResponse(responseCode = "200", description = "Vehicle partially updated")
    @ApiResponse(responseCode = "404", description = "Vehicle not found",
            content = @Content(schema = @Schema(implementation = ErrorDto.class)))
    @PatchMapping("/{id}")
    ResponseEntity<VehicleResponseDto> patchVehicle(
            @Parameter(description = "ID vehicle", required = true)
            @PathVariable("id") int idVehicle,
            @RequestBody VehicleRequestDto requestDto);
}
