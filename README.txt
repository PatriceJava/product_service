
product-service IS AN MICRO SERVICE BASED ON SpringBoot.
IT EXPOSE API TO:

ADD AN NEW PRODUCT: http://localhost:9090/products
    Samples data used in postman:
	{"name":"PROD1","quantity":1,"price":500}
	{"name":"PROD2","quantity":5,"price":700}
	{"name":"PROD3","quantity":3,"price":400}

RETRIEVE ALL PRODUCTS : http://localhost:9090/products

RETRIEVE PRODUCT BY ID : http://localhost:9090/products/1

DELETE AN PRODUCT BY ID: http://localhost:9090/products/1
