import React, {Component} from 'react'
import { connect } from 'react-redux'
import decodeParamForKey from '../components/FacebookLogin/decodeParam'
import {propagateUserData, setError, startLoginProcess} from '../actions/index'
import {withRouter} from 'react-router-dom'
import {CODE, login, isAuthenticated, STATE} from '../api/backendApiCalls'

export default function(ComposedComponent) {
  class WithOauthCallback extends Component {
    AUTH_ERROR_MESSAGE = 'Error occurred during the authentication'
  
    componentDidMount() {
      isAuthenticated()
        .then((response) => {
          let userName = response.data
          if (userName){
            this.props.propagateUserData(userName)
          } else {
            this.login()
          }
        })
        .catch(err => {
          if (this.isOauth2Redirect()) {
            this.handleError(this.AUTH_ERROR_MESSAGE)
          }
        })
      
    }
  
    isOauth2Redirect() {
      return window.location.search;
    }
  
    login() {
      const params = window.location.search
      const state = decodeParamForKey(params, STATE)
      const code = decodeParamForKey(params, CODE)
      
      if (state || code) {
        if (localStorage.getItem(STATE) !== state || code == null) {
          this.handleError()
        } else {
          this.setRootUrl()
          this.props.startLoginProcess()
          login(code)
            .then(response => this.props.propagateUserData(response.data))
            .catch(err => this.handleError(this.AUTH_ERROR_MESSAGE))
        }
        localStorage.removeItem(STATE)
      }
    }
  
    handleError(message) {
      this.props.setError(message)
      this.props.history.push('/error')
    }
  
    setRootUrl() {
      window.history.pushState('', '', '/')
    }
  
    render() {
      return <ComposedComponent {...this.props} />
    }
  }
  
  const mapDispatchToProps = dispatch => ({
    propagateUserData: (userData) => dispatch(propagateUserData(userData)),
    setError: (message) => dispatch(setError(message)),
    startLoginProcess: () => dispatch(startLoginProcess())
  })
  
  function mapStateToProps(state) {
    return {
      authenticated: state.auth.authenticated,
    }
  }
  
  return withRouter(connect(mapStateToProps, mapDispatchToProps)(WithOauthCallback))
}