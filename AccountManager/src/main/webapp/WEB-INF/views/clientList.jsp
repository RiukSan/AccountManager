<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>Clients</title>
</head>
<body>
	<script type="text/javascript">
		function del(form) {
			form.action = "deleteClient"
		}
		function create(form) {
			form.action = "createClient"
		}
	</script>

	<h1>List of clients</h1>

	<c:forEach items="${clients}" var="client">
	<form action="">
		<input type="hidden" name="id" value="${client.id}" />
		<table border="1">
			<tr>
				<td><a href="editClient?id=${client.id}">${client.name}</a></td>
				<td>
					<button style="width: 100%;" onclick="javascript:del(form)">delete</button>
				</td>
			</tr>
		</table>
		</form>
	</c:forEach>
	<form action="">
		<p style="width: 100%;">
			<input required value="" type="text" name="cli_name" />
			<button onclick="javascript:create(form)">create</button>
		</p>
	</form>
</body>
</html>
