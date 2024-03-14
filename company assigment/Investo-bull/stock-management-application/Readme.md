# Candle Analysis Application (Stock Management)
Welcome to the Candle Analysis Application! This application provides functionality for analyzing and processing candle data. Candle data is a crucial element in financial analysis, and this application aims to simplify various candle analysis tasks.


### Features
* Save candle data to a database
* Get time when the first Opening Range Breakout (ORB) was generated
* Combine candle data over specified time intervals for simplified analysis

### Installation & Getting Started

To run the Candle Analysis Application, follow these steps:

* Open the project in your preferred Java IDE
* Run the application


### Usage
Once the application is up and running, you can use the following API endpoints to interact with it:

* Save Candle Data
````
Endpoint: POST /candle/save-candles
Description: Saves candlestick data from a JSON file to the database
````

* Opening Range Breakout (ORB) Analysis
````
Endpoint: GET /candle/ORB/{time}
Description: Calculates and returns the time of the first Opening Range Breakout (ORB) candle based on the specified time interval
````

* Combine Candle Data
````
Endpoint: GET /candle/combine/{time}
Description: Retrieves and combines candlestick data for the specified time interval
````


### API Endpoint
````
POST  http://localhost:8888/candle/save-candle
GET   http://localhost:8888/candle/ORB/{time}
GET   http://localhost:8888/candle/combine/{time}
````


### Swagger use
````
http://localhost:8888/swagger-ui/index.html#/
````


### Technology Stack

- Java
- Spring Boot
- H2 Database
- Lombok for reducing boilerplate code