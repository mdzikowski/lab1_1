package pl.com.bottega.ecommerce.sales.domain.offer;

import java.math.BigDecimal;

public class Money implements Comparable<Money> {
    public String currency;
    public BigDecimal value;

    public int compareTo(Money o){
        int checkValue = value.compareTo(o.value);

        if(checkValue == 0) {
            return currency.compareTo(o.currency);
        }
        else {
            return checkValue;
        }
    }
}
