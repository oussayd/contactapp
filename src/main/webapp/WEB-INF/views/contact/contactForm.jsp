<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:url var="actionUrl" value="save" />

<form:form id="contactForm" commandName="contact" method="post"
	action="${actionUrl }" class="pure-form pure-form-aligned">

	<fieldset>
		<legend></legend>

		<div class="pure-control-group">
			<label for="name">Nom</label>
			<form:input path="nom" placeholder="Contact Name" />
		</div>
		<div class="pure-control-group">
			<label for="code">Prenom</label>
			<form:input path="prenom" placeholder="Prenom" />
		</div>
		<div class="pure-control-group">
			<label for="code">Telephone</label>
			<form:input path="telephone" placeholder="Telephone" />
		</div>
		<div class="pure-control-group">
			<label for="code">Email</label>
			<form:input path="email" placeholder="Email" />
		</div>

		<form:input path="id" type="hidden" />
	</fieldset>
</form:form>