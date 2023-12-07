# BookWave: Library Management System 

## API Documentation

## Overview
This document provides details on the RESTful APIs implemented in the Library Management System using Spring Boot. The APIs are designed to manage book-related operations, including checking out, returning, renewing loans, and retrieving information about current loans.

### Base URL
All API endpoints are prefixed with the base URL:

`http://localhost:8080/api/books`

### Authentication
APIs marked as /secure require authentication. The user must include a valid JWT token in the Authorization header.

### API Endpoints

#### Get all books
   Endpoint:
   GET `/api/books`
- Description:
   Get all the books

- Response:
Status Code 200: Successful retrieval of the current loans count.


#### Count Current Loans
  Endpoint:
  GET `/secure/currentloans/count`
- Description:
  Count the number of current loans for the authenticated user.

- Request Headers: Authorization: JWT token for user authentication

- Response:

- Status Code 200: Successful retrieval of the current loans count.
  Status Code 401: Unauthorized (invalid token or missing authentication).


#### Checkout book by User
  Endpoint:
  GET `/secure/ischeckedout/byuser`
- Description:
  Check if a specific book is checked out by the authenticated user.

- Request Headers: `Authorization`: JWT token for user authentication
- Request Parameters: `bookId` : ID of the book to check out

- Response:

- Status Code 200: Successful check-out status.
  Status Code 401: Unauthorized (invalid token or missing authentication).


#### Checkout book
  Endpoint:
  PUT `/secure/checkout`
- Description:
  Check out a specific book for the authenticated user.

- Request Headers: `Authorization`: JWT token for user authentication
- Request Parameters: `bookId` : ID of the book to check out

- Response:

- Status Code 200: Successful book check-out.
  Status Code 401: Unauthorized (invalid token or missing authentication).


#### Get all reviews
Endpoint:
GET `/api/reviews`
- Description:
  Get all the reviews

- Response:
  Status Code 200: Successful retrieval of the current loans count.

#### Review Book by User
Endpoint:
GET `/secure/user/book`
- Description:
  Check if the authenticated user has already reviewed a specific book.

- Request Headers: `Authorization`: JWT token for user authentication
- Request Parameters: `bookId` : ID of the book to check out

- Response:

- Status Code 200: Successful book check-out.
  Status Code 401: Unauthorized (invalid token or missing authentication).

#### Post a Review
Endpoint:
POST `/secure/user/book`
- Description:
  Post a review for a specific book by the authenticated user.

- Request Headers: `Authorization`: JWT token for user authentication
- Request body: Review details as specified in the `ReviewRequest` model

- Response:

- Status Code 200: Successful
  Status Code 401: Unauthorized (invalid token or missing authentication).

#### Post a Message
Endpoint:
POST `/secure/add/message`
- Description:
  Post a message by an authenticated user.

- Request Headers: `Authorization`: JWT token for user authentication
- Request body: Message details as specified in the `Message` model

- Response:

- Status Code 200: Successful add message
  Status Code 401: Unauthorized (invalid token or missing authentication).

#### Put a Message (Admin)
Endpoint:
POST `/secure/admin/message`
- Description:
  Respond to a message as an administrator.

- Request Headers: `Authorization`: JWT token for user authentication
- Request body: Admin response details as specified in the `AdminQuestionRequest` model

- Response:

- Status Code 200: Successful message response
  Status Code 401: Unauthorized (invalid token or missing authentication)

#### Post a Book (Admin)
Endpoint:
POST `/secure/add/book`
- Description:
  Add a new book to the library.

- Request Headers: `Authorization`: JWT token for user authentication
- Request body: Book details as specified in the `AddBookRequest` model

- Response:

- Status Code 200: Successful addition of a new book.
  Status Code 401: Unauthorized (invalid token or missing authentication)

#### Increase Book Quantity
Endpoint:
POST `/secure/increase/book/quantity`
- Description:
  Increase the quantity of a specific book in the library.

- Request Headers: `Authorization`: JWT token for user authentication
- Request body: Book details as specified in the `AddBookRequest` model
- Request Parameters: `bookId`: ID of the book to increase quantity
- 
- Response:Status Code 200: Successful increase in book quantity
  Status Code 401: Unauthorized (invalid token or missing authentication)

#### Decrease Book Quantity
Endpoint:
POST `/secure/decrease/book/quantity`
- Description:
  Increase the quantity of a specific book in the library.

- Request Headers: `Authorization`: JWT token for user authentication
- Request body: Book details as specified in the `AddBookRequest` model
- Request Parameters: `bookId`: ID of the book to increase quantity
-
- Response:Status Code 200: Successful decrease in book quantity
  Status Code 401: Unauthorized (invalid token or missing authentication)

#### Delete book
Endpoint:
POST `/secure/delete/book`
- Description:
  Increase the quantity of a specific book in the library.

- Request Headers: `Authorization`: JWT token for user authentication
- Request Parameters: `bookId`: ID of the book to increase quantity
-
- Response:Status Code 200: Successful deletion of book
  Status Code 401: Unauthorized (invalid token or missing authentication)

### Error Handling
- Status Code 401: Unauthorized - Check the validity of the JWT token.
- Status Code 404: Resource Not Found - The requested resource was not found.
- Status Code 500: Internal Server Error - An unexpected error occurred.