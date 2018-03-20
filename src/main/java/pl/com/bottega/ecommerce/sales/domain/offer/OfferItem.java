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

    private Discount discount;

    private Money totalCost;

    public OfferItem(Product product, int quantity) {
        this(product, quantity, null, null);
    }

    public OfferItem(Product product, int quantity, BigDecimal discountValue, String discountCause) {
        this.product = product;

        this.quantity = quantity;


        if(discountValue != null && discountCause != null) {
            this.discount = new Discount(discountCause, product.getPrice().getCurrency(), discountValue);
        }

        BigDecimal discValue = new BigDecimal(0);
        if (discount != null) {
            discValue = discount.getAmount().getValue();
        }

        BigDecimal totalValue = product.getPrice().getValue().multiply(new BigDecimal(quantity)).subtract(discValue);
        this.totalCost = new Money(product.getPrice().getCurrency(), totalValue);
    }

    public Money getTotalCost() {
        return totalCost;
    }

    public Discount getDiscount() {
        return discount;
    }

    public int getQuantity() {
        return quantity;
    }

    public Product getProduct() {
        return product;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (discount == null ? 0 : discount.hashCode());
        result = prime * result + product.hashCode();
        result = prime * result + quantity;
        result = prime * result + totalCost.hashCode();
        return result;
    }

    //different currencies! -> change in product and discount
    //javadoc what does equals and what does sameAs
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OfferItem offerItem = (OfferItem) o;

        if (quantity != offerItem.quantity) {
            return false;
        }
        if (!product.equals(offerItem.product)) {
            return false;
        }
        if (discount != null ? !discount.equals(offerItem.discount) : offerItem.discount != null) {
            return false;
        }
        if (!totalCost.equals(offerItem.totalCost)) {
            return false;
        }
        return true;
    }

    /**
     *
     * @param other
     * @param delta acceptable percentage difference
     * @return
     */
    public boolean sameAs(OfferItem other, double delta) {
        if (!product.equals(other.product)){
            return false;
        }

        if (quantity != other.quantity) {
            return false;
        }

        if (!totalCost.getCurrency().equals(other.totalCost.getCurrency())) {
            return false;
        }

        BigDecimal max;
        BigDecimal min;
        BigDecimal totalValue = totalCost.getValue();
        BigDecimal totalOtherValue = other.totalCost.getValue();
        if (totalValue.compareTo(totalOtherValue) > 0) {
            max = totalValue;
            min = totalOtherValue;
        } else {
            max = totalOtherValue;
            min = totalValue;
        }

        BigDecimal difference = max.subtract(min);
        BigDecimal acceptableDelta = max.multiply(BigDecimal.valueOf(delta / 100));

        return acceptableDelta.compareTo(difference) > 0;
    }

}
