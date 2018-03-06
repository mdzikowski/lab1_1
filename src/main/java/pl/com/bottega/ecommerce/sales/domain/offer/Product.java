package pl.com.bottega.ecommerce.sales.domain.offer;

import java.math.BigDecimal;
import java.util.Date;

public class Product {
    public String productId;

    public BigDecimal productPrice;

    public String productName;

    public Date productSnapshotDate;

    public String productType;

    public int quantity;

    public BigDecimal totalCost;

    public String currency;
}

