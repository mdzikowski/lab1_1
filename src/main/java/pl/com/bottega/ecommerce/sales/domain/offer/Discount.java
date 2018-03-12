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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (discount == null ? 0 : discount.hashCode());
        result = prime * result + (discountCause == null ? 0 : discountCause.hashCode());
        result = prime * result + (int) money.value;
        result = prime * result + (money.currency == null ? 0 : money.currency.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Discount other = (Discount) obj;
        if (discount == null) {
            if (other.discount != null) {
                return false;
            }
        } else if (!discount.equals( other.discount )) {
            return false;
        }
        if (discountCause == null) {
            if (other.discountCause != null) {
                return false;
            }
        } else if (!discountCause.equals( other.discountCause )) {
            return false;
        }
        if (money == null) {
            if (other.money != null) {
                return false;
            }
        } else if (!money.equals( other.money )) {
            return false;
        }
        return true;
    }

}
