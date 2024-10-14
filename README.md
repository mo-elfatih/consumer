**API Endpoints**
Get Employee by ID

**URL: /api/employees/{id}**
Method: GET
Description: Retrieves an employee by their unique ID.
Example Call:
bash
Copy code
GET /api/employees/1
Response: Returns a JSON representation of the employee.
List Employees with Pagination

**URL: /api/employees**
Method: GET
Description: Retrieves a paginated list of employees. You can specify the page and size.
Query Parameters:
page (optional): The page number to retrieve (default is 0).
size (optional): The number of employees to return per page (default is 10).
Copy code
**GET /api/employees?page=0&size=10**
Response: Returns a paginated response with a list of employees.
Create New Employee

**URL: /api/employees**
Method: POST
Description: Creates a new employee.
Request Body: A JSON representation of the employee to create.
Example Call:
json
Copy code
POST /api/employees
Content-Type: application/json

**{
    "name": "Alice",
    "email": "alice@example.com",
    "position": "Developer",
    "salary": 70000.0,
    "department": {
        "id": 1,
        "name": "IT"
    }
}**
Response: Returns the created employee's JSON representation.
Summary of URL Calls
Here’s a summary table you can use for your GitHub documentation:

HTTP Method	URL	Description
GET	/api/employees/{id}	Get employee by ID
GET	/api/employees	List employees with pagination
POST	/api/employees	Create a new employee
