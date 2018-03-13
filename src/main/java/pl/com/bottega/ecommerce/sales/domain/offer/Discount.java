package pl.com.bottega.ecommerce.sales.domain.offer;

public class Discount {
    public Money money;

    public String cause;

    public Discount(Money discount, String discountCause) {
        this.money = discount;
        this.cause = discountCause;
    }

    public Money getMoney() {
        return money;
    }

    public String getCause() {
        return cause;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (money == null ? 0 : money.hashCode());
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
        if (money == null) {
            if (other.money != null) {
                return false;
            }
        } else if (!money.equals( other.money )) {
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
