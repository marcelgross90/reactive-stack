all:
	docker-compose up --force-recreate --build

# Start the spring server and all dependent services
dev:
	docker-compose up

# Start only the dependent services (not the spring servers itself)
service:
	docker-compose up --scale subscriber=0 --scale processor=0 --scale publisher=0

docker-down:
	docker-compose stop
	docker-compose rm -f -v
