package com.rezolve.challenge.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EntranceRegionDTO {

    @NotNull
    private Double latitude;

    @NotNull
    private Double longitude;

}
