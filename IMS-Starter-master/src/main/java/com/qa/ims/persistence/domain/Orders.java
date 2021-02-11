package com.qa.ims.persistence.domain;

import java.util.List;


public class Orders {
	private Long id;
	private Long customerID;
	private Long itemid;
	private List<Items> items;

	
	public Orders(Long id, Long customerID, Long itemID) {
		this.setId(id);
		this.setItemId(customerID);
		this.setCustomerID(itemID);
	}
	
	public Orders(Long id, Long customerID) {
		this.setId(id);
		this.setItemId(customerID);
		this.setCustomerID(customerID);
	}

	
	public Orders(Long id) {
		this.setId(id);
		this.setItemId(id);
		this.setCustomerID(id);
	}

	public Orders(Long id, Long customerID, List<Items> items) {
		this.setId(id);
		this.setCustomerID(customerID);
		this.setId(customerID);
		this.items = items;
	}
	
	
	public Orders() {
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCustomerID() {
		return customerID;
	}

	public void setCustomerID(Long total) {
		this.customerID = total;
	}

	public Long getItemId() {
		return itemid;
	}

	public void setItemId(Long id) {
		this.itemid = id;
	}
	
	public List<Items> getItems() {
		return items;
	}

	public void setItems(List<Items> items) {
		this.items = items;
	}
	
	@Override
	public String toString() {
		return "id:" + id + "Customer ID " + customerID +" " +", items:" + items;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((customerID == null) ? 0 : customerID.hashCode());
		result = prime * result + ((itemid == null) ? 0 : itemid.hashCode());
		result = prime * result + ((items == null) ? 0 : items.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Orders other = (Orders) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (customerID == null) {
			if (other.customerID != null)
				return false;
		} else if (!customerID.equals(other.customerID))
			return false;
		if (items == null) {
			if (other.items != null)
				return false;
		} else if (!items.equals(other.items))
			return false;
		if (itemid == null) {
			if (other.itemid != null)
				return false;
		} else if (!itemid.equals(other.itemid))
			return false;
		return true;
	}

}

