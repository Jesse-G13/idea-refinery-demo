# idea-refinery-demo

This is a simple example of a REST api. To run the code on your machine please
follow the following steps. 

You can download the code in a .ZIP file to your local machine or if you have 
git install you can run the following command. 

- git clone https://github.com/Jesse-G13/idea-refinery-demo.git


After the code has been added to your machine depending on your IDE you can run
the following commands. 

# Command-line with maven installed
* mvn clean install

The build should be successful, and show 7 tests passed. 

# Eclipse/Intellij IDE
* From the maven tab -> Lifecycle
* Clean
* Install

The build should be successful, and show 8 tests passed. 

You will then be able to run the application on your localhost:8080

# localhost:8080
* Welcome to the web-app

# You can run the following curl requests in postman to interact with the api

# Create a new Task
* curl --location 'http://localhost:8080/tasks' \
  --header 'Content-Type: application/json' \
  --data '{
  "title": "Build demo API",
  "description": "A simple sample API",
  "completed": false,
  "date": "2024-20-09T10:10:15",
  "completed_date": "2024-21-09T16:30:25",
  "id": 1
  }'

# Get Task data for existing tasks
* curl --location 'http://localhost:8080/tasks/1' \
  --data ''

# Update the completed Status for an existing tasks
* curl --location --request PUT 'http://localhost:8080/tasks/update/1' \
  --header 'Content-Type: application/json' \
  --data 'true'

# Update the Title and Description for an existing task
* curl --location --request PUT 'http://localhost:8080/tasks/updateDetails/1' \
  --form 'title="Build demo API - Updated"' \
  --form 'description="A simple sample API - Updated"'

# Update the whole Task information
* curl --location --request PUT 'http://localhost:8080/tasks/id' \
  --header 'Content-Type: application/json' \
  --data '{
  "id":1,
  "title": "Build demo API - New Task",
  "description": "A simple sample API - New Description",
  "completed": true,
  "date": "2024-20-09T10:10:15",
  "completed_date": "2024-21-09T16:30:25"
  }'