import { GET_CUSTOMER, GET_CUSTOMERS,DELETE_CUSTOMER} from "../actions/type";

const initialState={
    customers:[],
    customer:{}
};

export default function(state=initialState,action){
    switch(action.type){
        case GET_CUSTOMERS:
            return{
                ...state,
                customers:action.payload
            }
        case GET_CUSTOMER:
            return{
                ...state,
                customer:action.payload
            }
        case DELETE_CUSTOMER:
            return{
                ...state,
                customers:state.customers.filter(
                    customer=>customer.customerId!==action.payload
                )
            };
        default:
            return state;

    }
}