/**
 * Created by varga on 09.11.2015.
 */
import {Alert} from 'react-bootstrap';
import React from 'react';
class GeneratedTeams extends React.Component{

    displayTeamPlayers(team){

        var playerList = team.map(function(player) {

            return (
                <span> {player.name},</span>
            );
        });

        return playerList;
    }

    displayTeams(){

        var teamList = this.props.teams.length === 0 ? [] : $.parseJSON(this.props.teams);
        var that = this;
        var teamsList = teamList.map(function(teamPair){
            return (
                <div>
                    <div> TeamDiff: {teamPair.teamDiff}</div>
                    <br/>
                    <div>
                        {teamPair.team1.name}:
                        {that.displayTeamPlayers(teamPair.team1.players)}
                    </div>
                    <br/>
                    <div>
                        {teamPair.team2.name}:
                        {that.displayTeamPlayers(teamPair.team2.players)}
                    </div>
                    <hr/>
                </div>
            );
        });
        return this.props.errorMessage ? this.getErrorMessage()  : teamsList;
    }

    getErrorMessage() {
        if (this.props.errorMessage) {
            return (
                <Alert bsStyle='danger'>
                    <h4>Failure</h4>
                    <p>{this.props.errorMessage}</p>
                </Alert>
            );
        }
        return null;
    }

    render(){

        return (
            <div>
                {this.displayTeams()}
            </div>

        );
    }
}

export default GeneratedTeams;