# Project Title

Short description or overview of the project.

## Prerequisites

- Java (version 11)
- Maven build tool
- Docker 
- Docker Compose (version '3.8')

## Getting Started

### Installation

1. Clone the repository:

    ```bash
    git clone [https://github.com/<your-username>/car-parking-service.git]
    ```

2. Build the project using Maven:

    ```bash
    cd your-project-directory
    mvn clean install
    ```

### Running the Application with Docker Compose

1. Ensure Docker and Docker Compose are installed.

2. Start the application using Docker Compose:

    ```bash
    docker-compose up --build
    ```

3. Access the application at:http://localhost:8080/api/v1/carparks/nearest?latitude=34570.2904&longitude=41861.2936&page=1&per_page=10
  

### Stopping the Application

To stop the application, run:

```bash
docker-compose down

