package com.qa.ims.persistence.domain;

import java.util.List;

import com.qa.ims.persistence.dao.ItemsDAO;

public class Orders {
	private Long id;
	private Long CustomerID;
	private Long itemid;
	private List<Items> items;

	
	public Orders(Long ID, Long CustomerID, Long ItemID) {
		this.setId(ID);
		this.setItemId(CustomerID);
		this.setCustomerID(ItemID);
	}
	
	public Orders(Long ID, Long CustomerID) {
		this.setId(ID);
		this.setItemId(CustomerID);
		this.setCustomerID(CustomerID);
	}

	
	public Orders(Long ID) {
		this.setId(ID);
		this.setItemId(ID);
		this.setCustomerID(ID);
	}

	public Orders(Long ID, Long CustomerID, List<Items> items) {
		this.setId(ID);
		this.setCustomerID(CustomerID);
		this.setId(CustomerID);
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
		return CustomerID;
	}

	public void setCustomerID(Long total) {
		this.CustomerID = total;
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
		return "id:" + id + "Customer ID " + CustomerID +" " +", items:" + items;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((CustomerID == null) ? 0 : CustomerID.hashCode());
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
		if (CustomerID == null) {
			if (other.CustomerID != null)
				return false;
		} else if (!CustomerID.equals(other.CustomerID))
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

