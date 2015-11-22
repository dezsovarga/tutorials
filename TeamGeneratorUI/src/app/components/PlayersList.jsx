/**
 * Created by varga on 10.11.2015.
 */
import React from 'react';
//import ReactDOM from 'react-dom';
class PlayersList extends React.Component {

    constructor(props) {
        super(props);

        this.state = {
            players: []
        };
    }

    //getInitialState() {
    //    return {
    //        players: []
    //    };
    //}

    componentDidMount() {
        this.loadPlayersFromServer();
        //setInterval(this.loadPlayersFromServer, this.props.pollInterval);
    }

    loadPlayersFromServer() {
        var url="http://localhost/rest/players";
        $.ajax({
            type: "GET",
            url: url,
            dataType: 'json',
            cache: false,
            success: function(data) {
                this.setState({players: data});
            }.bind(this),
            error: function(xhr, status, err) {
                console.error(url, status, err.toString());
            }.bind(this)
        });
    }

    render(){
        var playersList = this.state.players.map(function (player){

            return (
                <div key={player.name}>
                    <span className="left"> {player.name} </span>
                    <span className="right"> {player.skill} </span>
                    <br/>
                </div>
            );
        });
        return(

            <div>{playersList}</div>
        )
    }
}

export default PlayersList;