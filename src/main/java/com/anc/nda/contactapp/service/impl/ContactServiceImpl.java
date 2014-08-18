package com.anc.nda.contactapp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.anc.nda.contactapp.dao.ContactDao;
import com.anc.nda.contactapp.model.Contact;
import com.anc.nda.contactapp.service.ContactService;

@Service
public class ContactServiceImpl implements ContactService {

	@Autowired
	private ContactDao contactDao;
	
	@Transactional
	public void saveContact(Contact contact) {

		contactDao.saveContact(contact);
	}

	@Transactional(readOnly = true)
	public List<Contact> listContacts() {
		return contactDao.listContacts();
	}

	@Transactional(readOnly = true)
	public Contact getContact(Long id) {
		return contactDao.getContact(id);
	}

	@Transactional
	public void deleteContact(Long id) {
		contactDao.deleteContact(id);
	}

	public ContactDao getContactDao() {
		return contactDao;
	}
	public void setContactDao(ContactDao contactDao) {
		this.contactDao = contactDao;
	}
}
