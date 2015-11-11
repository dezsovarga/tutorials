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
                </div>

                <GenerateTeamsForm teams={this.state.teams}/>
            </div>
        );
    }
});

ReactDOM.render(
    <App url="http://localhost/rest/players" pollInterval={5000}/>,
    document.getElementById('teamgenerator')
);

