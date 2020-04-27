import { connect } from 'react-redux'
import Error from '../components/Error'

const mapStateToProps = state => ({
  errorMessage: state.error ? state.error.message : 'Unknown error'
})

export default connect(mapStateToProps, null)(Error)