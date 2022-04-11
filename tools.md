# highPerformanceTest

Demonstration to high performance java system

##Tools:
###Portainer
1. `docker volume create portainer_data`
2. `docker run -d -p 8000:8000 -p 9443:9443 -p 9000:0000 --name portainer --restart=always -v /var/run/docker.sock:/var/run/docker.sock -v portainer_data:/data portainer/portainer-ce:2.11.1`
3. open http://localhost:9000 in the browser.


#Requirements:
##Docker local registry
We will be runing a local registry to our builds.

1. run `docker run -d -p 5000:5000 --restart=always --volume ~/.registry/storage:/var/lib/registry registry:2`
2. `sudo gedit /etc/hosts` --> after localhost entry, add: `registry.dev.svc.cluster.local`

Validating: `curl registry.dev.svc.cluster.local:5000/v2/_catalog`

Return should be `{"repositories":[]}`

3. Adding insecure registries: `sudo gedit /etc/docker/daemon.json`
   
   a. `{
   "insecure-registries": ["registry.dev.svc.cluster.local:5000"]
   }
   `

#Minikube

Starting minikube with 4 cpus and allowing our local registry

1. `minikube start --cpus 4 --memory 4096 --insecure-registry registry.dev.svc.cluster.local:5000`
2. `alias kubectl="minikube kubectl --"`

`kubectl apply -f deployment.yaml`

`kubectl logs XXXXXXXXXx`

`kubectl port-forward deployment/myapp 30001:30001`