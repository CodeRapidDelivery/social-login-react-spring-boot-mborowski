import React from 'react'
import {v4 as uuidv4} from 'uuid'
import {STATE} from '../../api/backendApiCalls'

class FacebookLogin extends React.Component {
  
  login = () => {
    const randomState = uuidv4()
    localStorage.setItem(STATE, randomState)
    const clientId = process.env.REACT_APP_FACEBOOK_CLIENT_ID
    window.location.href = `https://www.facebook.com/v6.0/dialog/oauth?client_id=${clientId}&redirect_uri=http://localhost:3000&state=${randomState}&scope=email`
  }
  
  render() {
    return (
      <div className='position'>
        <button
          className='btn btn-secondary'
          onClick={this.login}
        >
          Login with Facebook
        </button>
      </div>
    )
  }
}

export default FacebookLogin
