package pl.com.bottega.ecommerce.sales.domain.offer;

import java.math.BigDecimal;

public class Money {
    public BigDecimal value;

    public String currency;

    public Money(BigDecimal value, String currency){
        this.value = value;
        this.currency = currency;
    }

    public BigDecimal getValue() {
        return value;
    }
    public String getCurrency(){
        return currency;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (value == null ? 0 : value.hashCode());
        result = prime * result + (currency == null ? 0 : currency.hashCode());
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
        Money other = (Money) obj;
        if (value == null) {
            if (other.getValue() != null) {
                return false;
            }
        } else if (!value.equals( other.getValue() )) {
            return false;
        }
        if (currency == null) {
            if (other.getCurrency() != null) {
                return false;
            }
        } else if (!currency.equals( other.getCurrency() )) {
            return false;
        }
        return true;
    }


}
