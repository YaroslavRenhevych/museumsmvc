Feature: the create picture page can be retrieved
	Scenario: client makes call to GET /picture/create
		When the client calls "/pictures/create" for picture creation
		Then the client receives status code 200 from create picture page
		And the client forwarded to url "/WEB-INF/view/createPicture.jsp" to create picture page
		And the client gets view with name "createPicture" for create picture page