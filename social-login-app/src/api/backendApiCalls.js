import axios from 'axios'

export const STATE = 'state'
export const CODE = 'code'
const SERVER_URL= 'http://localhost:8080'
const BASE_API = SERVER_URL + '/v1/api'

export const login = (oauthCode) => {
  return axios.post(BASE_API + `/oauth/login?code=${oauthCode}`, null,{withCredentials: true})
}

export const isAuthenticated = () => {
  return axios.get(BASE_API + `/authenticate`,{withCredentials: true})
}

export const logoutFromServer = () => {
  return axios.post(SERVER_URL + '/logout', null,{withCredentials: true})
}

export const hello = () => {
  return axios.get(BASE_API + '/hello', {withCredentials: true})
}
