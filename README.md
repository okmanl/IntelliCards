# IntelliCards
An open source web app, that allows users to create flashcards, that quizzes users using a concept called spaced repetition. 

https://en.wikipedia.org/wiki/Spaced_repetition

Uses React for front-end and Java Spring Boot for backend. Still in early development phase. If you would like to contribute feel free to make a pull request or read the section Contribution Guide to see a list of tasks that still need to be completed.

You can also email me at ericgumba@gmail.com


# Guideline for running dev enironment

## Running Backend 

You can run the application from the command line with Gradle or Maven. Or you can build a single executable JAR file that contains all the necessary dependencies, classes, and resources, and run that. This makes it easy to ship, version, and deploy the service as an application throughout the development lifecycle, across different environments, and so forth.

## Running Frontend

In the main directory, 

    cd frontend/ 
    npm install 
    npm start

# Contribution Guide  

## Frontend 
 
 Frontend has not been implemented yet
 
 ## Backend

Unit and integration tests need to be written for the following code



UserController.java
  - login
  - Register 

UserServiceImpl.java
  - getUser
  

FlashCard.java
  - isDue
  
FlashCardService.java
  - getCard
  - updateCard
  - getAllCards
  - createCard

  
  
  
