#!/bin/bash

set -e

docker build -t prometheus .
docker run --add-host=host.docker.internal:host-gateway --name=prometheus -d -p 9090:9090 prometheus
