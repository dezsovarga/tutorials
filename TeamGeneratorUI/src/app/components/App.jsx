//var Route = require('react-router').Route
var Router = ReactRouter.Router;
var Route = ReactRouter.Route;
var App = React.createClass({

    getInitialState: function() {
        return {
            players: [],
            teams: []
        };
    },

    loadPlayersFromServer: function() {
        $.ajax({
            type: "GET",
            url: this.props.url,
            dataType: 'json',
            cache: false,
            success: function(data) {
                this.setState({players: data});
            }.bind(this),
            error: function(xhr, status, err) {
                console.error(this.props.url, status, err.toString());
            }.bind(this)
        });
    },



    componentDidMount: function() {
        //this.loadPlayersFromServer();
        //setInterval(this.loadPlayersFromServer, this.props.pollInterval);
    },



    render: function(){
        var playersList = this.state.players.map(function (player){

            return (
                <div key={player.name}>
                        <span className="left"> {player.name} </span>
                        <span className="right"> {player.skill} </span>
                <br/>
                </div>
            );
        });
        return (
            <div class>
                <div id='cssmenu'>
                    <HeaderMenu />
                    {this.props.children}
                </div>


            </div>
        );
    }
});

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

//render((
//    <Router>
//        <Route path="/" component={App}>
//            <Route path="about" component={GenerateTeamsForm} />
//            <Route path="inbox" component={HeaderMenu} />
//        </Route>
//    </Router>
//), document.body)

