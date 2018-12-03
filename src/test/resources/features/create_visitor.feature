Feature: client can create new visitor
	Scenario: client sends form data to POST "/visitors/create"
		When the client sends data about visitor to "/visitors/create"
			| KEY		| VALUE 		|
			| firstName | MuseumTitle 	|
			| lastName 	| MuseumAddress |
			| email   	| MuseumPhone 	|
			| phone 	| MuseumSite 	|
			| birthDate	| 2018-11-03 	|
			|_museums	| on			|
		Then the client gets status code of 201 means that visitor was created
		And the client redirected to url "/app/visitors/create" for creating new visitor