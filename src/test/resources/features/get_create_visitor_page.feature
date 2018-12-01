Feature: the create visitor page can be retrieved
	Scenario: client makes call to GET /visitor/create
		When the client calls "/visitors/create" for visitor creation
		Then the client receives status code of 200 from create visitor page
		And the client forwarded to url "/WEB-INF/view/createVisitor.jsp" to create visitor page
		And the client gets view with name "createVisitor" for create visitor page