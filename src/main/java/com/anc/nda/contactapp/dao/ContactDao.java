package com.anc.nda.contactapp.dao;

import java.util.List;

import com.anc.nda.contactapp.model.Contact;

public interface ContactDao {

	/*
	 * CREATE and UPDATE
	 */
	public void saveContact(Contact contact); // create and update

	/*
	 * READ
	 */
	public List<Contact> listContacts();

	public Contact getContact(Long id);

	/*
	 * DELETE
	 */
	public void deleteContact(Long id);
}
