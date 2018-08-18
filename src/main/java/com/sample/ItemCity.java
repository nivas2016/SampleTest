package com.sample;

import java.math.BigDecimal;

public class ItemCity {
	public enum City{
		PUNE,NAGPUR
	}
	public enum Type{
		GROCERIES,MEDICINES,GOODS
	}
	public City purchaseCity;
	public BigDecimal sp;
	public Type typeofitem;
	public BigDecimal tax;
	public City getPurchaseCity() {
		return purchaseCity;
	}
	public void setPurchaseCity(City purchaseCity) {
		this.purchaseCity = purchaseCity;
	}
	public BigDecimal getSp() {
		return sp;
	}
	public void setSp(BigDecimal sp) {
		this.sp = sp;
	}
	public Type getTypeofitem() {
		return typeofitem;
	}
	public void setTypeofitem(Type typeofitem) {
		this.typeofitem = typeofitem;
	}
	public BigDecimal getTax() {
		return tax;
	}
	public void setTax(BigDecimal tax) {
		this.tax = tax;
	}
	
	
}
