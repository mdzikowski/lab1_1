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

public class OfferItem {

    private Product product;

    private int quantity;

    private Money money;

    private Discount discount;

    public OfferItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public OfferItem(Product product, int quantity, Discount discount) {
        this.product = product;
        this.quantity = quantity;
        this.discount = discount;

        this.money.setCost(
                product.getProductPrice().multiply(new BigDecimal(quantity)).subtract(discount.getDiscountValue()));
    }

    public Product getProduct() {
        return product;
    }

    public Discount getDiscount() {
        return discount;
    }

    public int getQuantity() {
        return quantity;
    }

    public Money getMoney() {
        return money;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (discount == null ? 0 : discount.hashCode());
        result = prime * result + (product == null ? 0 : product.hashCode());
        result = prime * result + (money == null ? 0 : money.hashCode());
        result = prime * result + quantity;
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
        if (discount == null) {
            if (other.discount != null) {
                return false;
            }
        } else if (!discount.equals(other.discount)) {
            return false;
        }
        if (product == null) {
            if (other.product != null) {
                return false;
            }
        } else if (!product.equals(other.product)) {
            return false;
        }
        if (money == null) {
            if (other.money != null) {
                return false;
            }
        } else if (!money.equals(other.money)) {
            return false;
        }
        if (quantity != other.quantity) {
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
        if (quantity != other.quantity) {
            return false;
        }

        BigDecimal max;
        BigDecimal min;
        if (money.getCost().compareTo(other.getMoney().getCost()) > 0) {
            max = money.getCost();
            min = other.getMoney().getCost();
        } else {
            max = other.getMoney().getCost();
            min = money.getCost();
        }

        BigDecimal difference = max.subtract(min);
        BigDecimal acceptableDelta = max.multiply(BigDecimal.valueOf(delta / 100));

        return acceptableDelta.compareTo(difference) > 0;
    }

}
