import React from 'react';
import CreateCustomerButton from './CreateCustomerButton';
import PropTypes from "prop-types";
import { connect } from "react-redux";
import {getCustomers}from "../../actions/CustomerAction";
import {Link} from 'react-router-dom';
import {deleteCustomer} from '../../actions/CustomerAction';
class CustomerDashboard extends React.Component{
    constructor(props){
        super(props);
        this.state={
            customers:[]
        }
    }
    onDeleteClick=(customerId)=>{
        console.log('--------ProjectItemComponent:onDeleteClick Called--------')
        this.props.deleteCustomer(customerId);
        //console.log(id);
    }
    componentDidMount(){
        this.props.getCustomers();
    }

    render(){
        const {customers} =  this.props.customers;
        const {customer}=this.props;
        return(
            <div>
               <h1 className="display-4 text-center">Customer List</h1>
               <br/>
               <CreateCustomerButton/>
               <br/>
               <hr/>
               <div className = "row">
                        <table className = "table table-striped table-bordered">
                            <thead>
                                <tr>
                                    <th>Name</th>
                                    <th>User Name</th>
                                    <th>Password</th>
                                    <th>Email</th>
                                    <th>Phone Number</th>
                                    <th>Address</th>
                                    <th>Action</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                console.log(customers),
                                    customers.map(
                                        (customer) => 
                                        <tr key = {customer.customerId}>
                                             <td> {customer.customerName} </td>   
                                             <td> {customer.customerUserName}</td>
                                             <td> {customer.customerPassword}</td>
                                             <td> {customer.customerEmail}</td>
                                             <td> {customer.customerPhoneNo}</td>
                                             <td> {customer.customerAddress}</td>
                                             <td>
                                                 <Link to={"/updateCustomer/"+customer.customerId} className="btn btn-info">Update </Link>
                                                 <button className="btn btn-danger" onClick={this.onDeleteClick.bind(this,customer.customerId)}>Delete </button>
                                                 <Link to={"/viewCustomer/"+customer.customerId} className="btn btn-info" >View </Link>
                                             </td>
                                        </tr>
                                    )
                                }
                            </tbody>
                        </table>
                    </div>
            </div>
        );
    }
}

CustomerDashboard.propTypes={
    getCustomers:PropTypes.func.isRequired,
    deleteCustomer:PropTypes.func.isRequired,

}

const mapStateToProps=(state)=>({
    customers:state.customers
});
export default connect(mapStateToProps,{getCustomers,deleteCustomer})(CustomerDashboard);