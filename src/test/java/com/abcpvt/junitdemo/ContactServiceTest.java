package com.abcpvt.junitdemo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.util.Optional;

class ContactServiceTest {

	private ContactService contactService;
	private Contact contact1;
	private Contact contact2;

	@BeforeEach
	void setUp() {
		contactService = new ContactService();
		contact1 = new Contact(1, "John Doe", "john.doe@example.com", "1234567890");
		contact2 = new Contact(2, "Jane Smith", "jane.smith@example.com", "0987654321");
	}

	@Test
	void testAddContact() {
		contactService.addContact(contact1);
		Optional<Contact> retrievedContact = contactService.getContact(contact1.getId());

		Assertions.assertTrue(retrievedContact.isPresent());
		Assertions.assertEquals(contact1, retrievedContact.get());
	}

	@Test
	void testUpdateContact() {
		contactService.addContact(contact1);
		Contact updatedContact = new Contact(1, "John Doe Updated", "john.doe.updated@example.com", "1111111111");
		contactService.updateContact(updatedContact);

		Optional<Contact> retrievedContact = contactService.getContact(updatedContact.getId());
		Assertions.assertTrue(retrievedContact.isPresent());
		Assertions.assertEquals(updatedContact.getName(), retrievedContact.get().getName());
		Assertions.assertEquals(updatedContact.getEmail(), retrievedContact.get().getEmail());
		Assertions.assertEquals(updatedContact.getPhoneNumber(), retrievedContact.get().getPhoneNumber());
	}

	@Test
	void testDeleteContact() {
		contactService.addContact(contact1);
		contactService.deleteContact(contact1.getId());
		Optional<Contact> retrievedContact = contactService.getContact(contact1.getId());

		Assertions.assertFalse(retrievedContact.isPresent());
	}

	@Test
	void testGetAllContacts() {
		contactService.addContact(contact1);
		contactService.addContact(contact2);

		Assertions.assertEquals(2, contactService.getAllContacts().size());
		Assertions.assertTrue(contactService.getAllContacts().contains(contact1));
		Assertions.assertTrue(contactService.getAllContacts().contains(contact2));
	}

	@Test
	void testGetContact() {
		contactService.addContact(contact1);
		Optional<Contact> retrievedContact = contactService.getContact(contact1.getId());

		Assertions.assertTrue(retrievedContact.isPresent());
		Assertions.assertEquals(contact1, retrievedContact.get());
	}
}
