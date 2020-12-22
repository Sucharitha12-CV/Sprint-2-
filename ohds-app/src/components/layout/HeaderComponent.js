import React from 'react';
import {Nav,Navbar,NavDropdown} from 'react-bootstrap';

class HeaderComponent extends React.Component {
  render() {
    return (
      <div>
        <header>
          <Navbar className="menu md-2" collapseOnSelect expand="lg md-2" bg="dark" variant="dark">
          <Navbar.Brand>Online Home Decor Application</Navbar.Brand>
          <Nav>
            <Nav.Link href="/Home">Home</Nav.Link>
            <Nav.Link href="#">Customer</Nav.Link>
            <Nav.Link href="#">Supplier</Nav.Link>
          </Nav>
          <Navbar.Toggle aria-controls="responsive-navbar-nav" />
            <Navbar.Collapse id="responsive-navbar-nav">
              <Nav className="mr-auto">
                <NavDropdown title="Admin Services" id="collasible-nav-dropdown">
                  <NavDropdown.Item href="/customerDashboard">Customer Information</NavDropdown.Item>
                  <NavDropdown.Divider />
                  <NavDropdown.Item href="#">Supplier Information</NavDropdown.Item>
                  <NavDropdown.Divider />
                  <NavDropdown.Item href="#">Product Information</NavDropdown.Item>
                  <NavDropdown.Divider />
                  <NavDropdown.Item href="#">Category Information</NavDropdown.Item>
                </NavDropdown>
              </Nav>
              <Nav>
                <Nav.Link href="#">Sign Up</Nav.Link>
              </Nav>
              <Nav>
                <Nav.Link href="#">Sign In</Nav.Link>
              </Nav>
              <Nav>
                <Nav.Link href="/Home">SignOut</Nav.Link>
              </Nav>
            </Navbar.Collapse>
          </Navbar>
        </header>
      </div>
    )
  }
}

export default HeaderComponent;