#!/bin/sh

kubectl run apache --image=jiayinzhuo/microservice-kubernetes-demo-apache --port=80
kubectl expose deployment/apache --type="LoadBalancer" --port 80
kubectl run catalog --image=jiayinzhuo/catalog --port=8080
kubectl expose deployment/catalog --type="LoadBalancer" --port 8080
kubectl run customer --image=jiayinzhuo/customer --port=8080
kubectl expose deployment/customer --type="LoadBalancer" --port 8080
kubectl run order --image=jiayinzhuo/order --port=8080
kubectl expose deployment/order --type="LoadBalancer" --port 8080
kubectl run hystrix-dashboard --image=jiayinzhuo/hystrix-dashboard --port=8080
kubectl expose deployment/hystrix-dashboard --type="LoadBalancer" --port 8080
