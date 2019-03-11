# hello-cloud-app
docker build -t sai194/ubuntuwithjdk . 

docker build -t sai194/ubuntuwithjdkandmaven .

docker build -t sai194/hello-cloud-app .

docker run -d -p 3000:8080 sai194/hello-cloud-app

docker push sai194/hello-cloud-app
