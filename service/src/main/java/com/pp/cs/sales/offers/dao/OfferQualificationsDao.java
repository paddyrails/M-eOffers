package com.pp.cs.sales.offers.dao;

import com.pp.cs.sales.offers.entity.OfferQualificationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OfferQualificationsDao extends JpaRepository<OfferQualificationEntity, String> {
}
