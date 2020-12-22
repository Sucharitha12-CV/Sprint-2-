import React  from 'react';
import {Link} from 'react-router-dom';
const CreateCustomerButton = () =>{
    return(

        <React.Fragment>
            <Link to="/addCustomer" className="btn btn-lg btn-info">
                Add new Customer
            </Link>
        </React.Fragment>        
    );
}

export default CreateCustomerButton;