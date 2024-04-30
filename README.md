# user service

---

### Scope 
1. A service handles about user information.
2. This service provides APIs to CRUD user data.
3. This service provides authentication and authorization.
4. Service uses MySQL as RDBMS database



### Related Java topic
1. Spring boot, secure, JPA
2. Mapstruct
3. OOP
4. Oauth2, JWT

---

### Running locally
1. Copy `application-local-template.properties` to `application-local.properties`
2. Add environment variable `SPRING_PROFILES_ACTIVE=local`
3. Start MySQL
4. Run database changelog from [this](https://github.com/hokkung/user-changelog)
5. Generate key pair 
   1. create certs folder 
      1. `cd src/main/resources/certs`
   2. generate RSA private key using openssl
      3. `openssl genrsa -out keypair.pem 2048`
   3. extract public key from private key
      4. ` openssl rsa -in keypair.pem -pubout -out publicKey.pem`
   5. format private key in supported format (PKCS8)
      6. `openssl pkcs8 -topk8 -inform PEM -outform PEM -nocrypt -in keypair.pem -out privateKey.pem`
6. start maven
