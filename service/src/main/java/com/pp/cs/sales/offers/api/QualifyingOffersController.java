package com.pp.cs.sales.offers.api;

import com.pp.cs.sales.offers.common.enums.AvailableChannels;
import com.pp.cs.sales.offers.common.enums.TeamCode;
import com.pp.cs.sales.offers.dto.QualifyingOfferRespDto;
import com.pp.cs.sales.offers.service.OffersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api/sales/offers/v1/qualify/offers", produces = "application/json")
public class QualifyingOffersController {

    @Autowired
    private OffersService offersService;

    @GetMapping
    public ResponseEntity<List<QualifyingOfferRespDto>> getQualifyingOffers(@RequestParam TeamCode teamCode, @RequestParam AvailableChannels channel){
        List<QualifyingOfferRespDto> qualifyingOffers = this.offersService.getQualifyingOffers(teamCode, channel);

        return ResponseEntity.ok(qualifyingOffers);
    }
}
