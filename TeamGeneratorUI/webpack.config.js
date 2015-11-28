module.exports ={
    entry: "./src/app/components/App.jsx",
    output: {
        path: "./build",
        publicPath: "/public/",
        //publicPath: "http://localhost/",
        filename: "bundle.js"
    },
    debug: true,
    devtool: '#eval-source-map',

    module: {
    loaders: [
        { test: /\.jsx$/,
            exclude: /node_modules/,
            loader: "babel-loader",
            query:
            {
                presets:['es2015','react']
            }
        },
        ]
    },

    devServer: {
        proxy: {
            '/rest*': {
                target: 'http://localhost:8082/',
                secure: false,

            },
        },
        headers: { 'Access-Control-Allow-Origin': '*',
                   'Access-Control-Allow-Headers': '*'
        }
    }
}