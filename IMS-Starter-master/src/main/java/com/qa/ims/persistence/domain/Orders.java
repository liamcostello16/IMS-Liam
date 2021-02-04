package com.qa.ims.persistence.domain;

public class Orders {
	private Long id;
	private Long CustomerID;
	private String Name;
	
	public Orders(Long ID, Long CustomerID) {
		this.setId(ID);
		this.setCustomerID(CustomerID);
	}

	public Orders(Long CustomerID) {
		this.setCustomerID(CustomerID);
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

	@Override
	public String toString() {
		return "id:" + id + "Customer ID " + CustomerID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((CustomerID == null) ? 0 : CustomerID.hashCode());
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
		return true;
	}

}

