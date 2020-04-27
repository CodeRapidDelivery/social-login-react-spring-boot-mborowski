import {PROPAGATE_USER_DATA, START_LOGIN_PROCESS, LOG_OUT} from '../actions/index'

const auth = (state = [], action) => {
  switch (action.type) {
    case PROPAGATE_USER_DATA:
      return { ...state, isAuthenticated: true, isLoginInProgress: false, 'userData': action.userData}
    case START_LOGIN_PROCESS:
      return {...state, isLoginInProgress: true}
    case LOG_OUT:
      return { ...state, isAuthenticated: false, 'userData': null}
    default:
      return state
  }
}

export default auth