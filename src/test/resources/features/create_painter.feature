Feature: client can create new painter
	Scenario: client sends form data to POST "/painters/create"
		When the client sends data about painter to "/painters/create"
			| KEY		| VALUE 			|
			| firstName	| Painterfirstname	|
			| lastName 	| Painterlastname 	|
			| country  	| Paintercountry 	|
			| birthDate	| 2018-12-12 		|
		Then the client gets status code of 201 means that painter was created
		And the client redirected to url "/app/painters/create" for creating new painter