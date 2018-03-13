package pl.com.bottega.ecommerce.sales.domain.offer;

import java.math.BigDecimal;
import java.util.Date;

public class Product {
    //Simple structure, so public variables
    public String productId;

    public Money productPrice;

    public String productName;

    public Date productSnapshotDate;

    public String productType;

@Override
public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + (productId == null ? 0 : productId.hashCode());
    result = prime * result + (productName == null ? 0 : productName.hashCode());
    result = prime * result + (productPrice == null ? 0 : productPrice.hashCode());
    result = prime * result + (productSnapshotDate == null ? 0 : productSnapshotDate.hashCode());
    result = prime * result + (productType == null ? 0 : productType.hashCode());
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
        OfferItem other = (OfferItem) obj;
        if (productName == null) {
            if (other.productName != null) {
                return false;
            }
        } else if (!productName.equals(other.productName)) {
            return false;
        }
        if (productPrice == null) {
            if (other.productPrice != null) {
                return false;
            }
        } else if (!productPrice.equals(other.productPrice)) {
            return false;
        }
        if (productId == null) {
            if (other.productId != null) {
                return false;
            }
        } else if (!productId.equals(other.productId)) {
            return false;
        }
        if (productType != other.productType) {
            return false;
        }
        return true;
    }

}
