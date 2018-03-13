package pl.com.bottega.ecommerce.sales.domain.offer;

import java.math.BigDecimal;

public class Money implements Comparable<Money> {
    //Simple structure, so public variables
    public String currency;
    public BigDecimal value;

    public int compareTo(Money o){
        int checkCurrency = currency.compareTo(o.currency);
        int checkValue = value.compareTo(o.value);
        if (checkCurrency!=0){
            return checkCurrency;
        }
        if(checkValue == 0) {
            return currency.compareTo(o.currency);
        }
        else {
            return checkValue;
        }
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (currency == null ? 0 : currency.hashCode());
        result = prime * result + (value == null ? 0 : value.hashCode());
        return result;
    }
}
