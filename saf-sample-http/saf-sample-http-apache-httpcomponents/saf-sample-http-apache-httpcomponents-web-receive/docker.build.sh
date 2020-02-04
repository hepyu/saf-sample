mkdir -p /datavip/k8s-data/saf-sample-http-apache-httpcomponents-web-receive
mvn clean package -Dmaven.test.skip=true
docker build -t saf-sample-http-apache-httpcomponents-web-receive:1.0.0-SNAPSHOT .
