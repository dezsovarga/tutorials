var PlayersList = React.createClass({

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

    generateTeamsFromServer: function(body){

        var generateTeamsUrl = "http://localhost/rest/teams/generate";
        $.ajax({
            type: "POST",
            url: generateTeamsUrl,
            dataType: 'json',
            contentType: 'application/json',
            cache: false,
            data: JSON.stringify(body),
            success: function(data) {
                this.setState({teams: JSON.stringify(data)});
            }.bind(this),
            error: function(xhr, status, err) {
                console.error(generateTeamsUrl, status, err.toString());
                this.setState({teams: JSON.stringify(xhr.responseText)});
            }.bind(this)
        });
    },

    componentDidMount: function() {
        this.loadPlayersFromServer();
        //setInterval(this.loadPlayersFromServer, this.props.pollInterval);
    },

    handleClickGenerate: function() {

        var regPlayers = this.refs.registeredPlayers.value.split("\n");
        this.generateTeamsFromServer(regPlayers);
        //this.setState({teams: regPlayers });
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
            <div>
                <div className="left" id="players">
                    {playersList}
                </div>

                <div className="right">
                    <div>
                        <textarea placeholder="Put here the registered player names"
                              name="description" rows="20" cols="30" ref="registeredPlayers"/>
                    </div>
                    <div>
                        <button onClick={this.handleClickGenerate}> Generate </button>
                    </div>

                    <GeneratedTeams teams={this.state.teams}/>
                </div>
            </div>

        );
    }

});

ReactDOM.render(
    <PlayersList url="http://localhost/rest/players" pollInterval={5000}/>,
    document.getElementById('teamgenerator')
);

