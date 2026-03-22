package com.pp.cs.sales.offers.graphql;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * GraphQL-facing shape for {@code type Offer} in schema.graphqls.
 * Class name must match the GraphQL type name so Spring GraphQL can map results.
 */
@Getter
@AllArgsConstructor
public class Offer {

    private final String offerCode;
    private final String productCode;
    private final Double basePrice;
    private final Double calculatedPrice;
    private final Double discountApplied;
}
