import axios from 'axios';
import { GET_ERRORS, GET_CUSTOMERS, GET_CUSTOMER,DELETE_CUSTOMER } from './type';
export const createCustomer=(customer,history)=>async dispatch=> {
    try {
        await axios.post ("http://localhost:8080/Customer/customer",customer);
        history.push("/customerDashboard");
    } catch (error) {
        dispatch({
            type:GET_ERRORS,
            payload:error.response.data
        })
    }
}
export const getCustomers=()=>async dispatch=>{
    const res=await axios.get("http://localhost:8080/Customer/all");
    dispatch({
        type:GET_CUSTOMERS,
        payload:res.data
    })
}
export const getCustomer=(customerId,history)=>async dispatch=>{
    const res=await axios.get(`http://localhost:8080/Customer/show/${customerId}`);
    dispatch({
        type:GET_CUSTOMER,
        payload:res.data
    })
}
export const deleteCustomer=(customerId)=>async dispatch=>{
    if(window.confirm("Are you sure ? This will delete the project and the data related to it")) {
        await axios.delete(`http://localhost:8080/Customer/delete/${customerId}`);
        dispatch({
           type:DELETE_CUSTOMER,
            payload:customerId
        })
    }
}