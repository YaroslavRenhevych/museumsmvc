Feature: client can create new picture
	Scenario: client sends form data to POST "/pictures/create"
		When the client sends data about picture to "/pictures/create"
			| KEY			| VALUE 		|
			| title   	   	| Picturetitle	|
			| creationDate	| 2018-12-05 	|
		Then the client gets status code of 201 means that picture was created
		And the client redirected to url "/app/pictures/create" for creating new picture