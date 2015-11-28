/**
 * Created by varga on 10.11.2015.
 */
import React from 'react';
import {Table} from 'react-bootstrap';
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

    getPlayersTable(){

        var playerRows = this.state.players.map(function (player){

            return (
                <tr>
                    <td>{player.name} </td>
                    <td>{player.skill} </td>
                    <td> initialskill </td>
                </tr>
            );
        });

        return (

            <Table responsive>
                <thead>
                    <tr>
                        <th> Name </th>
                        <th> Skill </th>
                        <th> Initial skill </th>
                    </tr>
                </thead>
                <tbody>
                    {playerRows}
                </tbody>
            </Table>

        )

    }

    render(){
        
        return(

            <div>{this.getPlayersTable()}</div>
        )
    }
}

export default PlayersList;