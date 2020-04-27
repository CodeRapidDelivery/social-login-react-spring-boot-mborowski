import { connect } from 'react-redux'
import Navbar from '../components/Navbar'

const mapStateToProps = state => ({
  isAuthenticated: state.auth.isAuthenticated
})

export default connect(mapStateToProps, null)(Navbar)