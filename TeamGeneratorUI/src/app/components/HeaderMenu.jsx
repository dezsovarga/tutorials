/**
 * Created by varga on 10.11.2015.
 */
var Link = ReactRouter.Link;
var HeaderMenu = React.createClass({

    render: function(){
        return(
            <ul>
                <li className='active'><Link to="/generate"><span>Generate</span></Link></li>
                <li><Link to="/players"><span>Players</span></Link></li>
                <li><Link to="/"><span>Statistics</span></Link></li>
                <li className='last'><Link to="/"><span>History</span></Link></li>
            </ul>

        )
    }
});