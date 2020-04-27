import React from 'react'
import * as PropTypes from 'prop-types'

class Error extends React.Component {
  
  render() {
    return (
      <h2 className='position'>
        {this.props.errorMessage}
      </h2>
    )
  }
}

Error.propTypes = {
  errorMessage: PropTypes.string
}

export default Error
