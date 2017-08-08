var exec = require('cordova/exec');

exports.toScore = function(arg0, success, error) {
    exec(success, error, "score", "toScore", [arg0]);
};
