import React from 'react'
import {Route, Switch} from 'react-router-dom'
import Home from '../../containers/Home'
import Navbar from '../../containers/Navbar'
import FacebookLogin from '../../components/FacebookLogin'
import LogOut from '../../containers/Logout'
import WithOauth from '../../containers/WithOauth'
import Error from '../../containers/Error'

export function App() {
  return (
      <div>
        <Navbar />
        <Switch>
          <Route exact path='/' component={Home} />
          <Route path='/login' component={FacebookLogin} />
          <Route path='/logout' component={LogOut} />
          <Route path='/error' component={Error}/>
        </Switch>
      </div>
  )
}

export default WithOauth(App)
