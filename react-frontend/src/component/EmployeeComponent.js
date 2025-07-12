//This react component displays the User, Department, Organization details
import React, { Component } from "react";
import EmployeeService from "../service/EmployeeService";

class EmployeeComponent extends Component {
  //constructor to initialize component state value
  //props===> It is plain javaScript Object it get passed to the component, like parent to child component
  constructor(props) {
    super(props);

    //To define objects
    //Below object are initialized Empty
    //State object is plain javaScript Object, managed within the component
    this.state = {
      employee: {},
      department: {},
      organization: {},
    };
  }

  //we make a REST API call
  //Calling the Component life cycle method, within this method we are going to make the REST API Call
  //This method is called when Component gets mounted
  componentDidMount() {
    EmployeeService.getEmployee().then((response) => {
      this.setState({ employee: response.data.employeeDto });
      this.setState({ department: response.data.departmentDto });
      this.setState({ organization: response.data.organizationDto });

      //To print the Objects
      console.log(this.state.employee);
      console.log(this.state.department);
      console.log(this.state.organization);
    });
  }
  //we print the response of the REST API
  render() {
    return (
      <div>
        {" "}
        <br></br>
        <div className="card col-md-6 offset-md-3">
          <h3 className="text-center card-header">View Employee Details</h3>
          <div className="card-body">
            <div className="row">
              <p>
                <strong>Employee First Name: </strong>
                {this.state.employee.firstName}
              </p>
            </div>
            <div className="row">
              <p>
                <strong>Employee Last Name: </strong>
                {this.state.employee.lastName}
              </p>
            </div>
            <div className="row">
              <p>
                <strong>Employee Email: </strong>
                {this.state.employee.email}
              </p>
            </div>
          </div>
          <h3 className="text-center card-header">View Department Details</h3>
          <div className="card-body">
            <div className="row">
              <p>
                <strong>Department Name:</strong>
                {this.state.department.departmentName}
              </p>
            </div>
            <div className="row">
              <p>
                <strong>Department Description:</strong>
                {this.state.department.departmentDescription}
              </p>
            </div>
            <div className="row">
              <p>
                <strong>Department Code:</strong>
                {this.state.department.departmentCode}
              </p>
            </div>
          </div>
          <h3 className="text-center card-header">View Organization Details</h3>
          <div className="card-body">
            <div className="row">
              <p>
                <strong>Organization Name:</strong>
                {this.state.organization.organizationName}
              </p>
            </div>
            <div className="row">
              <p>
                <strong>Organization Description:</strong>
                {this.state.organization.organizationDescription}
              </p>
            </div>
            <div className="row">
              <p>
                <strong>Organization Code:</strong>
                {this.state.organization.organizationCode}
              </p>
            </div>
          </div>
        </div>
      </div>
    );
  }
}

export default EmployeeComponent;
