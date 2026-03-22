package com.pp.cs.sales.offers.graphql;

import com.pp.cs.sales.offers.common.enums.AvailableChannels;
import com.pp.cs.sales.offers.common.enums.TeamCode;
import com.pp.cs.sales.offers.dto.QualifyingOfferRespDto;
import com.pp.cs.sales.offers.service.OffersService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller

public class OffersQueryResolver {

    private final OffersService offersService;

    public OffersQueryResolver(OffersService offersService){
        this.offersService = offersService;
    }

    @QueryMapping
    public List<Offer> qualifyingOffers(
            @Argument TeamCode teamCode,
            @Argument AvailableChannels channel) {
        return this.offersService.getQualifyingOffers(teamCode, channel).stream()
                .map(this::toOffer)
                .toList();
    }

    private Offer toOffer(QualifyingOfferRespDto dto) {
        return new Offer(
                dto.getOfferCode(),
                dto.getProductCode(),
                dto.getBasePrice(),
                dto.getCalculatedPrice(),
                dto.getDiscountApplied()
        );
    }
}
