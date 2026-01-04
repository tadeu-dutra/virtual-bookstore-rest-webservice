Virtual Bookstore RESTful Web Service

This project is a Java-based Web Service for a virtual bookstore, implemented following the REST (Representational State Transfer) architectural style. It utilizes JAX-RS (Java API for RESTful Web Services) with Jersey as the reference implementation.

Features

1. CRUD Operations (Uniform Interface)

The service implements a standard CRUD (Create, Retrieve, Update, Delete) interface for the Book resource using a singleton repository.

• List all books: GET /virtual-bookstore/book
• Get specific book by ISBN: GET /virtual-bookstore/book/{isbn}.
• Create a new book: POST /virtual-bookstore/book (Returns Status 201 Created with Location header)
• Update a book: PUT /virtual-bookstore/book/{isbn}.
• Delete a book: DELETE /virtual-bookstore/book/{id} (Returns Status 204 No Content).

2. Media Type Negotiation
The service supports multiple representations for resources, allowing clients to negotiate data formats via the Accept and Content-Type headers.
• XML: Using JAXB for mapping Java objects.
• JSON: Supported through the jersey-media-json-binding library.

3. Custom Exception Handling
The API uses specific HTTP status codes to communicate errors clearly:
• 404 Not Found: Triggered by BookNotFoundException when a requested ISBN does not exist.
• 409 Conflict: Triggered by BookExistentException when attempting to POST a book with an ID that is already registered.

4. HATEOAS (Hypermedia as the Engine of Application State)
For specific book searches, the service returns an SearchItem object. This includes the book details and dynamic links (Hypermedia) that dictate next possible actions, such as adding the item to a shopping cart (/cart/{id}).

5. Security
The service implements two main layers of security:
• HTTPS/SSL: Configured using a self-signed certificate (generated via keytool) and a custom Jetty connector on port 8443.
• HTTP Basic Authentication: Restricts access to authorized users (e.g., admin and user) defined in the myrealm.properties file.

Technical Details

Dependencies
The project is managed with Maven. Key dependencies include:
• jersey-container-grizzly2-http or jetty-servlet
• jersey-media-json-binding
• jetty-security (for Authentication/Authorization)

Server Configuration
The Main.java class initializes an embedded Jetty server. It defines the base URI context as /livraria-virtual and configures dual connectors for both standard HTTP (8080) and secure HTTPS (8443) traffic.

Metadata (WADL)
The service automatically publishes a WADL (Web Application Description Language) file. This XML document describes all available resources, methods, and supported media types, acting as a technical contract for developers.
• Access at: http://localhost:8080/livraria-virtual/application.wadl

