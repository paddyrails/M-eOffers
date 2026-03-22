package com.pp.cs.sales.offers.dto;

import com.pp.cs.sales.offers.common.enums.AvailableChannels;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CreateOfferReqDto {
    private String id;

    private String offerCode;

    private  String productCode;

    private AvailableChannels channel;

    private  Double basePrice;
}
