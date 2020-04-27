import React, {Component} from 'react'
import * as PropTypes from 'prop-types'
import {logoutFromServer} from '../../api/backendApiCalls'

class Logout extends Component {
  
  componentDidMount() {
    logoutFromServer()
      .then(() => {
        this.props.logout()
      }).catch(err => {
        this.props.setError('Could not logged out correctly')
        this.props.history.push('/error')
      })
  }
  
  render() {
    return (
      <div className='position'>
        <h3> See you next time</h3>
      </div>
    )
  }
}

Logout.propTypes = {
  logout: PropTypes.func,
  setError: PropTypes.func
}

export default Logout
