# Curso Spring boot, hibernate, JWT, IONIC and others
- Passo a passo da construção do projeto de um sistema de pedidos para fixação.
- Todo o backend disponível.

## Arquitetura do projeto
- Aplicação do Cliente (IONIC)
- Controladores REST (Resources)
- Camada de Serviço (Services)
- Camada de acesso a dados (Repository)
- Camada de dominio (Domain)
---------------------
### [Criando o projeto](https://github.com/Samirsilva/cursomc/commit/a8b2d6c94f21330e83d1fe51ce0a993850cb8ff0)
1. Gerar o projeto spring no **STS** do spring.
2. Criar um repositório na pasta onde está seu **projeto local**.
3. Criar um **repositório** no GitHub.
4. Configurar o github com o seu repositório.

### [Testando REST](https://github.com/Samirsilva/cursomc/commit/fd8be5bb088fa86c23c98451dd91dabf96901af0)
1. Crie um **serviço REST** com o nome de **CategoriaResource** com o pacote **com.cursomc.resources**.
2. Insira a anotação **@RestController** que indicará que essa classe é um serviço REST.
3. Insira a anotação **@RequestMapping** com o valor **/categorias** que irá apontar o nome que deve ser usado na URL para consultar o serviço.
4. Crie um metodo do tipo **String** com o nome **listar()**.
5. Em cima do metodo **listar()** insira a anotação **@RequestMapping** com o method **GET** indicando que é um metodo para trazer alguma coisa.
6. Retorne uma String **"Funcionando"**.
7. Rode seu programa e acesse o **localhost:8080/categorias**.
8. Acesse o postman ou outro serviço REST que você usa e acesse o mesmo link.

### [Testando a primeira classe de dominio](https://github.com/Samirsilva/cursomc/commit/87c0c33257a482a886ecd6561af708568732b025)
1. Crie uma classe de dominio chamada **Categoria** com o pacote **com.cursomc.domain**.
2. Na classe de dominio crie as variaveis: id e nome.
3. Implemente na classe de dominio o **Serializable** e gere sua variável padrão faltante.
4. Gere o construtor vazio.
5. Gere o construtor passando seus parametros.
6. Gere o **hashcode()** e **equals()** apenas com o id.
7. Na classe **CategoriaResource** no metodo **listar()** modifique o tipo para **List Categoria**.
8. Crie dois objetos do tipo **Categoria** e instancie como um novo objeto com o id e nome.
9. Crie uma Lista do tipo **Categoria** e inicie como **ArrayList()**.
10. Adicione os objetos na lista.
11. Retorne a lista.
12. Rode seu projeto e abra o navegador na URL **localhost:8080/categorias**.
13. Acesse o postman ou outro serviço REST que você use e acesse o link **localhost:8080/categorias**.

### [Banco de dados H2 e criacao automatica da base de dados](https://github.com/Samirsilva/cursomc/commit/bf79a743be4a17db35e3eb4dffc6d9902972ddf6)
1. Adicione no **pom.xml** as dependências necessárias.
2. Acesse a classe de dominio **Categoria** adicione a anotação **@Entity** na classe, para identifica-lo como uma entidade relacional.
3. No id insira a anotação **@Id** e logo a baixo insira a anotação **@GeneratedValue(strategy=GenerationType)** e escolha o **.IDENTITY**.
4. Dentro da pasta **resources** acesse o arquivo **application.properties**.
5. Insira as linhas: 
  - spring.h2.console.enabled=true  
  - spring.h2.console.path=/h2-console 
  - spring.datasource.url=jdbc:h2:mem:cursomc
  - spring.datasource.username=sa 
  - spring.datasource.password= 
  - spring.datasource.driver-class-name=org.h2.Driver  
  - spring.jpa.show-sql=true 
  - spring.jpa.properties.hibernate.format_sql=true  
6. Rode seu programa e acesse o link **localhost:8080/h2-console** e acesse o banco com os dados e você irá verificar a criação da tabela Categoria.

### [Criando repository e service para categoria](https://github.com/Samirsilva/cursomc/commit/6b3704c5231c8c05d7f7b8d4dba04de5359354c4)
1. Crie uma interface de nome **CategoriaRepository** com o pacote **com.cursomc.repositories** insira uma anotação com o nome **@Repository** e extenda ela para **JpaRepository** e passe **Categoria, Integer**.
2. Crie uma classe de nome **CategoriaService** com o pacote **com.cursomc.services** insira uma anotação com o nome **@Service**, 
3. Nessa classe crie uma variável do tipo **CategoriaRepository** com nome repo e insira a anotação **@Autowired**. 
4. Crie um metodo com nome **buscar()** passando como parâmetro o id do tipo Integer o metodo deve ser do tipo **Categoria**. 
5. Dentro dele voce irá criar um objeto do tipo **Optional** de categoria recebendo **repo.findById(id)**
6. Retorne o **obj.orElse(null)**. 
7. Em **CategoriaResource** acrescente o value no **@RequestMapping** para **"/{id}"**.
8. Altere o tipo e o nome do metodo para **ResponseEntity<?>** e **find(@PathVariable Integer id)**.
9. Crie uma variavel do tipo **CategoriaService** com a anotação **@Autowired**.
10. Delete todo o corpo do metodo.
11. Crie um objeto do tipo categoria recebendo **service.buscar(id)**
12. Retorne um **ResponseEntity.ok().body(obj)**, passando o objeto em obj.

### [Criando operação de instanciação](https://github.com/Samirsilva/cursomc/commit/1553125cdb01f288d7032d25f42db659ce493863)
1. Na classe principal da aplicação implemente **CommandLineRunner** e o metodo que irá faltar.
2. Nessa classe crie uma variável do tipo **CategoriaRepository** com nome repo e insira a anotação **@Autowired**. 
3. Dentro do novo metodo crie dois objetos do tipo **Categoria**.
4. e usando o **categoriaRepository** dê um **saveAll(Arrays.asList(cat1, cat2))**.

### [Produto e associacao muitos para muitos](https://github.com/Samirsilva/cursomc/commit/0e1be2994dba34dc2d1fb2f65429b2670f198c49)
1. Crie uma classe de dominio **Produto**, com os atributos: id, nome e preco, pacote **com.cursomc.domain**.
2. Gere o **Serializable** e sua váriavel e insira a anotação  **@Entity** na classe.
3. Gere os **Getters and Seters** e o **hashcode()** e **equals()** somente por id.
4. Crie a interface **ProdutoRepository** e extenda de **JpaRepository<Produto, Integer>** como pacote: **com.cursomc.repositories**.
5. Na classe de dominio **Categoria** crie uma lista do tipo **Produto**, insira a anotação **@ManyToMany(mappedBy="categorias")**.
6. Na classe de dominio **Produto** crie uma lista do tipo **Categoria** e insira a anotação **@ManyToMany(name="PRODUTO_CATEGORIA", joinColumns = @JoinColumn(name = "produto_id"), inverseJoinColumns = @JoinColumn(name = "categoria_id"))** e insira seus **Getters and Seters**.
7. Pro fim, na classe principal da aplicação, crie uma variável do tipo **ProdutoRepository** e insira a anotação **@Auowired**.
8. Crie 3 objetos do tipo **Produto** passando null no id.
9. Defina os produtos de cada categoria.
10. Defina as categorias de cada produto.
11. Efetue um **saveAll(Arrays.asList(p1,p2,p3))** no **ProdutoRepository**.
