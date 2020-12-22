import React from 'react';
import {getCustomer,createCustomer} from '../../actions/CustomerAction';
import PropTypes from "prop-types";
import { connect } from "react-redux";
class UpdateCustomer extends React.Component{
    constructor(props){
        super(props);
        this.state={
            
            customerName:'',
            customerUserName:'',
            customerPassword:'',
            customerEmail:'',
            customerPhoneNo:'',
            customerAddress:'',
        }
    }
    onChange=(event)=>{
        this.setState(
            {[event.target.name]:event.target.value}
        );
     }
     onSubmit=(event)=>{
        event.preventDefault();
        const updatedCustomer = {
            customerId:this.state.customerId,
            customerName:this.state.customerName,
            customerUserName:this.state.customerUserName,
            customerPassword:this.state.customerPassword,
            customerEmail:this.state.customerEmail,
            customerPhoneNo:this.state.customerPhoneNo,
            customerAddress:this.state.customerAddress,
        }

      this.props.createCustomer(updatedCustomer,this.props.history);

    }
    componentDidMount(){
        const {customerId} = this.props.match.params;
        this.props.getCustomer(customerId,this.props.history);
 
     }
 
     componentWillReceiveProps(nextProps){
         const {
             customerId,
             customerName,
             customerUserName,
             customerPassword,
             customerEmail,
             customerPhoneNo,
             customerAddress          
         }=nextProps.customer;
 
         this.setState({
            customerId,
            customerName,
            customerUserName,
            customerPassword,
            customerEmail,
            customerPhoneNo,
            customerAddress
                        
         });
     }
    render(){
        return(
            <div>
            <div className="container">
                <div className="row">
                    <div className="col-md-8 m-auto">
                        <h5 className="display-4 text-center">Update Customer form</h5>
                        <hr />
                        <form onSubmit={this.onSubmit}>
                            <div className="form-group">
                                <input 
                                    type="text" 
                                    className="form-control form-control-lg " 
                                    placeholder="Customer Name" 
                                    name="customerName" 
                                    onChange={this.onChange}
                                    value={this.state.customerName}/>
                            </div>
                            <div className="form-group">
                                <input 
                                    type="text" 
                                    className="form-control form-control-lg" 
                                    placeholder="Customer User Name" 
                                    name="customerUserName" 
                                    onChange={this.onChange}
                                    value={this.state.customerUserName}
                                    />
                            </div>
                            <div className="form-group">
                                <input 
                                    type="text" 
                                    className="form-control form-control-lg" 
                                    placeholder="Customer Password" 
                                    name="customerPassword" 
                                    onChange={this.onChange}
                                    value={this.state.customerPassword}
                                    />
                            </div>
                            <div className="form-group">
                                <input 
                                    type="text" 
                                    className="form-control form-control-lg" 
                                    placeholder="Customer Email" 
                                    pattern="[a-zA-Z0-9+_.-]{5,15}[@][a-zA-Z]{1,8}[.][a-z]{2,5}"
                                    title="email should be like eg. radha@gmail.com"
                                    name="customerEmail" 
                                    onChange={this.onChange}
                                    value={this.state.customerEmail}
                                    />
                            </div>
                            <div className="form-group">
                                <input 
                                    type="text" 
                                    className="form-control form-control-lg" 
                                    placeholder="Customer Phone No" 
                                    pattern="[6-9]{1}[0-9]{9}"
                                    title="phone number should start with 6 to 9 and have 10 digits"
                                    name="customerPhoneNo" 
                                    onChange={this.onChange}
                                    value={this.state.customerPhoneNo}
                                    />
                            </div>
                           
                            <div className="form-group">
                                <textarea 
                                    className="form-control form-control-lg" 
                                    placeholder="Customer Address" 
                                    name="customerAddress" 
                                    onChange={this.onChange}
                                    value={this.state.customerAddress}></textarea>
                            </div>
                            <input type="submit" className="btn btn-primary btn-block mt-4" />
                        </form>
                    </div>
                </div>
            </div>
        </div>
        );
    }
}
UpdateCustomer.propTypes = {
    getCustomer:PropTypes.func.isRequired,
    createCustomer:PropTypes.func.isRequired,
    customer:PropTypes.object.isRequired
}

const mapStateToProps = state => ({
    customer: state.customers.customer
  });

export default connect(mapStateToProps,{getCustomer,createCustomer})(UpdateCustomer); 