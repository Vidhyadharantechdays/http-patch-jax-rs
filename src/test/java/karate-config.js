function() {   
  var env = karate.env; // get system property 'karate.env'
  karate.log('karate.env system property was:', env);
  if (!env) {
    env = 'live';
  }
  var config = {
    env: env,
   apiUrl: 'http://http-patch-vidhya.1d35.starter-us-east-1.openshiftapps.com/v1/'
  };
  if (env === 'dev') {
    // customize
   config.apiUrl = 'http://localhost:18080/http-patch-jax-rs/v1/';
  } else if (env === 'e2e') {
    // customize
  }
  //Right now commenting the below for future use
//  config.myObject = karate.read('classpath:test.json');
  return config;
};