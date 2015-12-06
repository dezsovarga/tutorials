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
            players: [],
            currentPage:0,
            perPage: 15,
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
                this.sortBy('skill');
            }.bind(this),
            error: function(xhr, status, err) {
                console.error(url, status, err.toString());
            }.bind(this)
        });
    }

    sortBy(column) {

        // this is always sorting ascending
        this.state.players = _.sortBy( this.state.players, (player)=> {
         
            if (column == 'name') {
                return player.name.toLowerCase();
            }

            if (column == 'skill') {
                this.state.descOrder = true;
                return player.skill;
            }

            if (column == 'initSkill') {
                return player.initSkill;
            }

            return player[column];
        });

        if (this.state.descOrder) {
            this.state.players = this.state.players.reverse();
        }
        // this.searchRequested(false, {target:{value:this.state.filterKey}});
        this.setState({
            sortBy: column,
            descOrder: !this.state.descOrder
        })
    }

     getTotalPages(){
      return Math.ceil(this.state.players.length/this.state.perPage);
    }

    getPagesFooter(){

      var components = [];

      if (this.state.currentPage > 0){
        components.push(
        <div className='page' onClick={this.goToPrevPage.bind(this)}><span className='glyphicon glyphicon-chevron-left'/> prev</div>
        );
      }

      if (this.getTotalPages() > 1 ) {
        components.push(
           <div className='page-info'>page: {this.state.currentPage + 1 } </div>
        );
      }

      if (this.state.currentPage < this.getTotalPages()-1){
        components.push(
         <div className='page' onClick={this.goToNextPage.bind(this)}>next <span className='glyphicon glyphicon-chevron-right'/></div>
        );
      }      

      components.push(
        <span>Total players: {this.state.players.length}</span>
      );


      return components;
    }

    goToPrevPage(){
      this.setState({
        currentPage: this.state.currentPage-1
      });
    }

    goToNextPage(){
      this.setState({
        currentPage: this.state.currentPage+1
      });
    }

    getPlayersTable(){

        var currentPageData = this.state.players.slice(
          this.state.currentPage * this.state.perPage, (this.state.currentPage+1)* this.state.perPage);

        var playerRows = currentPageData.map(function (player, index){

            return (
                <tr>
                    <td className="players_list players_position"> {index +1}.</td>
                    <td className="players_list players_name">{player.name} </td>
                    <td className="players_list players_init_skill"> {player.initSkill/100} </td>
                    <td className="players_list players_init_skill"> {(player.skill - player.initSkill)/100} </td>
                    <td className="players_list players_skill">{player.skill/100} </td>
                    
                </tr>
            );
        });

        return [

            <Table responsive striped bordered condensed hover className="players_list"/*className="table table-striped table-bordered"*/ >
                <thead>
                    <tr>
                        <th> Pos </th>
                        <th> Name </th>
                        <th> Initial skill </th>
                        <th> +/- </th>
                        <th> Skill </th>
                        
                    </tr>
                </thead>
                <tbody>
                    {playerRows}
                </tbody>
            </Table>,
            <div className="pagination"> 
                {this.getPagesFooter()}
            </div>
        ];

        

    }

    render(){
        
        return(

            <div>{this.getPlayersTable()}</div>
        )
    }
}

export default PlayersList;