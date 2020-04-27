import {SET_ERROR} from "../actions";

const error = (state = [], action) => {
  switch (action.type) {
    case SET_ERROR:
      return {
        ...state,
        message: action.message
      }
    default:
      return state
  }
}

export default error