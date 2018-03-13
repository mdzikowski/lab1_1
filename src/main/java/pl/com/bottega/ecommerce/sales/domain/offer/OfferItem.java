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
import java.util.Date;

public class OfferItem{

    private Money money;
    private Discount discount = null;
    public int quantity;
    private Product product = null;

    public OfferItem(Product product, int quantity) {
        this( product, quantity, null );
    }

    public OfferItem(Product product,int quantity, Discount discount) {
        this.product = product;
        this.quantity = quantity;
        this.discount = discount;

        BigDecimal discountValue = new BigDecimal( 0 );
        if (discount != null) {
            discountValue = discountValue.subtract( discount.getMoney().getValue() );
        }

        this.product.totalCost = product.productPrice.multiply( new BigDecimal( quantity ) ).subtract( discountValue );
    }

    public Product getProduct() {
        return product;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (discount.getMoney() == null ? 0 : discount.getMoney().hashCode());
        result = prime * result + (product.productName == null ? 0 : product.productName.hashCode());
        result = prime * result + (product.productPrice == null ? 0 : product.productPrice.hashCode());
        result = prime * result + (product.productId == null ? 0 : product.productId.hashCode());
        result = prime * result + (product.productType == null ? 0 : product.productType.hashCode());
        result = prime * result + quantity;
        result = prime * result + (product.totalCost == null ? 0 : product.totalCost.hashCode());
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
        } else if (!discount.equals( other.discount )) {
            return false;
        }
        if (product == null) {
            if (other.product != null) {
                return false;
            }
        } else if (!product.equals( other.product )) {
            return false;
        }
        return true;
    }

    /**
     * @param other
     * @param delta acceptable percentage difference
     * @return
     */
    public boolean sameAs(OfferItem other, double delta) {
        if (product == null) {
            if (other.product != null) {
                return false;
            }
        } else if (!product.equals( other.product )) {
            return false;
        }
        if (quantity != other.quantity) {
            return false;
        }

        BigDecimal max;
        BigDecimal min;
        if (product.totalCost.compareTo( other.product.totalCost ) > 0) {
            max = product.totalCost;
            min = other.product.totalCost;
        } else {
            max = other.product.totalCost;
            min = product.totalCost;
        }

        BigDecimal difference = max.subtract( min );
        BigDecimal acceptableDelta = max.multiply( BigDecimal.valueOf( delta / 100 ) );

        return acceptableDelta.compareTo( difference ) > 0;
    }

}
