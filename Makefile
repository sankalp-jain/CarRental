image:
	docker build -t car-rental.jar .
run:
	docker run -p 8080:8080 car-rental.jar