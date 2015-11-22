import React from 'react';
import App from './App.jsx';
import ReactDOM from 'react-dom';
import {Router, Route} from 'react-router';
import PlayersList from './PlayersList.jsx';
import GenerateTeamsForm from './GenerateTeamsForm.jsx';


main();

function main() {
    ReactDOM.render(

        (<Router>
            <Route path="/" component={App}>
                <Route path="players" component={PlayersList} />
                <Route path="generate" component={GenerateTeamsForm} />
            </Route>
        </Router>), document.getElementById('teamgenerator')

        //<App url="http://localhost/rest/players" pollInterval={5000}/>,
        //document.getElementById('teamgenerator')
    );
}