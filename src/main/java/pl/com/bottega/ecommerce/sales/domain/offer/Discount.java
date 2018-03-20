package pl.com.bottega.ecommerce.sales.domain.offer;

public class Discount {
    public Money discountPrice;

    public String cause;

    public Discount(Money discount, String discountCause) {
        this.discountPrice = discount;
        this.cause = discountCause;
    }

    public Money getDiscountPrice() {
        return discountPrice;
    }

    public String getCause() {
        return cause;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (discountPrice == null ? 0 : discountPrice.hashCode());
        result = prime * result + (cause == null ? 0 : cause.hashCode());
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
        if (discountPrice == null) {
            if (other.discountPrice != null) {
                return false;
            }
        } else if (!discountPrice.equals( other.discountPrice )) {
            return false;
        }
        if (cause == null) {
            if (other.cause != null) {
                return false;
            }
        } else if (!cause.equals( other.cause )) {
            return false;
        }
        return true;
    }

}
