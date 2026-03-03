package com.accenture.applicationlocationvehicule.service.dto;

import com.accenture.applicationlocationvehicule.model.enums.Licences;
import com.accenture.applicationlocationvehicule.model.enums.Types;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record BikeRequestDto(

        @NotBlank(message = "bike.brand.null")
        String brand,

        @NotBlank(message = "bike.model.null")
        String model,

        @NotBlank(message = "bike.color.null")
        String color,

        @Positive(message = "bike.dailyRate.invalid")
        Double dailyRate,

        @Positive(message = "bike.mileage.invalid")
        Double mileage,

        @NotNull(message = "bike.active.null")
        Boolean active,

        @NotNull(message = "bike.parkRemove.null")
        Boolean parkRemove,

        Licences licences,

        @Positive(message = "bike.weight.invalid")
        Double weight,

        @NotBlank(message = "bike.frameSize.null")
        String frameSize,

        @NotNull(message = "bike.electric.null")
        Boolean electric,

        @Positive(message = "bike.capacityBattery.invalid")
        Double capacityBattery,

        @Positive(message = "bike.autonomy.invalid")
        Double autonomy,

        @NotNull(message = "bike.discBrake.null")
        Boolean discBrake,

        @NotBlank(message = "bike.types.null")
        Types types
) {

}
