import React from "react";

const CollegeCard = ({ collegedata }) => {
  
  return (
    <>
      <section className="main-card--cointainer">
        {collegedata.map((curElem) => {
          const { id, institueName, imgLocation, institutePlace} = curElem;

          return (
            <>
              <div className="card-container w-auto p-1" key={id}>
                <div className="card ">
                  <div className="card-body">
                    <span className="card-number card-circle subtle">{id}</span>
                    {<img src={imgLocation} alt="images" className="card-media" />  }
                    <h1 className="text-center">
                      <strong>{institueName}</strong>
                    </h1>
                    <span className="card-description text-center">
                      <h2>{institutePlace}</h2>
                    </span>
                  </div>                 
                  
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