Feature: the create museum page can be retrieved
	Scenario: client makes call to GET /museums/create
		When the client calls "/museums/create" for museum creation
		Then the client receives status code 200 from create museum page
		And the client forwarded to url "/WEB-INF/view/createMuseum.jsp" to create museum page
		And the client gets view with name "createMuseum" for create museum page