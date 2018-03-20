package pl.com.bottega.ecommerce.sales.domain.offer;

import java.util.Date;

public class Product {

    private String productId;

    private String productName;

    private Date productSnapshotDate;

    private String productType;

    public Product(String productId, String productName, Date productSnapshotDate, String productType) {
        super();
        this.productId = productId;
        this.productName = productName;
        this.productSnapshotDate = productSnapshotDate;
        this.productType = productType;
    }

    public String getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public Date getProductSnapshotDate() {
        return productSnapshotDate;
    }

    public String getProductType() {
        return productType;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (productId == null ? 0 : productId.hashCode());
        result = prime * result + (productName == null ? 0 : productName.hashCode());
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
        Product other = (Product) obj;
        if (productId == null) {
            if (other.productId != null) {
                return false;
            }
        } else if (!productId.equals(other.productId)) {
            return false;
        }
        if (productName == null) {
            if (other.productName != null) {
                return false;
            }
        } else if (!productName.equals(other.productName)) {
            return false;
        }
        if (productSnapshotDate == null) {
            if (other.productSnapshotDate != null) {
                return false;
            }
        } else if (!productSnapshotDate.equals(other.productSnapshotDate)) {
            return false;
        }
        if (productType == null) {
            if (other.productType != null) {
                return false;
            }
        } else if (!productType.equals(other.productType)) {
            return false;
        }
        return true;
    }

}
