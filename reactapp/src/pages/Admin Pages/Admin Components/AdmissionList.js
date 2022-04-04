import React, { Component} from "react";
import CourseDataService from './../CourseServiceAdmin/CourseService-Admin'
import {TextLink, StyledContainer2} from './../../../components/Styles'

export default class AdmissionList extends Component{
    constructor(props){
        super(props);
        this.retrieveAdmissionList = this.retrieveAdmissionList.bind(this)
        this.state ={
            registeredlist: [],
            registered: false
        }
    }

    componentDidMount() {
        this.retrieveAdmissionList();
      }

    retrieveAdmissionList(){
        CourseDataService.getAllRegistered()
        .then(response => {
            console.log(response.data)
            this.setState({
                registeredlist: response.data
            })
            var NumberofRegistration = this.state.registeredlist.length
            if(NumberofRegistration===0){
                this.setState({
                    registered: false
                })
            }
            else{
                this.setState({
                    registered: true
                })
            }
        })
        .catch(error => {
            console.log(error)
        })
    }

    render(){
        return(
            <StyledContainer2>
                {this.state.registered ? (
                    <div>
                        <br></br>
                        <h2 className="text-white text-center">Student Registration Table</h2>
                        <br></br>
                        <div className = "row-md-6">
                            <table className = "table table-striped table-light table-bordered table-hover">
                                
                                <thead className="text-center">
                                    <tr>
                                        <th>Name</th>
                                        <th>Course Title</th>
                                        <th>Institute Name</th>
                                        <th>Academic Year</th>
                                        <th>HSC Percentage</th>
                                        <th>Admit</th>
                                        <th>Deny</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    {
                                        this.state.registeredlist.map(
                                            registeredCourse =>
                                            <tr key = {registeredCourse.regid}>
                                                <td className="align-middle text-center"> {registeredCourse.username} </td>
                                                <td className="align-middle text-center"> {registeredCourse.title} </td>
                                                <td className="align-middle text-center"> {registeredCourse.instituteName} </td>
                                                <td className="align-middle text-center"> {registeredCourse.academicYear} </td>
                                                <td className="align-middle text-center"> {registeredCourse.hscmarks} </td>
                                                <td>
                                                    <TextLink to={"/admit/"+registeredCourse.regid}>Admit</TextLink>
                                                </td>
                                                <td>
                                                    <TextLink to={"/deny-admission/"+registeredCourse.regid}>Deny</TextLink>
                                                </td>
                                            </tr>
                                        )
                                    }
                                </tbody>
                            </table>
                        </div>
                    </div>
                ):(
                    <div>
                    <br></br>
                        <h2 className="text-white text-center">No Courses Registered</h2> 
                    </div>
                )}
            </StyledContainer2>
        )
    }

    
}