import React from 'react'
import * as PropTypes from 'prop-types'
import {hello} from '../../api/backendApiCalls'

class Home extends React.Component {
  state = {}
  
  onClickHello = () => {
    if (!this.state.toggle) {
      hello()
        .then(response => {
          this.setState(state => ({...state, hello: response.data}))
          this.toggle()
        })
    } else {
      this.toggle();
    }
  }
  
  toggle() {
    this.setState(state => ({...state, toggle: !state.toggle}))
  }
  
  render() {
    return (
      <div className='position'>
        {
          this.props.isAuthenticated &&
          <div>
            You are logged in correctly, welcome in the app:
            
            <h5>{this.props.userData}</h5>
            <br/>
            <button className='btn btn-secondary' onClick={this.onClickHello}>
              Hello
            </button>
            {
              this.state.hello && this.state.toggle &&
              <div>
                <hr className="my-4"/>
                {this.state.hello}
              </div>
            }
          </div>
        }
        {
          this.props.isLoginInProgress &&
          <div>
            <h3> Login in progress...</h3>
          </div>
        }
        {
          !this.props.isAuthenticated && !this.props.isLoginInProgress &&
          <div>
            <h3> This is social login example app</h3>
          </div>
        }
      </div>
    )
  }
}

Home.propTypes = {
  isAuthenticated: PropTypes.bool,
  isLoginInProgress: PropTypes.bool,
  userData: PropTypes.string
}

export default Home