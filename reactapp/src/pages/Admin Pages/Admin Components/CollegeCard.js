import React from "react";

const CollegeCard = ({ collegedata }) => {
  
  return (
    <>
      <section className="main-card--cointainer">
        {collegedata.map((curElem) => {
          const {  id, institueName, imgLocation, institutePlace} = curElem;

          return (
            <>
              <div className="card-container" key={id}>
                <div className="card ">
                  <div className="card-body">
                    <span className="card-number card-circle subtle">{id}</span>
                    <h2 className="card-title"> {institueName} </h2>
                    <span className="card-description subtle">
                      <h3>{institutePlace}</h3>
                    </span>
                    <div className="card-read">Read More</div>
                  </div>
                <img src={imgLocation} alt="images" className="card-media" /> 

                  <span className="card-tag  subtle">Edit</span>
                  <span className="card-tag subtle">Delete</span>
                </div>
              </div>
            </>
          );
        })}
      </section>
    </>
  );
};

export default CollegeCard;