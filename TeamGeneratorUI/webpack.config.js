module.exports ={
    entry: "./src/app/components/App.jsx",
    output: {
        path: "./build",
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
    }
}