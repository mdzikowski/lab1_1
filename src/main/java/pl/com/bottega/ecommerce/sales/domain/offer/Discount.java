package pl.com.bottega.ecommerce.sales.domain.offer;

import java.math.BigDecimal;

public class Discount {
    private String cause;
    private BigDecimal value;

    public Discount(String discountCause, BigDecimal discount) {
        this.cause = discountCause;
        this.value = discount;
    }

    public String getCause() {
        return cause;
    }

    public BigDecimal getValue() {
        return value;
    }
}
