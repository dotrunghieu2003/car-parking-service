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
   Response:
   [
    {
        "carpark_number": "SK90",
        "address": "BLK 332 ANCHORVALE LINK",
        "latitude": 34570.2904,
        "longitude": 41861.2936,
        "total_lots": 508,
        "available_lots": 350,
        "distance_kilometers": 0.0
    },
    {
        "carpark_number": "SK33",
        "address": "BLK 201 SENGKANG EAST ROAD",
        "latitude": 34574.9636,
        "longitude": 41140.2415,
        "total_lots": 546,
        "available_lots": 381,
        "distance_kilometers": 532.0202851323155
    },
    {
        "carpark_number": "BRM1",
        "address": "BLK 112A WHAMPOA ROAD",
        "latitude": 30605.3384,
        "longitude": 34301.5549,
        "total_lots": 335,
        "available_lots": 193,
        "distance_kilometers": 551.3886703749938
    },
    {
        "carpark_number": "CK3",
        "address": "BLK 118/124 TECK WHYE LANE",
        "latitude": 18734.6348,
        "longitude": 40064.9164,
        "total_lots": 282,
        "available_lots": 48,
        "distance_kilometers": 622.892075431982
    },
    {
        "carpark_number": "TJ29",
        "address": "BLK 155A YUNG LOH ROAD",
        "latitude": 15645.0192,
        "longitude": 34485.0749,
        "total_lots": 306,
        "available_lots": 290,
        "distance_kilometers": 663.4984025087359
    },
    {
        "carpark_number": "BR5",
        "address": "BLK 74/75 WHAMPOA DRIVE",
        "latitude": 30768.0099,
        "longitude": 34127.2333,
        "total_lots": 152,
        "available_lots": 59,
        "distance_kilometers": 674.9822730095511
    },
    {
        "carpark_number": "PP5",
        "address": "BLK 113 TO 120 POTONG PASIR AVENUE 1",
        "latitude": 31328.03,
        "longitude": 35388.25,
        "total_lots": 346,
        "available_lots": 181,
        "distance_kilometers": 803.8896964292694
    },
    {
        "carpark_number": "SB6",
        "address": "BLK 306A CANBERRA ROAD",
        "latitude": 26802.1975,
        "longitude": 47444.0071,
        "total_lots": 518,
        "available_lots": 376,
        "distance_kilometers": 885.0244161479543
    },
    {
        "carpark_number": "A74",
        "address": "BLK 646/649 ANG MO KIO STREET 61",
        "latitude": 29166.97,
        "longitude": 40069.8164,
        "total_lots": 185,
        "available_lots": 75,
        "distance_kilometers": 1006.9336257518104
    },
    {
        "carpark_number": "J84M",
        "address": "BLK 854A JURONG WEST STREET 81",
        "latitude": 12771.2097,
        "longitude": 36650.4919,
        "total_lots": 285,
        "available_lots": 174,
        "distance_kilometers": 1022.2969974992985
    }
]

### Stopping the Application

To stop the application, run:

```bash
docker-compose down

