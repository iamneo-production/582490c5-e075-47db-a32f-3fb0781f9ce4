import { Button, CardBody, CardSubtitle, CardText, Card, Container } from "reactstrap"
import {React} from "react"
import axios from "axios"
import base_url from "../../coursesapi"
import { toast } from "react-toastify"
import { Link } from "react-router-dom"


const hello=({hello,update})=>{
    const deleteCourse=(id)=>{
        axios.delete(`${base_url}/courses/delete/${id}`).then(
            (response)=>{
                console.log(response);
                toast.success("Course deleted");
                update(id);
            },
            (error)=>{
                console.log(error);
                toast.error("Course not deleted");
            }
        )
    }
    
    
    
    return(
        <Card className="text-center">
            <CardBody>
            <CardSubtitle className="font-weight-bold"><strong>{hello.title}</strong> </CardSubtitle>
            <CardText>{hello.course_desc}</CardText>
            <CardText>{hello.institute_name}</CardText>
            <CardText>{hello.courseDuration}</CardText>
            <CardText>{hello.academicYear}</CardText>
            <Container className="text-center">
                <Button color="danger"
                onClick={()=>{
                    deleteCourse(hello.courseid);
                }}>Delete</Button> 
                <Link class="btn btn-warning ml-3" to={`/admincourse/view-course/update/${hello.courseid}`}>Update</Link>
            </Container>
            </CardBody>
        </Card>
    )
}
export default hello;