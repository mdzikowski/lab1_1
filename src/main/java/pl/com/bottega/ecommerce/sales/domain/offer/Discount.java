package pl.com.bottega.ecommerce.sales.domain.offer;

import java.math.BigDecimal;

public class Discount {
    public String discountCause;

    public Money money;

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (money == null ? 0 : money.hashCode());
        result = prime * result + (discountCause == null ? 0 : discountCause.hashCode());
        return result;
    }
}
