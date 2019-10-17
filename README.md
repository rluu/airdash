# AirDash

Dashboard webapp that displays charts of air quality from a co2 monitoring device.

#### Author

Ryan Luu

ryanluu@gmail.com

#### Setup details

First start a PostgreSQL server.  
Here are steps I took to get it working from a VirtualBox install of Debian buster:

1) Make sure VirtualBox is configured to have the network connection be in Bridged Adapter mode.

2) Install Docker.

```
su
apt-get install docker docker-compose docker.io docker-doc docker-registry
usermod -a -G docker rluu
exit
```

3) Log out of user `rluu` and log back in as `rluu` and verify that we are now a member of the `docker` group.

```
exit
ssh rluu@192.168.1.119
groups
```

4) Enable docker to start up at boot time and allow user `rluu` to control the docker daemon startup/shutdown.

```
su
systemctl start docker
systemctl restart docker
systemctl enable docker
exit
```

5) As user `rluu`, find and download the postgres docker image.

```
docker search postgres
docker pull postgres
docker images -a
docker ps -a
docker run -i -t -p 5432:5432 -e POSTGRES_PASSWORD=password ${IMAGE_ID_OF_POSTGRES_FROM_DOCKER_PS_COMMAND}
```

---

Optionally, to install and run a Linux docker image:

```
docker search ubuntu
docker run -i -t ubuntu:latest /bin/bash
apt-get update
apt-get install vim
```

Other relevant docker commands:

```
docker images -a
docker ps -q -a
docker ps -a
docker run ${IMAGE_ID}
docker search postgres
docker run -i -t -p 5432 -e POSTGRES_PASSWORD=password ee227fd504c8
```
