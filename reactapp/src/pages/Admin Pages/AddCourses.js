
import React, { Fragment, useEffect, useState } from 'react'
import { Form, FormGroup, Input, Label, Container, Button } from 'reactstrap';
import axios from 'axios';
import base_url from '../../coursesapi';
import 'react-toastify/dist/ReactToastify.css';
import { toast } from 'react-toastify';
toast.configure();
const AddCourses=()=> {
  const[courses,setCourses]=useState({});
  const handleform=(e)=>{
    console.log(courses);
    postDatatoServer(courses);
    e.preventDefault();
  }
  const postDatatoServer=(data)=>{
    axios.post(`${base_url}/courses/add`,data).then(
      (response)=>{
          console.log(response);
          // console.log("success");
         toast.success("Course added successfully");
          // setCourses({course_id:"",title:"",instituteid:"",course_desc:"",institute_name:""});
      },
      (error)=>{
        console.log(error);
        console.log("error");
        toast.error("Something went wrong");
      }
    );
  };
  return (
      <Fragment>
      <h1 className='text-center my-3'>Add Course here</h1>
      <Form onSubmit={handleform}>
          <FormGroup>
          <Label for="userId" >Course id</Label>
          <Input type="text" name="userId" id="userId" placeholder="Enter course id here" 
          onChange={(e)=>{
            setCourses({...courses,courseid:e.target.value})
          }}/>
          </FormGroup>
          <FormGroup>
          <Label for="title" >Course title</Label>
          <Input type="text" name="title" id="title" placeholder="Enter course title here"
          onChange={(e)=>{
            setCourses({...courses,title:e.target.value})
          }}/>
          </FormGroup>
          <FormGroup>
          <Label for="userId" >Institute id</Label>
          <Input type="text" name="userId" id="userId" placeholder="Enter institute id here"
          onChange={(e)=>{
            setCourses({...courses,instituteid:e.target.value})
          }}/>
          </FormGroup>
          <FormGroup>
          <Label for="description" >Course description</Label>
          <Input type="textarea" name="description" id="description" placeholder="Enter description here"
          onChange={(e)=>{
            setCourses({...courses,course_desc:e.target.value})
          }}/>
          </FormGroup>
          <FormGroup>
          <Label for="title" >Institute name</Label>
          <Input type="text" name="title" id="title" placeholder="Enter institute name here"
          onChange={(e)=>{
            setCourses({...courses,institute_name:e.target.value})
          }}/>
          </FormGroup>
          <FormGroup>
          <Label for="title" >Course duration</Label>
          <Input type="text" name="title" id="title" placeholder="Enter course duration here"
          onChange={(e)=>{
            setCourses({...courses,courseDuration:e.target.value})
          }}/>
          </FormGroup>
          <FormGroup>
          <Label for="title" >Academic year</Label>
          <Input type="text" name="title" id="title" placeholder="Enter academic year"
          onChange={(e)=>{
            setCourses({...courses,academicYear:e.target.value})
          }}/>
          </FormGroup>
      <Container className='text-center'>
          <Button type="submit" color="success">Add</Button>
          <Button type="reset"color="warning ml-3">Clear</Button>
        </Container>
     </Form>
     </Fragment>
  );
};
export default AddCourses