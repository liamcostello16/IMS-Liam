package com.qa.ims.persistence.domain;

public class Items {

	private Long id;
	private String Name;
	private Long Value;

	public Items(String item, Long price) {
		this.setName(item);
		this.setValue(price);
	}

	public Items(Long id, String item, Long i) {
		this.setId(id);
		this.setName(item);
		this.setValue(i);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		this.Name = name;
	}

	public Long getValue() {
		return Value;
	}

	public void setValue(Long total) {
		this.Value = total;
	}

	@Override
	public String toString() {
		return "id:" + id + " first name:" + Name + " Value:" + Value;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Name == null) ? 0 : Name.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((Value == null) ? 0 : Value.hashCode());
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
		Items other = (Items) obj;
		if (getName() == null) {
			if (other.getName() != null)
				return false;
		} else if (!getName().equals(other.getName()))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (Value == null) {
			if (other.Value != null)
				return false;
		} else if (!Value.equals(other.Value))
			return false;
		return true;
	}

}
