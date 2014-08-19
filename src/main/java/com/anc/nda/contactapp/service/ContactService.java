package com.anc.nda.contactapp.service;

import java.util.List;

import org.springframework.security.access.annotation.Secured;

import com.anc.nda.contactapp.model.Contact;

public interface ContactService {

	/*
	 * CREATE and UPDATE
	 */
	@Secured("ROLE_ADMIN")
	public void saveContact(Contact contact); // create and update

	/*
	 * READ
	 */
	public List<Contact> listContacts();

	public Contact getContact(Long id);

	/*
	 * DELETE
	 */
	@Secured("ROLE_ADMIN")
	public void deleteContact(Long id);

	
}
