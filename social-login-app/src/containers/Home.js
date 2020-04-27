import { connect } from 'react-redux'
import Home from '../components/Home'

const mapStateToProps = state => {
  return (
    {
      isAuthenticated: state.auth.isAuthenticated,
      isLoginInProgress: state.auth.isLoginInProgress,
      userData: state.auth.userData
    })
}

export default connect(mapStateToProps, null)(Home)