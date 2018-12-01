Feature: the create painter page can be retrieved
	Scenario: client makes call to GET /painters/create
		When the client calls "/painters/create" for painter creation
		Then the client receives status code of 200 from create pinter page
		And the client forwarded to url "/WEB-INF/view/createPainter.jsp" to create painter page
		And the client gets view with name "createPainter" for create painter page