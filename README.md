## JAX-RS Web Service app using Jersey Servlet Container


## Media Types

### a) JSON

curl -X GET "http://localhost:8080/virtual-bookstore/book" \
     -H "Accept: application/json"


### b) XML

curl -X GET "http://localhost:8080/virtual-bookstore/book" \
     -H "Accept: application/xml"

### c) Get By Id

curl -X GET "http://localhost:8080/virtual-bookstore/book/ISBN-1234"

### d) Interface Uniform. All operations done using the same URI. For example:

GET     /book
GET     /book/{id}
POST    /book
PUT     /book/{id}
DELETE  /book/{id}

### e) Use of the custom BookNotFoundException to return 404

curl -X GET "http://localhost:8080/virtual-bookstore/book/INEXISTENT"

### f) add book

curl -X POST http://localhost:8080/virtual-bookstore/book/ \
     -H "Content-Type: application/xml" \
     -H "Accept: application/xml" \
     --data '
<book id="3">
  <title>Book C</title>
  <isbn>ISBN-5678</isbn>
  <genre>Genre C</genre>
  <price>199.99</price>
  <author id="2">
    <name>Author 2</name>
  </author>
</book>'

