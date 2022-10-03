# kong-msa-keycloak
Keycloak으로 Kong OIDC plugin 적용과 Kong Api gateway 설정을 통하여 MSA환경의 서비스 구현

주제 미정

1. Config Server - 외부 설정을 github repository로 설정

2. Eureka Server - 각 서비스의 등록, 검색(kong api gateway, spring 외의 프로젝트들은 어떻게 등록할 것인가?)

3. KONG API Gateway - OIDC Plugin과 Keycloak 을 설정하여 보안

4. Keycloak - Keycloak을 통한 인증 / 인가(회원 DB 연동과 회원가입, 로그인 등의 뷰 수정 가능한지?)

5. 구글 OTP 추가로 보안 강화

6. Spring, Nodejs, JSP 등 다양한 프로젝트 사용하여 MSA 구성 예정

Config Server

Config server를 만들기 위해 Gradle에 추가

implementation 'org.springframework.cloud:spring-cloud-config-server'

actuator 사용을 위해 Gradle에 추가

implementation 'org.springframework.boot:spring-boot-starter-actuator'

Config server 등록을 위해 init파일에 어노테이션 등록 @EnableConfigServer 
![image](https://user-images.githubusercontent.com/92366375/182621525-d486471b-c143-41ae-a8a9-6cc73fc0dc15.png)

Config Server의 application.properties를 yml로 변경한 후 안의 내용 작성
![image](https://user-images.githubusercontent.com/92366375/182621700-f921e30d-e834-4fb1-a9ff-3c0b356b9817.png)

 
 
Eureka Server
eureka server를 만들기 위해 Gradle에 추가

implementation 'org.springframework.cloud:spring-cloud-starter-netflix-eureka-server

actuator 사용을 위해 Gradle에 추가

implementation 'org.springframework.boot:spring-boot-starter-actuator'

eureka server 등록을 위해 init 파일에 어노테이션 등록 @EnableEurekaServer 
 ![image](https://user-images.githubusercontent.com/92366375/182621763-40a3fe3c-f3d6-4191-a331-4064b3978cb8.png)

eureka Server의 application.properties를 yml로 변경한 후 안의 내용 작성
 ![image](https://user-images.githubusercontent.com/92366375/182621783-7ddbc3fa-fb0b-4d25-afb8-a22321cd8a5f.png)

Each Service
