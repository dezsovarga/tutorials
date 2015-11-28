import React from 'react';
import GeneratedTeams from './GeneratedTeams.jsx';
class GenerateTeamsForm extends React.Component {

    constructor(props) {
        super(props);

        this.state = {
            players: [],
            teams: [],
            showTextarea :true,
            errorMessage: ""
        };
    }

    handleClickGenerate() {

        var regPlayers = this.refs.registeredPlayers.value.split("\n");
        this.generateTeamsFromServer(regPlayers);
        this.setState({showTextarea:false})

    }

    generateTeamsFromServer(body){

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
                this.setState({errorMessage: xhr.responseText});
            }.bind(this)
        });
    }

    displayRegPlayersForm(){
        return (
            <div>
                <div className="center" id="regPlayersTextArea">
                    <textarea placeholder="Put here the registered player names"
                              name="description" rows="15" cols="25" ref="registeredPlayers">

                    </textarea>
                </div>
                <div className="center">
                    <button onClick={this.handleClickGenerate.bind(this)}> Generate </button>
                </div>

            </div>
        )
    }

    render(){
        var textArea = this.state.showTextarea ? this.displayRegPlayersForm() : "";

        return(
            <div className="center">
                <br/>
                {textArea}
                <GeneratedTeams teams={this.state.teams} errorMessage={this.state.errorMessage}/>

            </div>
        )
    }
}

export default GenerateTeamsForm;