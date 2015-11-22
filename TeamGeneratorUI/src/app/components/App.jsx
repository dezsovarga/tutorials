import React from 'react';
import ReactDOM from 'react-dom';
import {Router, Route, RouteHandler, DefaultRoute} from 'react-router';
import PlayersList from './PlayersList.jsx';
import GenerateTeamsForm from './GenerateTeamsForm.jsx';
import HeaderMenu from './HeaderMenu.jsx';

class App extends React.Component {

    constructor(props) {
        super(props);

        this.state = {
            players: [],
            teams: []
        };
    }


    getInitialState() {
        return {
            players: [],
            teams: []
        };
    }

    render(){

        return (
                <div id='cssmenu'>
                    <HeaderMenu />

                    {this.props.children}
                </div>
        );
    }
};

//var routes = (
//    <Route name="app" path="/" handler={App}>
//        <Route name="players" path="/players" handler={PlayersList}/>
//    </Route>
//);
//
//ReactDOM.render(<Router>{routes}</Router>, document.getElementById('teamgenerator'));

ReactDOM.render(

    (<Router>
        <Route path="/" component={App}>
            <Route path="players" component={PlayersList} />
            <Route path="generate" component={GenerateTeamsForm} />
        </Route>
    </Router>), document.getElementById('teamgenerator')


);

//render((
//    <Router>
//        <Route path="/" component={App}>
//            <Route path="about" component={GenerateTeamsForm} />
//            <Route path="inbox" component={HeaderMenu} />
//        </Route>
//    </Router>
//), document.body)

