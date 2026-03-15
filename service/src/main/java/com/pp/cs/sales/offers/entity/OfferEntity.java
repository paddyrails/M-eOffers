package com.pp.cs.sales.offers.entity;

import com.pp.cs.sales.offers.common.enums.AvailableChannels;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="Offers")
@Getter
@Setter
@NoArgsConstructor
public class OfferEntity {
    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "offer_code", nullable = false)
    private String offerCode;

    @Column(name = "product_code", nullable = false)
    private  String productCode;

    @Enumerated(EnumType.STRING)
    @Column(name = "channel", nullable = false)
    private AvailableChannels channel;

//    @Column(name = "base_price", nullable = false)
//    private  Double basePrice;
//
//    @Column(name = "calculated_price", nullable = false)
//    private  Double calculatedPrice;
//
//    @Column(name = "discount_applied", nullable = false)
//    private  Double discountApplied;
}
