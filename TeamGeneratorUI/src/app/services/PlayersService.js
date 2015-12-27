import ApiWrapper from 'services/ApiWrapper';
var Symbol = require('es6-symbol');

let singleton = Symbol();
let singletonEnforcer = Symbol();

class PlayersService {

	constructor(enforcer) {
		if (enforcer != singletonEnforcer){
			throw "Cannot construct singleton";
		}

	}

	static get instance() {
        if (!this[singleton]) {
            this[singleton] = new PlayersService(singletonEnforcer);
        }
        return this[singleton];
    }


    getAllPlayers(){

    	return ApiWrapper.instance.GET('rest/players');	
    }
}	

export default PlayersService;