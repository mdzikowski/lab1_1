package pl.com.bottega.ecommerce.sales.domain.offer;

import java.math.BigDecimal;
import java.util.Date;

public class Product {
    private String id;

    private Money price;

    private String name;

    private Date snapshotDate;

    private String type;

    public Product(String id, String currency, BigDecimal price, String name, Date snapshotDate,
                   String type) {
        this.id = id;
        this.price = new Money(currency, price);
        this.name = name;
        this.snapshotDate = snapshotDate;
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public Money getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public Date getSnapshotDate() {
        return snapshotDate;
    }

    public String getType() {
        return type;
    }

    @Override
    public int hashCode() {
        final int prime = 16;
        int result = 1;
        result = prime * result + id.hashCode();
        result = prime * result + price.hashCode();
        result = prime * result + name.hashCode();
        result = prime * result + snapshotDate.hashCode();
        result = prime * result + type.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (!id.equals(product.id)) {
            return false;
        }
        if (!price.equals(product.price)) {
            return false;
        }
        if (!name.equals(product.name)) {
            return false;
        }
        if (!snapshotDate.equals(product.snapshotDate)) {
            return false;
        }
        if (!type.equals(product.type)) {
            return false;
        }
        return true;
    }
}
