package pl.com.bottega.ecommerce.sales.domain.offer;

import java.math.BigDecimal;

public class Discount {
    private String cause;
    private Money amount;

    public Discount(String discountCause, String currency, BigDecimal value) {
        this.cause = discountCause;
        this.amount = new Money(currency, value);
    }

    public String getCause() {
        return cause;
    }

    public Money getAmount() {
        return amount;
    }
}
