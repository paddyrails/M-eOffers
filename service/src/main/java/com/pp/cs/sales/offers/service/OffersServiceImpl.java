package com.pp.cs.sales.offers.service;

import com.pp.cs.sales.offers.common.enums.AvailableChannels;
import com.pp.cs.sales.offers.common.enums.TeamCode;
import com.pp.cs.sales.offers.dao.OfferQualificationsDao;
import com.pp.cs.sales.offers.dao.OffersDao;
import com.pp.cs.sales.offers.dto.QualifyingOfferRespDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OffersServiceImpl implements OffersService {

    @Autowired
    private OffersDao offersDao;
    @Autowired
    private OfferQualificationsDao offerQualificationsDao;

    @Override
    public List<QualifyingOfferRespDto> getQualifyingOffers(TeamCode teamCode, AvailableChannels channel) {
        return List.of();
    }
}
