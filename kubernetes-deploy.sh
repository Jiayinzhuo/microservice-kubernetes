#!/bin/sh

kubectl create deployment apache --image=jiayinzhuo/microservice-kubernetes-demo-apache
kubectl expose deployment apache --type="LoadBalancer" --port 80
kubectl create deployment catalog --image=jiayinzhuo/catalog
kubectl expose deployment catalog --type="LoadBalancer" --port 8080
kubectl create deployment customer --image=jiayinzhuo/customer
kubectl expose deployment customer --type="LoadBalancer" --port 8080
kubectl create deployment order --image=jiayinzhuo/order
kubectl expose deployment order --type="LoadBalancer" --port 8080
kubectl create deployment hystrix-dashboard --image=jiayinzhuo/hystrix-dashboard
kubectl expose deployment hystrix-dashboard --type="LoadBalancer" --port 8080
