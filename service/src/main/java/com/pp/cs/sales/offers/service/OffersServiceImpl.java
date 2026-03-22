package com.pp.cs.sales.offers.service;

import com.pp.cs.sales.offers.common.enums.AvailableChannels;
import com.pp.cs.sales.offers.common.enums.TeamCode;
import com.pp.cs.sales.offers.dao.OfferQualificationsDao;
import com.pp.cs.sales.offers.dao.OffersDao;
import com.pp.cs.sales.offers.dto.CreateOfferReqDto;
import com.pp.cs.sales.offers.dto.QualifyingOfferRespDto;
import com.pp.cs.sales.offers.entity.OfferEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class OffersServiceImpl implements OffersService {

    @Autowired
    private OffersDao offersDao;
    @Autowired
    private OfferQualificationsDao offerQualificationsDao;

    @Override
    public List<QualifyingOfferRespDto> getQualifyingOffers(TeamCode teamCode, AvailableChannels channel) {
        List<OfferEntity> offers = this.offersDao.findAll();
        List<QualifyingOfferRespDto> qualifyingOfferRespDtos = offers.stream().map(offer -> {
            QualifyingOfferRespDto qualifyingOffer = new QualifyingOfferRespDto();
            qualifyingOffer.setCalculatedPrice(offer.getBasePrice() * 0.95);
            qualifyingOffer.setBasePrice(offer.getBasePrice());
            qualifyingOffer.setDiscountApplied(0.5);
            qualifyingOffer.setOfferCode(offer.getOfferCode());
            qualifyingOffer.setProductCode(offer.getProductCode());
            return qualifyingOffer;
        }).toList();

        return qualifyingOfferRespDtos;
    }

    @Override
    public OfferEntity createOffer(CreateOfferReqDto createOfferReqDto) {
        OfferEntity offerEntity = new OfferEntity();
        offerEntity.setId(UUID.randomUUID().toString());
        offerEntity.setOfferCode(createOfferReqDto.getOfferCode());
        offerEntity.setBasePrice(createOfferReqDto.getBasePrice());
        offerEntity.setProductCode(createOfferReqDto.getProductCode());
        offerEntity.setChannel(createOfferReqDto.getChannel());
        OfferEntity createdEntity = this.offersDao.save(offerEntity);
        return createdEntity;
    }
}
