package com.qa.ims.persistence.domain;

public class OrderItems {
	private Long id;
	private Long itemid;
	
	public OrderItems(Long ID, Long ItemID) {
		this.setId(ID);
		this.setItemID(ItemID);
	}

	public OrderItems(Long ItemID) {
		this.setItemID(ItemID);
	}
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getItemID() {
		return itemid;
	}

	public void setItemID(Long total) {
		this.itemid = total;
	}

	@Override
	public String toString() {
		return "id:" + id + "Customer ID " + itemid;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((itemid == null) ? 0 : itemid.hashCode());
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
		OrderItems other = (OrderItems) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (itemid == null) {
			if (other.itemid != null)
				return false;
		} else if (!itemid.equals(other.itemid))
			return false;
		return true;
	}
}
