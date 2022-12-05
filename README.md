# Lambda Code Examples
This repo contains all the code examples that I demonstarted in tutorials on my YouTube channel - https://www.youtube.com/c/AjayWadhara

# Serverless Spring Boot 2 example
A basic pet store written with the [Spring Boot 2 framework](https://projects.spring.io/spring-boot/). The `StreamLambdaHandler` object is the main entry point for Lambda.

A basic pet store written with the [Spring Boot 2 framework](https://github.com/awslabs/aws-serverless-java-container/tree/main/samples/springboot2). The `StreamLambdaHandler` object is the main entry point for Lambda.

The application can be deployed in an AWS account using the [Serverless Application Model](https://github.com/awslabs/serverless-application-model). The `template.yml` file in the root folder contains the application definition.

Example HandlerStream.java [AWS Lambda function handler in Java](https://docs.aws.amazon.com/lambda/latest/dg/java-handler.html)

# Pre-requisites   
* [AWS CLI](https://aws.amazon.com/cli/)

# Deployment
In a shell, navigate to the sample's folder and use the SAM CLI to build a deployable package
```
$ mvn clean install
```

# Invoke the lambda with parameters
```shell
[ec2-user@ip-xx~]$ aws lambda invoke  --function-name JavaHander --payload '{ "name": "Bob" }' response.json
{
"ExecutedVersion": "$LATEST",
"StatusCode": 200
}
```
