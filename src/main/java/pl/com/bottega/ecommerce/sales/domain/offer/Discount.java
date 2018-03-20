package pl.com.bottega.ecommerce.sales.domain.offer;

import java.math.BigDecimal;

public class Discount {

	private String discountCause;
	private Money discount;

	public String getDiscountCause() {
		return discountCause;
	}

	public void setDiscountCause(String discountCause) {
		this.discountCause = discountCause;
	}

	public BigDecimal getDiscount() {
		return discount.getValue();
	}

	public void setDiscount(BigDecimal discount) {
		this.discount.setValue(discount);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (discount == null ? 0 : discount.hashCode());
		result = prime * result + (discountCause == null ? 0 : discountCause.hashCode());
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
		Discount otherDiscount = (Discount) obj;
		return discount.equals(otherDiscount.getDiscount()) && discountCause.equals(otherDiscount.getDiscountCause());
	}

}
