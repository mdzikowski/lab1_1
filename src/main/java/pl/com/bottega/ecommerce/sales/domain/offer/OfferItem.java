/*
 * Copyright 2011-2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */
package pl.com.bottega.ecommerce.sales.domain.offer;

import java.math.BigDecimal;

public class OfferItem{
    //private variables
    private Money totalCost;
    private int quantity;
    private Product product;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    private Discount discountObject=null;
    public OfferItem(Product product, int quantity, Money totalCost) {
        this(product, quantity, totalCost,null);
    }
    public OfferItem(Product product,
                     int quantity,
                     Money totalCost,
                     Discount discountObject) {
        product.productId = product.productId;
        product.productPrice = product.productPrice;
        product.productName = product.productName;
        product.productSnapshotDate = product.productSnapshotDate;
        product.productType = product.productType;
        this.totalCost=totalCost;
        this.quantity = quantity;
        this.discountObject = discountObject;

        BigDecimal discountValue = new BigDecimal(0);
        if (discountObject != null) {
            discountValue = discountValue.subtract(discountObject.money.value);
        }

        this.totalCost.value = product.productPrice.value.multiply(new BigDecimal(quantity)).subtract(discountValue);
    }

    public Money getTotalCost() {
        return totalCost;
    }

    public Discount getDiscountObject() {
        return discountObject;
    }

    public int getQuantity() {
        return quantity;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + super.hashCode();
        result = prime * result + quantity;
        result = prime * result + (totalCost == null ? 0 : totalCost.hashCode());
        result = prime * result + (discountObject == null ? 0 : discountObject.hashCode());
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
        if (discountObject == null) {
            if (other.discountObject != null) {
                return false;
            }
        } else if (!discountObject.equals(other.discountObject)) {
            return false;
        }
        if (quantity != other.quantity) {
            return false;
        }
        if (totalCost == null) {
            if (other.totalCost != null) {
                return false;
            }
        } else if (!totalCost.equals(other.totalCost)) {
            return false;
        }
        return true;
    }

    /**
     *
     * @param item
     * @param delta
     *            acceptable percentage difference
     * @return
     */
    public boolean sameAs(OfferItem other, double delta) {
        boolean checkBoolean = super.hashCode() == other.hashCode();
        if (!checkBoolean){
            return false;
        }

        if (quantity != other.quantity) {
            return false;
        }
        BigDecimal max;
        BigDecimal min;
        if (totalCost.value.compareTo(other.totalCost.value) > 0) {
            max = totalCost.value;
            min = other.totalCost.value;
        } else {
            max = other.totalCost.value;
            min = totalCost.value;
        }

        BigDecimal difference = max.subtract(min);
        BigDecimal acceptableDelta = max.multiply(BigDecimal.valueOf(delta / 100));

        return acceptableDelta.compareTo(difference) > 0;
    }

}
