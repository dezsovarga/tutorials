var PlayersList = React.createClass({

    getInitialState: function() {
        return {players: []};
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
        this.loadPlayersFromServer();
        //setInterval(this.loadPlayersFromServer, this.props.pollInterval);
    },

    render: function(){
        var playersList = this.state.players.map(function (player){

            return (
                <div>
                    {player.name}
                </div>

            );
        });
        return (
            <div>
                {playersList}
            </div>
        );
    }

});

ReactDOM.render(
    <PlayersList url="http://localhost/rest/players" pollInterval={2000}/>,
    document.getElementById('teamgenerator')
);

