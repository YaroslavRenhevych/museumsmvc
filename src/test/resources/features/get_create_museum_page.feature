Feature: the create museum page can be retrieved
	Scenario: client makes call to GET /museums/create
		When the client calls "/museums/create"
		Then the client receives status code of 200
		And the client forwarded to url "/WEB-INF/view/createMuseum.jsp"
		And the client gets view with name "createMuseum"