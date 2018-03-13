package pl.com.bottega.ecommerce.sales.domain.offer;

public class Discount {
    //Simple structure, so public variables
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
