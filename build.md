### Build and push to DockerHub
```Bash
docker login
```
```Bash
docker build -f Dockerfile -t dnadas98/priv:freeroam_gateway . && \
docker push dnadas98/priv:freeroam_gateway
```