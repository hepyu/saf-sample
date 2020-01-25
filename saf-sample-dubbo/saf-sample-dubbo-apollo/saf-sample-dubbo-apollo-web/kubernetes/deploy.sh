mkdir -p /datavip/k8s-data/saf-sample-dubbo-apollo-web

kubectl apply -f saf-sample-dubbo-apollo-web-prod-namespace.yaml
kubectl apply -f saf-sample-dubbo-apollo-web-prod-pv-local.yaml
kubectl apply -f saf-sample-dubbo-apollo-web-prod-pvc.yaml
kubectl apply -f saf-sample-dubbo-apollo-web-prod-configmap.yaml
kubectl apply -f saf-sample-dubbo-apollo-web-prod-deployment.yaml
kubectl apply -f saf-sample-dubbo-apollo-web-prod-service.yaml
kubectl apply -f saf-sample-dubbo-apollo-web-prod-ingress.yaml
