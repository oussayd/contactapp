package com.anc.nda.contactapp.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.anc.nda.contactapp.dao.ContactDao;
import com.anc.nda.contactapp.model.Contact;

@Repository
public class ContactDaoImpl implements ContactDao {

	@Autowired
	private SessionFactory sessionFactory;

	public void saveContact(Contact contact) {
		getSession().merge(contact);
	}

	public List<Contact> listContacts() {
		// TODO Auto-generated method stub
		return getSession().createCriteria(Contact.class).list();
	}

	public Contact getContact(Long id) {
		// TODO Auto-generated method stub
		return (Contact) getSession().get(Contact.class, id);
	}

	public void deleteContact(Long id) {
		Contact contact = getContact(id);

		if (null != contact) {
			getSession().delete(contact);
		}
	}

	private Session getSession() {
		Session sess = getSessionFactory().getCurrentSession();
		if (sess == null) {
			sess = getSessionFactory().openSession();
		}
		return sess;
	}

	private SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}
