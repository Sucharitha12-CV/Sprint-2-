import {combineReducers} from 'redux';
import customersReducer from './customersReducer';
import errorReducer from './errorReducer';

export default combineReducers({
   errorReducer:errorReducer,
   customers:customersReducer
});