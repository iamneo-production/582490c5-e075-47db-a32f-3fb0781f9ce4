import React from 'react';
import Navbar from './Admin Components/Navbar';

import { StyledContainer2 } from '../../components/Styles';
const Course = () => {
return (
	<StyledContainer2>
	<div>
	<Navbar />
	<div style={{
                display: 'flex',
				justifyContent: 'center',
				alignItems: 'flex-start',
				height: '100vh',
				
            }}>
	<h1 style={{color:"#fff",fontSize:"60px",fontFamily:"Dosis"}}>Welcome to Students' corner</h1>
	</div>
	</div>
	</StyledContainer2>
);
};

export default Course;
