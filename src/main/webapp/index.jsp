<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<html>
<body>
	<h2>Welcome to Spring Greetings!</h2>

	<p>
		<a href="/springgreetings/home/addgreeting.html">Add greeting</a><br />
		<a href="/springgreetings/home/greetings.html">Show all greetings</a><br />
		<sec:authorize access="hasRole('ROLE_ADMIN')">
			<a href="/springgreetings/home/restrictedarea.html">Restricted area...</a>
			<br />
		</sec:authorize>
		<a href="/springgreetings/logout">Logout</a>
</body>
</html>