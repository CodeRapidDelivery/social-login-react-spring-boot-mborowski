import React, {Component} from 'react'
import {Link} from 'react-router-dom'
import * as PropTypes from 'prop-types'

class Navbar extends Component {
  
  render() {
    return (
      <nav className="navbar navbar-expand-md navbar-dark bg-dark sticky-top">
        <button className="navbar-toggler" data-toggle="collapse" data-target="#collapse_target">
          <span className="navbar-toggler-icon" />
        </button>
        <div className="collapse navbar-collapse" id="collapse_target">
          <div className="pr-sm-5  navbar-text, text-warning">Social Login Example</div>
          <ul className="navbar-nav">
            <li className="nav-item">
              <Link className="nav-link" to='/'>Home</Link>
            </li>
            {
              this.props.isAuthenticated ?
                <li className="nav-item">
                  <Link className="nav-link" to='/logout'> Log out </Link>
                </li> :
                <li className="nav-item">
                  <Link className="nav-link" to='/login'>Log in </Link>
                </li>
            }
          </ul>
        </div>
      </nav>
    )
    
  }
}

Navbar.propTypes = {
  isAuthenticated: PropTypes.bool
}

export default Navbar