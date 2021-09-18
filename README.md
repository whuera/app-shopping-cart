# app-shopping-cart

**Breve Descripcón**

Backend en Java (1.8), plataforma spring-boot / microservicios
implementación conceptual, para un shopping cart (ecommerce)
deploy: Docker in [AWS / Fargate]
Docker: image-shopping-cart:latest
DockerHub: whuera/app-shopping-cart:1.0
Base Datos: conexión con Cluster Mysql [AWS / Fargate]

Microservicios: 
Customers (CRUD)
Products (CRUD)
Checkout (CRUD)
Shopping cart (CRUD)

**Diagramas**

| Modelo | Diagrama |
| -- | -- |
| Entity's | <img width="723" alt="Captura de Pantalla 2021-09-17 a la(s) 23 12 32" src="https://user-images.githubusercontent.com/20179546/133872307-cb38de0b-7d5e-4750-b6d4-3229148b67e5.png"> |
| Controllers | <img width="705" alt="Captura de Pantalla 2021-09-17 a la(s) 23 26 01" src="https://user-images.githubusercontent.com/20179546/133872388-413b0ad5-4f3d-4ed1-a935-227374b23a03.png"> |
| Services | <img width="600" alt="Captura de Pantalla 2021-09-17 a la(s) 23 30 42" src="https://user-images.githubusercontent.com/20179546/133872490-e2783a07-bb16-444a-b4d9-0e14724ba66e.png"> |

**AWS Deploy**

Despliegue del docker, usando ECS / fargate, en 2 Clusters:
[Cluster 1]: Backend microservices-shopping-cart.jar
[Cluster 2]: BDD Mysql

| AWS / Console |
| -- |
| <img width="691" alt="Captura de Pantalla 2021-09-17 a la(s) 23 33 31" src="https://user-images.githubusercontent.com/20179546/133872626-c4bd1a3e-8e7a-4462-aa9c-cad2c30bffb2.png"> |
| -- |

**Pruebas a Microservicios**

Postman Collection (descargarse el plugin para chrome de [Postman](https://chrome.google.com/webstore/detail/postman/fhbjgbiflinjbdggehcddcbncdddomop?hl=es-419))

[![Run in Postman](https://run.pstmn.io/button.svg)](https://www.getpostman.com/collections/9ec544985e92f9346e55)




