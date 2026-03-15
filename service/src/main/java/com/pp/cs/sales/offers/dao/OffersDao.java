package com.pp.cs.sales.offers.dao;

import com.pp.cs.sales.offers.entity.OfferEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OffersDao extends JpaRepository<OfferEntity, String> {
}
