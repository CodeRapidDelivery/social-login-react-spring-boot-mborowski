import { connect } from 'react-redux'
import Logout from '../components/Logout'
import { logout, setError } from '../actions/index'
import {withRouter} from 'react-router-dom';

const mapDispatchToProps = dispatch => ({
  logout: () => dispatch(logout()),
  setError: (message) => dispatch(setError(message)),
})

export default withRouter(connect(null, mapDispatchToProps)(Logout))