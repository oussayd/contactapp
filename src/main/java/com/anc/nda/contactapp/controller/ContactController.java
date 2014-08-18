package com.anc.nda.contactapp.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.anc.nda.contactapp.model.Contact;
import com.anc.nda.contactapp.service.ContactService;

@Controller
@RequestMapping("/contact")
public class ContactController {

	@Autowired
	private ContactService contactService;
	
	@RequestMapping(value = {"/","/listContacts"})
	 public String listContacts(Map<String, Object> map) {

		List<Contact> contactList = contactService.listContacts();
		if (null != contactList)
		System.out.println(contactList.size());
        map.put("contact", new Contact());

        map.put("contactList", contactList);

        return "/contact/listContacts";
 }
	
	
	@RequestMapping("/get/{contactId}")
    public String getContact(@PathVariable Long contactId, Map<String, Object> map) {

           Contact  contact = contactService.getContact(contactId);

           map.put("contact", contact);

           return "/contact/contactForm";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveContact(@ModelAttribute("contact") Contact contact,
                  BindingResult result) {

           contactService.saveContact(contact);

           /*
            * Note that there is no slash "/" right after "redirect:"
            * So, it redirects to the path relative to the current path
            */
           return "redirect:listContacts";
    }

    @RequestMapping("/delete/{contactId}")
    public String deleteContact(@PathVariable("contactId") Long id) {

           contactService.deleteContact(id);

           /*
            * redirects to the path relative to the current path
            */
           // return "redirect:../listcontacts";

           /*
            * Note that there is the slash "/" right after "redirect:"
            * So, it redirects to the path relative to the project root path
            */
           return "redirect:/contact/listContacts";
    }
	
	public ContactService getContactService() {
		return contactService;
	}
	
	public void setContactService(ContactService contactService) {
		this.contactService = contactService;
	}
}
