package com.pp.cs.sales.offers.service;

import com.pp.cs.sales.offers.common.enums.AvailableChannels;
import com.pp.cs.sales.offers.common.enums.TeamCode;
import com.pp.cs.sales.offers.dto.QualifyingOfferRespDto;

import java.util.List;

public interface OffersService {
    public List<QualifyingOfferRespDto> getQualifyingOffers(TeamCode teamCode, AvailableChannels channel);
}
