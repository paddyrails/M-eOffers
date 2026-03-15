package com.pp.cs.sales.offers.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class QualifyingOfferRespDto {
    private String offerCode;

    private String productCode;

    private Double basePrice;

    private Double calculatedPrice;

    private Double discountApplied;
}
