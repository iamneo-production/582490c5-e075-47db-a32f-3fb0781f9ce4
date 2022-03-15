import React from 'react';
import Navbar from './User Components/Navbar'
import { EnrolledContainer } from '../../components/Styles';
const CourseEnrolled = () => {
	return (
		<div>
		<Navbar />
		<EnrolledContainer>
		<h1 style={{color:"#fff",fontSize:"60px",fontFamily:"Dosis"}}>No Courses Enrolled</h1>
		</EnrolledContainer>
		</div>
	);
	};

export default CourseEnrolled;
