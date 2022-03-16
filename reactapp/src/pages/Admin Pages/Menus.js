import React from 'react'
import { Link } from 'react-router-dom';
import { ListGroup, ListGroupItem } from 'reactstrap';

 const Menus=()=> {
  return (
    <ListGroup className='my-4'>
      {/* <Link className='list-group-item list-group-item-action' tag="a" to="/hom" action>Homeee</Link> */}
        <Link className='list-group-item list-group-item-action' tag="a" to="/admincourse/add-course" action>AddCourse</Link>
        
        <Link className='list-group-item list-group-item-action' tag="a" to="/admincourse/view-course" action>ViewCourse</Link>
        {/* <Link className='list-group-item list-group-item-action' tag="a" to="#!" action>About</Link>
        <Link className='list-group-item list-group-item-action' tag="a" to="#!" action>Contact</Link> */}
    </ListGroup>
  );
};
export default Menus;