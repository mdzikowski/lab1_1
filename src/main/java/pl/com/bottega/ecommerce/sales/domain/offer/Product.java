package pl.com.bottega.ecommerce.sales.domain.offer;

import java.util.Date;

public class Product {

    private String productId;

    private Money productPrice;

    private String productName;

    private Date productSnapshotDate;

    private String productType;

    public String getProductId() {
        return productId;
    }

    public Money getProductPrice() {
        return productPrice;
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
        result = prime * result + (productPrice == null ? 0 : productPrice.hashCode());
        result = prime * result + (productName == null ? 0 : productName.hashCode());
        result = prime * result + (productSnapshotDate == null ? 0 : productSnapshotDate.hashCode());
        result = prime * result + (productType == null ? 0 : productType.hashCode());
        return result;
    }

}
