<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>Accounts</title>
</head>
<body>
	<script type="text/javascript">
		function update(form) {
			form.action = "updateAccount"
		}
		function del(form) {
			form.action = "deleteAccount"
		}
		function create(form) {
			form.action = "createAccount"
		}
	</script>

	<h1>List of accounts</h1>
	<div style="width: 500px;">
		<c:forEach items="${client.accounts}" var="account">
			<form action="">
				<input type="hidden" name="id" value="${account.id}" />
				<table border="1" style="width: 100%;">
					<tr>
						<td>
							<p>
								<input required value="${account.name}" type="text" name="acc_name"
									style="width: 100%;" />
							</p>
						</td>
						<td>
							<button style="width: 100%;" onclick="javascript:update(form)">update</button>
						</td>
						<td>
							<button style="width: 100%;" onclick="javascript:del(form)">delete</button>
						</td>
					</tr>
				</table>
			</form>
		</c:forEach>

		<form action="">
			<p style="width: 100%;">
				<input type="hidden" name="id" value="${client.id}" /> <input
					required value="" type="text" name="acc_name" />
				<button onclick="javascript:create(form)">create</button>
			</p>
		</form>
	</div>
</body>
</html>
