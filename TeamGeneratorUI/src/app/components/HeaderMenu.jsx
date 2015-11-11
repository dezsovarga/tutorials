/**
 * Created by varga on 10.11.2015.
 */
var HeaderMenu = React.createClass({

    render: function(){
        return(
            <ul>
                <li className='active'><a href='#'><span>Generate</span></a></li>
                <li><a href='#'><span>Players</span></a></li>
                <li><a href='#'><span>Statistics</span></a></li>
                <li className='last'><a href='#'><span>History</span></a></li>
            </ul>
        )
    }
});