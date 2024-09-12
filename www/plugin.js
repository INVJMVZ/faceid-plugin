
var exec = require('cordova/exec');

var PLUGIN_NAME = 'FaceIdPlugin';

var FaceIdPlugin = {
  test: function (name, successCallback, errorCallback) {
    exec(successCallback, errorCallback, PLUGIN_NAME, "test", [name]);
  }
};

module.exports = FaceIdPlugin;
