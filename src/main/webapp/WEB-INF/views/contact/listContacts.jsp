<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>
<html>
<head>
<title>List Of Contacts</title>

<link rel="stylesheet"
	href='<c:url value="/web-resources/css/pure-0.4.2.css"/>'>

<link rel="stylesheet"
	href='<c:url value="/web-resources/css/font-awesome-4.0.3/css/font-awesome.css"/>'>
<link rel="stylesheet"
	href='<c:url value="/web-resources/css/jquery-ui-1.10.4.custom.css"/>'>
<style type="text/css">
th {
	text-align: left
}
</style>
</head>

<body>
	<div style="width: 95%; margin: 0 auto;">

		<security:authorize ifAllGranted="ROLE_ADMIN">
			<div id="contactDialog" style="display: none;">
				<%@ include file="contactForm.jsp"%>
			</div>
		</security:authorize>
		<h1>List Of Contacts</h1>

		<security:authorize ifAllGranted="ROLE_ADMIN">

			<button class="pure-button pure-button-primary"
				onclick="addContact()">
				<i class="fa fa-plus"></i> Add Contact
			</button>
		</security:authorize>
		<br>
		<table class="pure-table pure-table-bordered pure-table-striped">
			<thead>
				<tr>
					<th width="6%">S.N</th>
					<th width="22%">Nom</th>
					<th width="22%">Prenom</th>
					<th width="22%">Telephone</th>
					<th width="22%">Email</th>
					<th width="6%"></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${contactList}" var="contact"
					varStatus="loopCounter">
					<tr>
						<td><c:out value="${loopCounter.count}" /></td>
						<td><c:out value="${contact.nom}" /></td>
						<td><c:out value="${contact.prenom}" /></td>
						<td><c:out value="${contact.telephone}" /></td>
						<td><c:out value="${contact.email}" /></td>

						<td><nobr>
								<security:authorize ifAllGranted="ROLE_ADMIN">
						
								<button onclick="editContact(${contact.id});"
									class="pure-button pure-button-primary">
									<i class="fa fa-pencil"></i> Edit
								</button>

								<a href="delete/${contact.id}"
									class="pure-button pure-button-primary"
									onclick="return confirm('Are you sure you want to delete this contact?');">
									<i class="fa fa-times"></i>Delete
								</a>
								</security:authorize>
							</nobr></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

	<!--  It is advised to put the <script> tags at the end of the document body so that they don't block rendering of the page -->

	<script type="text/javascript"
		src='<c:url value="/web-resources/js/lib/jquery-1.10.2.js"/>'></script>
	<script type="text/javascript"
		src='<c:url value="/web-resources/js/lib/jquery-ui-1.10.4.custom.js"/>'></script>
	<script type="text/javascript"
		src='<c:url value="/web-resources/js/lib/jquery.ui.datepicker.js"/>'></script>
	<script type="text/javascript"
		src='<c:url value="/web-resources/js/js-for-listContacts.js"/>'></script>
</body>
</html>
