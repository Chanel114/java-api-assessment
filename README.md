# RESTful Holiday API

🎉 Exciting News for Holiday Enthusiasts! 🎉

Embark on a journey with our API Assessment project – a simple and adaptable RESTful API crafted specifically for the seamless management of holiday-related data. This project is not just a codebase; it's a personalized solution designed to meet the unique needs of developers and businesses alike.

For Developers 🚀
Are you a developer eager to dive into the world of RESTful APIs? Look no further! Our API offers a robust backend for holiday data, providing you with a playground to explore, experiment, and integrate.

Join us on this exciting journey of efficient holiday data management! 💻✨

## Features

- Comprehensive CRUD (Create, Read, Update, Delete) operations are seamlessly integrated to efficiently manage volunteers within the system.
- An advanced search algorithm is implemented, enabling users to perform intricate searches based on volunteers' skills, roles, and active status.
- The application ensures persistent data storage, employing a JSON file format to securely maintain volunteer-related information.
- Exception handling mechanisms have been implemented, ensuring a resilient error management system.

- Leveraging the lightweight and standalone capabilities of Spring Boot, the application is configured for optimal performance.

## Prerequisites

- [JDK 17](https://learn.microsoft.com/en-gb/java/openjdk/download#openjdk-17) (or later)
- Maven 3.6.3 or later (if building from source)
- An IDE of your choice (e.g., IntelliJIDEA, Eclipse) VS Code was used for this project. [Visual Studio Code](https://code.visualstudio.com/Download)
   1. [Extension Pack for Java](https://marketplace.visualstudio.com/items?itemName=vscjava.vscode-java-pack)
   2. [Spring Boot Extension Pack](https://marketplace.visualstudio.com/items?itemName=vmware.vscode-boot-dev-pack)

### Setup and Installation

#### 1. Clone the Repository

```sh
git clone (repository URL)
```

#### 2. Navigate to the directory

```sh
cd (project directory)
```

#### 3. Build the project using Maven (optional if running from an IDE)

```sh
mvn clean install
```

#### 4. Run the application

To start the API in VS Code, from the terminal, run the following command:

```sh
./mvnw spring-boot:run
```

Or on Windows:

```cmd
mvnw spring-boot:run
```

Open your browser and navigate to `http://localhost:8080`.

---

## EndPoints

Endpoints from the RESTful Holiday API.
Including

- HTTP methods
- A brief description of the expected Response.

## Get all Holidays

```http
  GET /holidays
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `api_key` | `string` | **Required**. Your API key |

## Response

A JSON array containing comprehensive holiday details.

## Get Holidays by Name

```http
  GET /holidays/{name}
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `name` | `string` | **Required**. Name of the holiday |

## Response Get

A JSON object containing specific & detailed holiday information.

## Get Public Holidays

```http
 GET /holidays/publicHolidays
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `api_key` | `string` | **Required**. Your API key |

## Response G

A JSON array containing public holiday details.

## Add Holiday

```http
  POST / holidays
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `name` | `string` | **Required**.Name of holiday|
| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `date` | `string` | **Required**.Date of holiday |
| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `public` | `boolean` | **Required**. is it a public holiday?|

## Response Put

Success message or an error message.

## Update Holidays

```http
 PUT /holidays/{name}
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `name` | `string` | **Required**. Name of holiday |
| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `date` | `string` | **Required**. Updated date of the holiday|
| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `public` | `boolean` | **Required**. Updated public status of holiday |

## Response Updated

Success message or an error message.

## Delete Holidays

```http
DELETE /holidays/{name}
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `name` | `string` | **Required**. Name of holiday |

## Response Deleted

Success message or an error message.

## Documentation

## Postman for Testing and Documentation

To interact and test the API using Postman. Follow the instructions to import and use the collection:

- Download and install [Postman](https://www.postman.com/).
- Access (<https://documenter.getpostman.com/view/32697519/2sA2r82PPm>).

- Import into your Postman application.
- Select an environment (if needed)
- initiate requests to the API endpoints.

## Authors

## By Chanel Robinson

## Acknowledgements

A sincere appreciation for course Coding Black Females Director Gary and Lecturer Hope. Their guidance and expertise have been invaluable in shaping the course content and providing a rich learning experience
