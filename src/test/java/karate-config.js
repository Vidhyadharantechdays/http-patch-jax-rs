function() {   
  var env = karate.env; // get system property 'karate.env'
  karate.log('karate.env system property was:', env);
  if (!env) {
    env = 'dev';
  }
  var config = {
    env: env,
   apiUrl: 'http://http-patch-vidhya.1d35.starter-us-east-1.openshiftapps.com/v1/'
  };
  if (env === 'dev') {
    // customize
    // e.g. config.foo = 'bar';
  } else if (env === 'e2e') {
    // customize
  }
  //Right now commenting the below for future use
//  config.myObject = karate.read('classpath:test.json');
  return config;
};