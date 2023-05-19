# Cloud Devolper Lv3 Education
![image](https://user-images.githubusercontent.com/49936027/203254202-97ae6b49-9b0b-4204-b2b2-b15b07335774.png)

## 예제 - 음식배달
본 예제는 MSA/DDD/Event Storming/EDA 를 포괄하는 분석/설계/구현/운영 전단계를 커버하도록 구성한 예제입니다. 이는 클라우드 네이티브 애플리케이션의 개발에 요구되는 체크포인트들을 통과하기 위한 예시 답안을 포함합니다.

### 설계
- Fooddelivery 모델링 후 github commit & push
- 개발 중간에 모델 수정시, 코드레벨에서 sync.추천
### 구현
- gitpod 사용시 : Kafka 설치 필요 없음.
- local 환경 사용시 : Kafka standalone 설치필요
### 배포
- Cloud : 쿠버네티스 설치 필요없음,Kafka 설치필요
- 쿠버네티스 유틸리티 Lab 참조
- Kubernetes 작업시, (./init.sh)
### 운영
- Zero-downtime Deploy : 셀프힐링 & 무정지 배포 실습 Lab참조

## 서비스 시나리오
### 기능적 요구사항
- 고객이 메뉴를 선택하여 주문한다.
- 고객이 선택한 메뉴에 대해 결제한다.
- 주문이 되면 주문 내역이 입점상점주인에게 주문정보가 전달된다.
- 상점주는 주문을 수락하거나 거절할 수 있다.
- 상점주는 요리시작때와 완료 시점에 시스템에 상태를 입력한다. •고객은아직요리가시작되지않은주문은취소할수있다.
- 요리가 완료되면 고객의 지역 인근의 라이더들에 의해 배송건 조회가 가능하다. • 라이더가 해당 요리를 Pick한 후, 앱을 통해 통보한다.
- 고객이 주문상태를 중간중간 조회한다.
- 라이더의 배달이 끝나면 배송확인 버튼으로 모든 거래가 완료된다.


### 1.Eventstorming Model
www.msaez.io/#/storming/clouldlvsm
![image](https://github.com/BoyoungHyeon/clould-lv3/assets/49936027/69f9c830-c14e-4b02-8ce2-3ebb5dd908d7)

### 2. Saga (Pub / Sub) 확인 (클러스터에 Kafka 설치 후)
![image](https://github.com/BoyoungHyeon/clould-lv3/assets/49936027/2c96c144-801f-4227-a2d3-83c977b7e04c)

### 3.Service Router 설치
![image](https://github.com/BoyoungHyeon/clould-lv3/assets/49936027/5b01930e-8545-4af0-9d62-4080838e36e5)

### 4.Zero downtime Deployment
![image](https://github.com/BoyoungHyeon/clould-lv3/assets/49936027/eb29bbb5-1922-4b46-a7f7-44002334c52c)


## Before Running Services
### Make sure there is a Kafka server running
```
cd kafka
docker-compose up
```
- Check the Kafka messages:
```
cd kafka
docker-compose exec -it kafka /bin/bash
cd /bin
./kafka-console-consumer --bootstrap-server localhost:9092 --topic
```

## Run the backend micro-services
See the README.md files inside the each microservices directory:

- app
- store
- delivery
- customerCenter


## Run API Gateway (Spring Gateway)
```
cd gateway
mvn spring-boot:run
```

## Test by API
- app
```
 http :8088/orders id="id" foodId="foodId" amount="amount" customerId="customerId" options="options" address="address" status="status" 
```
- store
```
 http :8088/orderManages id="id" foodId="foodId" orderId="orderId" amount="amount" options="options" address="address" status="status" 
```
- delivery
```
 http :8088/deliveries id="id" orderId="orderId" riderId="riderId" address="address" status="status" 
```
- customerCenter
```
```


## Run the frontend
```
cd frontend
npm i
npm run serve
```

## Test by UI
Open a browser to localhost:8088

## Required Utilities

- httpie (alternative for curl / POSTMAN) and network utils
```
sudo apt-get update
sudo apt-get install net-tools
sudo apt install iputils-ping
pip install httpie
```

- kubernetes utilities (kubectl)
```
curl -LO "https://dl.k8s.io/release/$(curl -L -s https://dl.k8s.io/release/stable.txt)/bin/linux/amd64/kubectl"
sudo install -o root -g root -m 0755 kubectl /usr/local/bin/kubectl
```

- aws cli (aws)
```
curl "https://awscli.amazonaws.com/awscli-exe-linux-x86_64.zip" -o "awscliv2.zip"
unzip awscliv2.zip
sudo ./aws/install
```

- eksctl 
```
curl --silent --location "https://github.com/weaveworks/eksctl/releases/latest/download/eksctl_$(uname -s)_amd64.tar.gz" | tar xz -C /tmp
sudo mv /tmp/eksctl /usr/local/bin
```

