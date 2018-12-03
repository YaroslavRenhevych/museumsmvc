Feature: client can create new museum
	Scenario: client sends form data to POST "/museums/create"
		When the client sends data about museum to "/museums/create"
			| KEY          | VALUE         |
			| title        | MuseumTitle   |
			| address      | MuseumAddress |
			| phone        | MuseumPhone   |
			| site         | MuseumSite    |
			| foundingDate | 2018-11-03    |
		Then the client gets status code of 201 means that museum was created
		And the client redirected to url "/app/museums/create" for creating new museum