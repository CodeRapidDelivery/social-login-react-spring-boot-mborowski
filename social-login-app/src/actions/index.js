export const PROPAGATE_USER_DATA = 'PROPAGATE_USER_DATA'
export const SET_ERROR = 'SET_ERROR'
export const START_LOGIN_PROCESS = 'START_LOGIN_PROCESS'
export const LOG_OUT = 'LOG_OUT'

export const propagateUserData = (userData) => ({ type: PROPAGATE_USER_DATA, userData })
export const setError = (message) => ({ type: SET_ERROR, message })
export const startLoginProcess = () => ({type: START_LOGIN_PROCESS})
export const logout = () => ({type: LOG_OUT})
