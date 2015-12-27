let singleton = Symbol();
let singletonEnforcer = Symbol();

/**
 * Object that provides access to making HTTP requests.
 */
class ApiWrapper {

    constructor(enforcer) {
        this.baseUrl = "http://localhost/";
        if(enforcer != singletonEnforcer) throw "Cannot construct singleton";
    }

    static get instance() {
        if(!this[singleton]) {
            this[singleton] = new ApiWrapper(singletonEnforcer);
        }
        return this[singleton];
    }

    GET(path, params, additionalHeaders) {
        
        return this.GETAbsoluteUrl(
                this.baseUrl + path + (params ? '?' + params : '' ),
                additionalHeaders
        );
    }

    GETAbsoluteUrl(url, additionalHeaders) {

        return $.ajax({
            headers: _.extend({
                'Content-Type': 'application/json'
            }, additionalHeaders),
            url: url,
            //cache: !!bypassJQueryCache,
            async: true,
            method: 'GET',
            contentType: 'application/json'
        });
    }
}

export default ApiWrapper;