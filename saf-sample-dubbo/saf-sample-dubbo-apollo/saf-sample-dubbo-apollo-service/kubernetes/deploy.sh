mkdir -p /datavip/k8s-data/saf-sample-dubbo-apollo-service
chmod -R 777 /datavip/k8s-data/saf-sample-dubbo-apollo-service

kubectl apply -f saf-sample-dubbo-apollo-service-prod-namespace.yaml
kubectl apply -f saf-sample-dubbo-apollo-service-prod-pv-local.yaml
kubectl apply -f saf-sample-dubbo-apollo-service-prod-pvc.yaml
kubectl apply -f saf-sample-dubbo-apollo-service-prod-configmap.yaml
kubectl apply -f saf-sample-dubbo-apollo-service-prod-deployment.yaml
kubectl apply -f saf-sample-dubbo-apollo-service-prod-service.yaml
