- db 연결정보와 jwt 키 값은 github에서 관리하지 않고 따로 관리

application-db.yml

```yaml
spring:
  datasource:
    driver-class-name: com.mysql.cj.jdbc.Driver
    username: root
    password: 4281
    url: jdbc:mysql://localhost:3306/thecommerce?serverTimezone=Asia/Seoul&characterEncoding=UTF-8

  jpa:
    open-in-view: 'true'
    properties:
      hibernate:
        default_batch_fetch_size: '1000'
        format_sql: 'true'
        show_sql: 'true'
    hibernate:
      ddl-auto: update
      naming:
        physical-strategy: org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl
```

application-jwt.yml

```yaml
jwt:
  secret: javainuse
```
