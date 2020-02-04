mvn clean package -Dmaven.test.skip=true
docker build -t saf-sample-dubbo-apollo-service:1.0.0-SNAPSHOT .
