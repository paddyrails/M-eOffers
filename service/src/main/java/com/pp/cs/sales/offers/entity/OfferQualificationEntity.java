package com.pp.cs.sales.offers.entity;

import com.pp.cs.sales.offers.common.Rules;
import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

@Entity
@Table(name = "Offer_Qualifications")
public class OfferQualificationEntity {

    @Id
    @Column(name = "id")
    private String id;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    private OfferEntity offer;

    @Column(name = "year1", nullable = false)
    private Integer year1;

    @Column(name = "year2", nullable = false)
    private  Integer year2;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "rules", columnDefinition = "jsonb")
    private Rules rules;
}
