package pl.com.bottega.ecommerce.sales.domain.offer;

import java.math.BigDecimal;

public class Discount {
    public String discountCause;

    public BigDecimal discount;

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (discount == null ? 0 : discount.hashCode());
        result = prime * result + (discountCause == null ? 0 : discountCause.hashCode());
        return result;
    }
}
