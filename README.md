# todo_list

Este repositorio apresenta uma possível implementação do Back-end de um To Do List (Lista de Tarefas).

Sua implementação foi realizada na linguagem Java.
## Formas de utilização
Foi realizado o deploy da API no heroku e se encontra díponível em **https://todo-list-challenge.herokuapp.com**<br>
Entretanto pode ser testada localmente utilizando se o perfil de dev e/ou test.<br>
Para isso é necessáiria a alteração do perfil padrão (prod) para o desejado (dev ou test).

## Rotas Dísponíveis
###/todo-lists
**Essa rota permite:**
  -Criação de uma nova Lista.
  -Consultar Listas existentes.
  
  #### Criando uma nova lista de tarefas:
  
  ex: https://todo-list-challenge.herokuapp.com/todo-lists
  Body da requisição
  ```
  {   
    "name":"clean home",
    "created_at": "2019-06-20T19:53:07Z"
  }
  ```
  #### Listando Listas de Tarefas:
  Basta requisição GET.
  ex: https://todo-list-challenge.herokuapp.com/todo-lists
  
### /tasks

**Essa rota permite:**
  - Criação de uma tarefa.
  - Edição de uma tarefa já cadastrada na base de dados.
  - Exclusão de uma tarefa através do seu id.
  - Consulta de tarefas.
 
#### Criando uma nova tarefa:
ex: https://todo-list-challenge.herokuapp.com/tasks ou localhost:8080/tasks<br>
Body da requisição
 ```
 {
    "description": "Calculus Home work",
    "status": false,
    "toDoList": {
        "id": 1,
        "name": "Home Works",
        "created_at": "2019-06-20T19:53:07Z"
    }
}
 
 ```
 ### Editando uma tarefa:
 Campos que aceitam modificações: "status" e "description".<br>
 
 ex: https://todo-list-challenge.herokuapp.com/tasks/1 ou localhost:8080/tasks/1<br>
 Body da requisição
 ```
 {
    "description": "Algebra Home work",
    "status": true,
    "toDoList": {
        "id": 1,
        "name": "Home Works",
        "created_at": "2019-06-20T19:53:07Z"
    }
}
 
 ```
 ### Listando tarefas:
 Para listar todas basta realizar requisição get<br> 
 ex: https://todo-list-challenge.herokuapp.com/tasks/ ou localhost:8080/tasks/<br><br>
 Para listar tarefa específica basta informar o seu id.<br><br>
 ex: https://todo-list-challenge.herokuapp.com/tasks/1 ou localhost:8080/tasks/1<br>
 
 ### Deletando um tarefa:
  Basta informar o seu id.<br> 
 ex: https://todo-list-challenge.herokuapp.com/tasks/1 ou localhost:8080/tasks/1
 
 
