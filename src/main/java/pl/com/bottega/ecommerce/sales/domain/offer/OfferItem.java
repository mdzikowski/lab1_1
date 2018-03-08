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

public class OfferItem {

	private Product product;
	private Discount discount;
	private Money money;
	private int quantity;

	public OfferItem(Product product, int quantity) {
		this.product = product;
		this.quantity = quantity;
	}

	public OfferItem(Product product, int quantity, Discount discount) {
		this.product = product;
		this.quantity = quantity;
		this.discount = discount;
		discount.setDiscount(new BigDecimal(0));
		if (discount.getDiscount() != null) {
			BigDecimal dsc = discount.getDiscount();
			discount.setDiscount(dsc.subtract(dsc));
		}
		money.setValue(product.getProductPrice().multiply(new BigDecimal(quantity)).subtract(discount.getDiscount()));
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (product == null ? 0 : product.hashCode());
		result = prime * result + quantity;
		result = prime * result + (discount == null ? 0 : discount.hashCode());
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
		OfferItem other = (OfferItem) obj;
		return product.equals(other.getProduct()) && discount.equals(other.getDiscount())
				&& money.equals(other.getMoney()) && quantity == other.getQuantity();
	}

	/**
	 *
	 * @param item
	 * @param delta
	 *            acceptable percentage difference
	 * @return
	 */
	public boolean sameAs(OfferItem other, double delta) {
		if (product == null) {
			if (other.getProduct() != null) {
				return false;
			}
		} else if (!product.equals(other.getProduct())) {
			return false;
		}

		BigDecimal max;
		BigDecimal min;
		if (money.getValue().compareTo(other.money.getValue()) > 0) {
			max = money.getValue();
			min = other.money.getValue();
		} else {
			max = other.money.getValue();
			min = money.getValue();
		}

		BigDecimal difference = max.subtract(min);
		BigDecimal acceptableDelta = max.multiply(BigDecimal.valueOf(delta / 100));

		return acceptableDelta.compareTo(difference) > 0;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Discount getDiscount() {
		return discount;
	}

	public void setDiscount(Discount discount) {
		this.discount = discount;
	}

	public Money getMoney() {
		return money;
	}

	public void setMoney(Money money) {
		this.money = money;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
