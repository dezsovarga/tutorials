/**
 * Created by varga on 09.11.2015.
 */

var GeneratedTeams = React.createClass({

    displayTeamPlayers: function(team){

        var playerList = team.map(function(player) {

            return (
                <span> {player.name},</span>
            );
        });

        return playerList;
    },

    displayTeams: function(){

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
        return this.props.errorMessage ? this.props.errorMessage : teamsList;
    },

    render : function(){

        return (
            <div>
                {this.displayTeams()}
            </div>

        );
    }
});