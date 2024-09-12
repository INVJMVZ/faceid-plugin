const fs = require('fs');
const path = require('path');

module.exports = function(context) {
  const jsonPath = path.join(context.opts.projectRoot, 'platforms/android/cdv-gradle-config.json');
  
  // Lee el contenido del archivo JSON
  fs.readFile(jsonPath, 'utf8', function(err, data) {
    if (err) {
      console.error('Error reading cdv-gradle-config.json:', err);
      return;
    }

    let config = JSON.parse(data);

    if (config.MIN_SDK_VERSION < 28) {
      config.MIN_SDK_VERSION = 28;
      const updatedJson = JSON.stringify(config, null, 2);

      fs.writeFile(jsonPath, updatedJson, 'utf8', function(err) {
        if (err) {
          console.error('Error writing cdv-gradle-config.json:', err);
        } else {
          console.log('Successfully updated MIN_SDK_VERSION to 28 in cdv-gradle-config.json');
        }
      });
    } else {
      console.log('No update needed, MIN_SDK_VERSION is already 28 or higher');
    }
  });
};
