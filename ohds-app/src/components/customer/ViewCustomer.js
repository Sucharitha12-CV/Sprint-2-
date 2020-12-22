import React from 'react';
import {getCustomer} from '../../actions/CustomerAction';
import PropTypes from "prop-types";
import { connect } from "react-redux";
import {Link} from 'react-router-dom';
class ViewCustomer extends React.Component{
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
                        <h5 className="display-4 text-center">View Customer</h5>
                        <hr />
                        <form>
                            <div className="form-group">
                                <input 
                                    type="text" 
                                    className="form-control form-control-lg " 
                                    placeholder="Customer Name" 
                                    name="customerName" 
                                    value={this.state.customerName}/>
                            </div>
                            <div className="form-group">
                                <input 
                                    type="text" 
                                    className="form-control form-control-lg" 
                                    placeholder="Customer User Name" 
                                    name="customerUserName" 
                                    value={this.state.customerUserName}
                                    />
                            </div>
                            <div className="form-group">
                                <input 
                                    type="text" 
                                    className="form-control form-control-lg" 
                                    placeholder="Customer Password" 
                                    name="customerPassword"
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
                                    value={this.state.customerPhoneNo}
                                    />
                            </div>
                           
                            <div className="form-group">
                                <textarea 
                                    className="form-control form-control-lg" 
                                    placeholder="Customer Address" 
                                    name="customerAddress" 
                                    value={this.state.customerAddress}></textarea>
                            </div>
                            <Link to="/customerDashboard" className="btn btn-lg btn-info">Ok</Link>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        );
    }
}
ViewCustomer.propTypes = {
    getCustomer:PropTypes.func.isRequired,
    customer:PropTypes.object.isRequired
}

const mapStateToProps = state => ({
    customer: state.customers.customer
  });

export default connect(mapStateToProps,{getCustomer})(ViewCustomer); 