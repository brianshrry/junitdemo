package com.abcpvt.junitdemo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ContactService {
	private List<Contact> contacts = new ArrayList<>();

	public void addContact(Contact contact) {
		contacts.add(contact);
	}

	public void updateContact(Contact contact) {
		contacts.stream().filter(c -> c.getId() == contact.getId()).findFirst().ifPresent(c -> {
			c.setName(contact.getName());
			c.setEmail(contact.getEmail());
			c.setPhoneNumber(contact.getPhoneNumber());
		});
	}

	public void deleteContact(int id) {
		contacts.removeIf(c -> c.getId() == id);
	}

	public Optional<Contact> getContact(int id) {
		return contacts.stream().filter(c -> c.getId() == id).findFirst();
	}

	public List<Contact> getAllContacts() {
		return new ArrayList<>(contacts);
	}
}
