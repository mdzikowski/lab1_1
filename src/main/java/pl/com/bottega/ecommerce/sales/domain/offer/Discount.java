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

    @Override
    public int hashCode() {
        final int prime = 18;
        int result = 1;
        result = prime * result + cause.hashCode();
        result = prime * result + amount.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Discount discount = (Discount) o;

        if (!cause.equals(discount.cause)) {
            return false;
        }
        if (!amount.equals(discount.amount)) {
            return false;
        }
        return true;
    }
}
