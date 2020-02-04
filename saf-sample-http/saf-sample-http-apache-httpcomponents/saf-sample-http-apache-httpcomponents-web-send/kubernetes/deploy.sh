mkdir -p /datavip/k8s-data/saf-sample-http-apache-httpcomponents-web-send

kubectl apply -f saf-sample-http-apache-httpcomponents-web-send-prod-namespace.yaml
kubectl apply -f saf-sample-http-apache-httpcomponents-web-send-prod-pv-local.yaml
kubectl apply -f saf-sample-http-apache-httpcomponents-web-send-prod-pvc.yaml
kubectl apply -f saf-sample-http-apache-httpcomponents-web-send-prod-configmap.yaml
kubectl apply -f saf-sample-http-apache-httpcomponents-web-send-prod-deployment.yaml
kubectl apply -f saf-sample-http-apache-httpcomponents-web-send-prod-service.yaml
kubectl apply -f saf-sample-http-apache-httpcomponents-web-send-prod-ingress.yaml
