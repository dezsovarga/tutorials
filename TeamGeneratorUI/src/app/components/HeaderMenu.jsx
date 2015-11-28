/**
 * Created by varga on 10.11.2015.
 */
import React from 'react';
import {Link} from 'react-router';

class HeaderMenu extends React.Component {

    render(){
        return(
            <div>

                <ul>
                    <li className='active'><Link to="/generate"><span>Generate</span></Link></li>
                    <li><Link to="/players"><span>Players</span></Link></li>
                    <li><Link to="/players"><span>Statisticssss</span></Link></li>
                    <li className='last'><Link to="/players"><span>History</span></Link></li>
                </ul>

             </div>

        )
    }
}

export default HeaderMenu;