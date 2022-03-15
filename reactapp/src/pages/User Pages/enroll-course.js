import React, { Component } from "react";
import CoursesServiceUser from "./CourseService-User/CoursesService-User";
import {emailadd, name, mobno} from './../Login'
import {TextLink, StyledFormArea, StyledTitle, CoursesContainer, colors} from './../../components/Styles'

export default class CourseEnroll extends Component{

    constructor(props) {
        super(props);
        this.getCourse = this.getCourse.bind(this);
        this.enrollCourse = this.enrollCourse.bind(this);
        this.onChangeHSCMarks = this.onChangeHSCMarks.bind(this);
    
        this.state = {
          currentCourse: {
            courseid: null,
            title: "",
            course_desc: "",
            instituteid: null,
            institute_name: ""
          },
          HSCMarks: null,
          enrolled: false,
          alreadyenrolled: false
        };
      }
    
      componentDidMount() {
        this.getCourse(this.props.match.params.id);
      }

      getCourse(id) {
        CoursesServiceUser.getbyID(id)
          .then(response => {
            this.setState({
                currentCourse: response.data
            });
            console.log(response.data);
          })
          .catch(e => {
            console.log(e);
          });
      }

      onChangeHSCMarks(e) {
        this.setState({
            HSCMarks: e.target.value
        });
      }

      enrollCourse(){
        var email = emailadd
        var data = {
            coursedesc: this.state.currentCourse.course_desc,
            hscmarks: this.state.HSCMarks,
            instituteName: this.state.currentCourse.institute_name,
            title: this.state.currentCourse.title,
            useremail: email
          };
          CoursesServiceUser.enroll(data)
          .then(response => {
            console.log(response.data);
            if(response.data==="Course enrolled successfully"){
              this.setState({
                enrolled: true,
                alreadyenrolled: false
              })
            }
            else{
              this.setState({
                enrolled: true,
                alreadyenrolled: true
              })
            }
          })
          .catch(e => {
            console.log(e);
          });
      }

      render(){
        const { currentCourse } = this.state;
        return(
          <CoursesContainer>
              {this.state.enrolled ? (
                 this.state.alreadyenrolled?(
                  <CoursesContainer>
                  <div>
                      <StyledFormArea>
                          <StyledTitle color={colors.theme} size={25}>
                              You have already enrolled into the Course!
                          </StyledTitle>
                          <StyledTitle color={colors.dark2} size={15}>
                              Enroll new Course ? <TextLink to="/usercourse">Click Here</TextLink>
                          </StyledTitle>
                      </StyledFormArea>
                  </div>
                  </CoursesContainer>
                 ):(
                  <CoursesContainer>
                  <div>
                      <StyledFormArea>
                          <StyledTitle color={colors.theme} size={25}>
                              You have enrolled into the Course Successfully!
                          </StyledTitle>
                          <StyledTitle color={colors.dark2} size={15}>
                              Enroll another Course ? <TextLink to="/usercourse">Click Here</TextLink>
                          </StyledTitle>
                      </StyledFormArea>
                  </div>
                  </CoursesContainer>
                 )
              ) : (
              <div className="w-100">
                <div class="p-3 mb-2 bg-light text-dark">
                    <label htmlFor="title" className="text-success">
                      <strong>Title: </strong>
                    </label>
                    <input
                      type="text"
                      readonly class="form-control-plaintext"
                      id="title"
                      required
                      value={currentCourse.title}
                      name="title"
                    />
              </div>

              <div class="p-3 mb-2 bg-light text-dark">
                <label htmlFor="description" className="text-success">
                  <strong>Description:</strong>
                </label>
                  <input
                    type="text"
                    readonly class="form-control-plaintext"
                    id="description"
                    required
                    value={currentCourse.course_desc}
                    name="description"
                  />
            </div>

            <div class="p-3 mb-2 bg-light text-dark">
                <label htmlFor="institute"  className="text-success">
                  <strong>Institute Name:</strong>
                </label>
                  <input
                    type="text"
                    readonly class="form-control-plaintext"
                    id="institute"
                    required
                    value={currentCourse.institute_name}
                    name="institute"
                  />
            </div>

            <div class="p-3 mb-2 bg-light text-dark">
                <label htmlFor="academicyear"  className="text-success">
                  <strong>Academic Year:</strong>
                </label>
                  <input
                    type="text"
                    readonly class="form-control-plaintext"
                    id="academicyear"
                    required
                    value={currentCourse.academicYear}
                    name="academicyear"
                  />
            </div>

            <div class="p-3 mb-2 bg-light text-dark">
                <label htmlFor="courseDuration"  className="text-success">
                  <strong>Course Duration:</strong>
                </label>
                  <input
                    type="text"
                    readonly class="form-control-plaintext"
                    id="courseDuration"
                    required
                    value={currentCourse.courseDuration}
                    name="courseDuration"
                  />
            </div>

            <div class="p-3 mb-2 bg-light text-dark">
                <label htmlFor="fname" className="text-success">
                  <strong>Name:</strong>
                </label>
                  <input
                    type="text"
                    readonly class="form-control-plaintext"
                    id="fname"
                    required
                    value={name}
                    name="fname"
                  />
            </div>

            <div class="p-3 mb-2 bg-light text-dark">
                <label htmlFor="email" className="text-success">
                  <strong>Email:</strong>
                </label>
                  <input
                    type="text"
                    readonly class="form-control-plaintext"
                    id="email"
                    required
                    value={emailadd}
                    name="email"
                  />
            </div>

            <div class="p-3 mb-2 bg-light text-dark">
                <label htmlFor="mobile" className="text-success">
                  <strong>Mobile Number:</strong>
                </label>
                  <input
                    type="text"
                    readonly class="form-control-plaintext"
                    id="mobile"
                    required
                    value={mobno}
                    name="mobile"
                  />
            </div>


            <div class="p-3 mb-2 bg-light text-dark">
                <label htmlFor="hscmarks" className="text-success">
                  <strong>HSC/12th Marks:</strong>
                </label>
                  <input
                    type="text"
                    className="form-control"
                    id="hscmarks"
                    value={this.state.HSCMarks}
                    onChange={this.onChangeHSCMarks}
                    name="hscmarks"
                    required
                  />
            </div>
            <button type="submit" onClick={this.enrollCourse} className="btn btn-success">
              Enroll Now
            </button>
          </div>
              )}
          </CoursesContainer>

        )
      }

}
