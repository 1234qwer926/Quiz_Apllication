# Quiz App

## Description

The **Quiz App** is a web-based application built using **Spring Boot** and **MySQL**. It allows users to create quizzes, view quiz questions, and submit answers to get a result. The application follows a simple RESTful architecture to handle various operations related to quiz creation, retrieval, and submission.

## Features

- **Create a quiz**: Admins can create quizzes with questions in different categories.
- **Get quiz questions**: Users can retrieve questions by quiz ID.
- **Submit quiz answers**: Users can submit answers to receive their score.
- **Question management**: Admins can add, retrieve, and filter questions based on categories.

## Technologies Used

- **Spring Boot**: Backend framework
- **Spring Data JPA**: Database interaction using Hibernate
- **MySQL**: Database for storing quiz and question data
- **REST API**: For communication between the client and server

## API Endpoints

### QuizController

- **POST** `/quiz/create`
  - **Description**: Create a new quiz
  - **Request Parameters**: 
    - `category` (String) - The category of the quiz.
    - `noQe` (int) - Number of questions in the quiz.
    - `title` (String) - The title of the quiz.
  - **Response**: `"Created"` (Status 201)

- **GET** `/getquiz/{id}`
  - **Description**: Get the list of questions in a specific quiz
  - **Path Variables**: 
    - `id` (Integer) - The ID of the quiz.
  - **Response**: List of questions with options

- **POST** `/submit/{id}`
  - **Description**: Submit answers to a quiz and get the result
  - **Path Variables**:
    - `id` (Integer) - The ID of the quiz.
  - **Request Body**: List of responses
  - **Response**: Number of correct answers

### QuestionController

- **GET** `/questions/allquestions`
  - **Description**: Get all questions
  - **Response**: List of all questions

- **GET** `/questions/category/{category}`
  - **Description**: Get questions by category
  - **Path Variables**: 
    - `category` (String) - The category of questions.
  - **Response**: List of questions for the specified category

- **POST** `/questions/add`
  - **Description**: Add a new question
  - **Request Body**: Question object containing the question text, options, answer, and category
  - **Response**: `"success"` (Status 201)

## Models

### Question

```java
@Entity
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String questionName;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private String answer;
    private String categories;
}```
# Quiz App

## Overview

The Quiz App is a web application that allows users to create and manage quizzes with multiple questions. It is built using Spring Boot and integrates with a MySQL database for storing quiz data and questions.

## Features

- Create quizzes with multiple questions.
- Store quiz and question data in a MySQL database.
- Provide a response model to handle user answers.

## Database Configuration

The application uses MySQL as the database for storing quiz data and questions.

**Database URL:**  
`jdbc:mysql://localhost:3306/quizapp`

**Username:**  
`root`

**Password:**  
`Stardust2@2020`

## Application Properties

Make sure the following properties are set in your `application.properties` file:

```properties
spring.application.name=QuizApp

spring.datasource.url=jdbc:mysql://localhost:3306/quizapp
spring.datasource.username=root
spring.datasource.password=Stardust2@2020

spring.jpa.show-sql=true
spring.jpa.hibernate.ddl-auto=update

server.port=8081
server.servlet.session.cookie.same-site=strict
 ##Dependencies
The following dependencies are used in this project:

- **Spring Boot Starter Web**: For building web applications.
- **Spring Boot Starter Data JPA **: For interacting with MySQL using JPA.
- **MySQL Connector/J **: For MySQL database connection.
- **Spring Boot Starter Test**: For testing purposes.
