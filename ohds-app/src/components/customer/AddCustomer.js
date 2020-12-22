import React from 'react';import PropTypes from "prop-types";
import { connect } from "react-redux";
import {createCustomer} from "../../actions/CustomerAction";
class AddCustomer extends React.Component{
    constructor(props){
        super(props);
        this.state={
            customerName:'',
            customerUserName:'',
            customerPassword:'',
            customerEmail:'',
            customerPhoneNo:'',
            customerAddress:'',
            errors:{}
        }
    }
    componentWillReceiveProps(nextProps) {
        console.log("--------componentWillReceiveProps : Called----------");
        if (nextProps.errors) {
          this.setState({ errors: nextProps.errors });
        }
      }

    onChange=(event)=>{
        this.setState(
            {[event.target.name]:event.target.value}
        );
     }
     onSubmit=(event)=>{
        event.preventDefault();
        const newCustomer = {
            customerName:this.state.customerName,
            customerUserName:this.state.customerUserName,
            customerPassword:this.state.customerPassword,
            customerEmail:this.state.customerEmail,
            customerPhoneNo:this.state.customerPhoneNo,
            customerAddress:this.state.customerAddress,
        }
        console.log(newCustomer);
        this.props.createCustomer(newCustomer,this.props.history);

    }
    render(){
        return(
            <div>
            <div className="container">
                <div className="row">
                    <div className="col-md-8 m-auto">
                        <h5 className="display-4 text-center">Create Customer form</h5>
                        <hr />
                        <form onSubmit={this.onSubmit}>
                            <div className="form-group">
                                <input 
                                    type="text" 
                                    className="form-control form-control-lg " 
                                    placeholder="Customer Name" 
                                    name="customerName" 
                                    onChange={this.onChange}
                                    value={this.state.customerName} 
                                    pattern="[a-zA-Z][a-zA-Z ]{2,}"
                                    title="name should be as given @example: Radha Unni"
                                    required/>
                            </div>
                            <div className="form-group">
                                <input 
                                    type="text" 
                                    className="form-control form-control-lg" 
                                    placeholder="Customer User Name" 
                                    name="customerUserName" 
                                    onChange={this.onChange}
                                    value={this.state.customerUserName}
                                    required/>
                            </div>
                            <div className="form-group">
                                <input 
                                    type="text" 
                                    className="form-control form-control-lg" 
                                    placeholder="Customer Password" 
                                    name="customerPassword" 
                                    onChange={this.onChange}
                                    value={this.state.customerPassword}
                                    required/>
                            </div>
                            <div className="form-group">
                                <input 
                                    type="text" 
                                    className="form-control form-control-lg" 
                                    placeholder="Customer Email" 
                                    name="customerEmail" 
                                    pattern="[a-zA-Z0-9+_.-]{5,15}[@][a-zA-Z]{1,8}[.][a-z]{2,5}"
                                    title="email should be like eg. radha@gmail.com"
                                    onChange={this.onChange}
                                    value={this.state.customerEmail}
                                    required/>
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
                                    required/>
                            </div>
                           
                            <div className="form-group">
                                <textarea 
                                    className="form-control form-control-lg" 
                                    placeholder="Customer Address" 
                                    name="customerAddress" 
                                    onChange={this.onChange}
                                    value={this.state.customerAddress}
                                    required></textarea>
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
AddCustomer.propTypes = {
    createCustomer:PropTypes.func.isRequired,
    errors:PropTypes.object.isRequired

}
const mapStateToProps = state => ({
    errors: state.errors
  });
export default connect(mapStateToProps,{createCustomer})(AddCustomer);