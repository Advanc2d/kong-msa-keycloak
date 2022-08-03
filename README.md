# kong-msa-keycloak
Keycloak으로 Kong OIDC plugin 적용과 Kong Api gateway 설정을 통하여 MSA환경의 서비스 구현


Config Server

Config server를 만들기 위해 Gradle에 추가
implementation 'org.springframework.cloud:spring-cloud-config-server'
actuator 사용을 위해 Gradle에 추가
implementation 'org.springframework.boot:spring-boot-starter-actuator'
Config server 등록을 위해 init파일에 어노테이션 등록 @EnableConfigServer 
![image](https://user-images.githubusercontent.com/92366375/182621525-d486471b-c143-41ae-a8a9-6cc73fc0dc15.png)
Config Server의 application.properties를 yml로 변경한 후 안의 내용 작성
 
 
Eureka Server
eureka server를 만들기 위해 Gradle에 추가
implementation 'org.springframework.cloud:spring-cloud-starter-netflix-eureka-server'
actuator 사용을 위해 Gradle에 추가
implementation 'org.springframework.boot:spring-boot-starter-actuator'
eureka server 등록을 위해 init 파일에 어노테이션 등록 @EnableEurekaServer 
 
eureka Server의 application.properties를 yml로 변경한 후 안의 내용 작성
 
Each Service
