package pl.com.bottega.ecommerce.sales.domain.offer;


import java.math.BigDecimal;

public class Money {
    private String currency;
    private BigDecimal value;

    public Money (BigDecimal value, String currency){
        this.value = value;
        this.currency = currency;
    }

    public BigDecimal getValue() {
        return value;
    }

    public String getCurrency() {
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
        if (currency == null) {
                if (other.currency != null) {
                        return false;
                    }
            } else if (!currency.equals(other.currency)) {
                return false;
            }
        if (value == null) {
                if (other.value != null) {
                        return false;
                    }
            } else if (!value.equals(other.value)) {
                return false;
            }
        return true;
    }
}
