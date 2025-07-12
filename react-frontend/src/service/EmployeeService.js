//Here we are going to make REST API call form react application to API GATEWAY in EmployeeService.js File

import axios from "axios";

//It holds the employee service REST API base URL
const EMPLOYEE_SERVICE_BASE_URL = "http://localhost:9191/api/employees";

// It holds the employee_id
const EMPLOYEE_ID = 3;

class EmployeeService {
  getEmployee() {
    return axios.get(EMPLOYEE_SERVICE_BASE_URL + "/" + EMPLOYEE_ID); //It return the employeeService of rest API
  }
}

export default new EmployeeService();
