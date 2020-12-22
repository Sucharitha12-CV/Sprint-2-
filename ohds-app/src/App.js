
import './App.css';
import 'bootstrap/dist/css/bootstrap.min.css';
import {BrowserRouter as Router, Route} from 'react-router-dom';
import AddCustomer from './components/customer/AddCustomer';
import FooterComponent from './components/layout/FooterComponent';
import HeaderComponent from './components/layout/HeaderComponent';
import HomeComponent from './components/HomeComponent';
import CustomerDashboard from './components/customer/CustomerDashboard';
import UpdateCustomer from './components/customer/UpdateCustomer';
import ViewCustomer from './components/customer/ViewCustomer';
import { Provider } from 'react-redux';
import store from './store';

function App() {
  return (
    <Provider store={store}>
      <Router>
        <HeaderComponent/>
        <Route exact path="/Home" component={HomeComponent}/>
        <Route exact path="/addCustomer" component={AddCustomer}/>
        <Route exact path="/customerDashboard" component={CustomerDashboard}/>
        <Route exact path="/updateCustomer/:customerId" component={UpdateCustomer}/>
        <Route exact path="/viewCustomer/:customerId" component={ViewCustomer}/>
        <br/>
        <FooterComponent/>
      </Router>
    </Provider>
  );
}

export default App;
