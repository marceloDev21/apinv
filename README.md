#  Projeto inventário Spring Boot

Sistema de inventario básico com APIs REST usando Spring Boot

##  Como executar

Este aplicativo possui o Tomcat 9 incorporado. Nenhuma instalação do Tomcat ou JBoss é necessária.
* Clonar este repositório
* Certifique-se de estar usando JDK 17 e Maven 3.x

* Se tiver usando Spring Tolls siga os passos:
* file -> import -> maven -> existing Maven Project e seleciona o local do projeto

## Documentação da API

#### Retorna todos os produtos

```http
  GET /api/produto
```

#### Retorna um produto 

```http
  GET /api/produto/${id} 
```

#### Adiciona um produto

```http
  POST /api/produto/${id} 
```

#### Deleta um produto

```http
  DELETE /api/produto/${id} 
```

#### Filtrar pelo codigo do produto 

```http
  GET /api/produto/codigo/${codigo} 
```

### Alguns endpoints

```
http://localhost:8080/api/produto
http://localhost:8080/api/local
http://localhost:8080/api/tipo
http://localhost:8080/api/pessoa
```
### Banco de dados 
Foi utilizado o DBeaver com MySql.
Estrutura do banco:
![mer-inventariov2](https://user-images.githubusercontent.com/116357603/225934916-a48ec517-9f0d-41bc-9a0b-205e81fe620f.png)

###  Para visualizar a API documentada pelo Swagger 
```
Execute o servidor e navegue até http://localhost:8080/swagger-ui/index.html#/
```

###  Para visualizar as metricas da API pelo Prometheus 
```
Execute o servidor e navegue até http://localhost:9090/graph
```

###  Para ter uma melhor visualização das metricas da API, acesse o Grafana 
```
Execute o servidor e navegue até http://localhost:3000
```