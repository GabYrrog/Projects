const path = require("path");
const HtmlWebpackPlugin = require('html-webpack-plugin');
const Webpack = require('webpack');

module.exports = {
  module: {
    rules: [
      {
        test: /\.css$/,
        use: ['style-loader', 'css-loader'],
      },
      {
        test: /\.html$/,
        use: ['html-loader'],
      },
      // ... other rules
    ],
  },
  devServer: {
    historyApiFallback: {
      rewrites: [
        { from: /^\/meteo.html/, to: '/meteo.html' },
        // ... other rewrites if necessary
      ]
    },
    static: {
      directory: path.join(__dirname, 'client/dist'),
    },
    compress: true,
    port: 9000, // you can choose the port
    open: true, // to open the browser automatically
  },
    entry : {
		index : './client/src/page-index.js',
		meteo : './client/src/page-meteo.js',
    },
    mode : 'development',
    output : {
        filename : '[name].js',
        path : path.resolve(__dirname, 'client/dist')
    },
    plugins: [
      new HtmlWebpackPlugin({
        filename: 'index.html',
        template: 'client/src/index.html',
        chunks: ['index']
      }),
      new HtmlWebpackPlugin({
        filename: 'meteo.html',
        template: 'client/src/meteo.html', 
        chunks: ['meteo']
      }) 
    ]
    
    
}