### Build and push to DockerHub
```Bash
docker login
```
```Bash
docker build -f Dockerfile -t dnadas98/freeroam:gateway . && \
docker push dnadas98/freeroam:gateway
```