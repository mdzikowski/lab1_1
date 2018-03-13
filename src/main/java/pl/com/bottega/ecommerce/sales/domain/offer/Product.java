package pl.com.bottega.ecommerce.sales.domain.offer;

import java.math.BigDecimal;
import java.util.Date;

public class Product {
    public String id;

    public BigDecimal price;

    public String name;

    public Date snapshotDate;

    public String type;

    public BigDecimal totalCost;

    public Money money;

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (name == null ? 0 : name.hashCode());
        result = prime * result + (price == null ? 0 : price.hashCode());
        result = prime * result + (id == null ? 0 : id.hashCode());
        result = prime * result + (type == null ? 0 : type.hashCode());
        result = prime * result + (totalCost == null ? 0 : totalCost.hashCode());
        result = prime * result + (money == null ? 0 : money.hashCode());
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
        Product other = (Product) obj;
        if (name == null) {
            if (other.name != null) {
                return false;
            }
        } else if (!name.equals( other.name )) {
            return false;
        }
        if (price == null) {
            if (other.price != null) {
                return false;
            }
        } else if (!price.equals( other.price )) {
            return false;
        }
        if (id == null) {
            if (other.id != null) {
                return false;
            }
        } else if (!id.equals( other.id )) {
            return false;
        }
        if (type != other.type) {
            return false;
        }
        if (totalCost == null) {
            if (other.totalCost != null) {
                return false;
            }
        } else if (!totalCost.equals( other.totalCost )) {
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

