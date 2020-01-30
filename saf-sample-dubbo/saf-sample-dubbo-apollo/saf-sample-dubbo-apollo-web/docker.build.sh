mvn clean package -Dmaven.test.skip=true
docker build -t saf-sample-dubbo-apollo-web:1.0.0-SNAPSHOT .
