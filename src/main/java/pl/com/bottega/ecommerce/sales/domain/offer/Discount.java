package pl.com.bottega.ecommerce.sales.domain.offer;

import java.math.BigDecimal;

public class Discount {
    public Money money;

    public String discountCause;

    public BigDecimal discount;

//    public String currency;

    public Discount(BigDecimal discount, String discountCause, Money money) {
        this.discount = discount;
        this.discountCause = discountCause;
        this.money.value = money.value;
        this.money.currency = money.currency;
    }
}
