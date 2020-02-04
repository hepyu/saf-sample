mkdir -p /datavip/k8s-data/saf-sample-http-apache-httpcomponents-web-receive
chmod -R 777 /datavip/k8s-data/saf-sample-http-apache-httpcomponents-web-receive

kubectl apply -f saf-sample-http-apache-httpcomponents-web-receive-prod-namespace.yaml
kubectl apply -f saf-sample-http-apache-httpcomponents-web-receive-prod-pv-local.yaml
kubectl apply -f saf-sample-http-apache-httpcomponents-web-receive-prod-pvc.yaml
kubectl apply -f saf-sample-http-apache-httpcomponents-web-receive-prod-configmap.yaml
kubectl apply -f saf-sample-http-apache-httpcomponents-web-receive-prod-deployment.yaml
kubectl apply -f saf-sample-http-apache-httpcomponents-web-receive-prod-service.yaml
