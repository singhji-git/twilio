# api-ai-twilio
Sample agent to integrate [Api.ai](http://api.ai) with [Twilio SMS](https://twilio.com) service.

# Deploy

Insert API key to the configuration file: src/main/resources/twilio.properties:
```
apiai.accessToken=<YOUR_CLIENT_ACCESS_TOKEN>
```

Run maven build:
```
mvn clean install
```

Deploy war file to the servlet container.

Go to www.twilio.com. Configure your number and set the following url as a callback on incoming SMS:
```
<YOUR_SERVER_URL>/twilio/sms
```




..............................................................


# Api.ai - sample webhook implementation.

This is a really simple webhook implementation that gets Api.ai classification JSON (i.e. a JSON output of Api.ai /query endpoint) and returns a fulfillment response.

More info about Api.ai webhooks could be found here:
[Api.ai Webhook](https://docs.api.ai/docs/webhook)

# Deploy to:
[![Deploy to Heroku](https://www.herokucdn.com/deploy/button.svg)](https://heroku.com/deploy)

# What does the service do?
It's a simple echo service that takes `resolvedQuery` and `action` fields from the Api.ai JSON reponse and echoes them back in into `speech` and `displayTest` fields in the fulfillment JSON.

