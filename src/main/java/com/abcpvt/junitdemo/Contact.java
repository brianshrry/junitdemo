package com.abcpvt.junitdemo;

public class Contact {
	private int id;
	private String name;
	private String email;
	private String phoneNumber;

	// constructor
	public Contact(int id, String name, String email, String phoneNumber) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.phoneNumber = phoneNumber;
	}

	// getters and setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	// override equals and hashCode for proper comparison
	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		Contact contact = (Contact) o;

		if (id != contact.id)
			return false;
		if (!name.equals(contact.name))
			return false;
		if (!email.equals(contact.email))
			return false;
		return phoneNumber.equals(contact.phoneNumber);
	}

	@Override
	public int hashCode() {
		int result = id;
		result = 31 * result + name.hashCode();
		result = 31 * result + email.hashCode();
		result = 31 * result + phoneNumber.hashCode();
		return result;
	}
}
