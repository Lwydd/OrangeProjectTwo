#Orange Talents

##Caso para implementação

1.	API Rest para cadastro de dados pessoais e administração de vacina;
2.	Campos obrigatórios para cadastro de pessoas são: Nome, CPF, Email e data de nascimento;
3.	Campos obrigatórios para cadastro da vacinação são: Vacina, Email do paciente e data da administração do medicamento;
4.	Caso os dados fornecidos forem validades, apresentar status 201 (200 para atualização se solicitado) e registrar no banco de dados.
5.	Caso os dados fornecidos não sejam validos, retornar ao solicitante status 400.

## Decisões

* Vou utilizar o padrão MVC(Model-View-Controller), muito utilizado na comunidade além de atender bem ao projeto;
* Acatando ao desafio desta avaliação, não utilizarei a tecnológica do LOMBOK;
* Para as validações utilizarei as dependências do Java.

### Benefícios

* Projeto apresentará um código uniforme com padrões utilizados para fácil compreensão da comunidade.

### Malefícios

* Não fui capaz de identificar qualquer ponto negativo para essa API.

## Procedimentos

* Definição do nome, nome foi baseado no processo de avaliação para o recrutamento da Orange Talents
* Utilizei nesse projeto o gerenciador "**maven**" a linguagem "**java**" a versão do spring "**2.4.3**" o packaging utilizado é o "**jar**" e a versão do java utilizado é a "**8**".

###Para as dependências

* **Spring Web**: Essa dependência já vem pré configurada com um servidor web, funcionalidades como tomcat e routers;
* **Data-jpa**: Essa dependência cuida de toda parte de persistência de dados, ORM entre outros;
* **Starter-test**: Funcionará para os testes de Controller do Spring;
* **Starter-web**: Ajuda facilitando a as definições da aplicação.

### Arquitetura do Projeto

De início vou trabalhar com 4 pacotes, são eles:

* **repository**: Nele vai conter a "Interface" com os métodos e comportamentos
* **service**:Nele vai conter todas as regras de inserção de dados, busca, atualização e exclusão.
* **domain**: Nele vai conter as classes primarias.
* **controller**: Nele que vou definir as rotas e como cada uma deve operar.

### Propriedades da Aplicação

Utilizei conexões e propriedades simples para teste do código.

* **spring.datasource.url=jdbc:postgresql://localhost:5432/orange?autoReconnect=true**: Meu caminho para o banco de dados
* **spring.datasource.username=**: Usuário do banco
* **spring.datasource.password=**: Senha do usuário do banco
* **spring.jpa.hibernate.ddl-auto=update**: Comando para atualizar a API preservando o conteudo das tabelas.
* **spring.jpa.show-sql=true**: Esse parâmetro é opcional, como ele está definido como true, o spring irá mostrar as queries do SQL no nosso terminal.

## Classes

### Pessoa

Cadastro dos dados pessoais estão no pacote "domain", como não utilizei a dependência "LOMBOK", a criação manual do getting e setting foram implementadas.

```
package orange.two.projeto2.domain;
import javax.persistence.*;
import java.sql.Date;

@Entity
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @Column(nullable = false)
    private String nome;
    @Column(unique = true, nullable = false)
    private String email;
    @Column(unique = true, nullable = false, length = 11)
    private String cpf;
    @Column(nullable = false)
    private Date dtNascimento;

    public Long getId() { return Id; }

    public void setId(Long id) { Id = id; }

    public String getNome() { return nome; }

    public void setNome(String nome) { this.nome = nome; }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    public String getCpf() { return cpf;  }

    public void setCpf(String cpf) { this.cpf = cpf; }

    public Date getDtNascimento() { return dtNascimento; }

    public void setDtNascimento(Date dtNascimento) { this.dtNascimento = dtNascimento; }
}
```

* **@Entity**: Anotação da JPA, ela informa que a classe é também uma entidade do banco de dados relacional (Tabela do banco de dados), e que cada nova instância será um registro dessa tabela.

Aqui na classe Pessoa os atributos serão:

* **id**: Atribui a Anotação @Id(Informando que essa será a chave primária da nossa tabela), @GeneratedValue(Informa o tipo de geração de incremento que será utilizado, no caso utilizei a geração tipo Identity, aonde o banco de dados trata de gerar o Id sequencialmente) definido também como tipo Long, pois a tabela vai caber muitos registros;
* **nome**: Atribui a Anotação @Column(Utilizando essa anotação defini os parâmetros da coluna, nesse caso defini que não pode ser nula) e definido ela como tipo String(Texto);
* **email**: Atribui a Anotação @Column(Utilizando essa anotação defini os parâmetros da coluna, nesse caso definimos que não pode ser nula, também a coluna é unique, ou seja, não permite valores repetidos) e defini ela como tipo String(Texto);
* **cpf**: Atribui a Anotação @Column(Utilizando essa anotação defini os parâmetros da coluna, que o tamanho deve ser de 11 caracteres, também a coluna é unique, ou seja, não permite valores repetidos) e defini ela como tipo String(Texto);
* **dtNascimento**: Atribui a Anotação @Column(Utilizando essa anotação defini os parâmetros da coluna, nesse caso defini que não pode ser nula) e defini ela como tipo Date(Data).

### Vacinacao

Também se encontra no pacote "domain", assim como a anterior, houve necessidade de criar getting e setting.

```
package orange.two.projeto2.domain;
import javax.persistence.*;
import java.sql.Date;

@Entity
public class Vacinacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @Column(nullable = false)
    private String vacina;
    @Column(nullable = false)
    private String emailPac;
    @Column(nullable = false)
    private Date dtAdministracao;
    @ManyToOne
    private Pessoa pessoa;

    public Long getId() { return Id; }

    public void setId(Long id) { Id = id; }

    public String getEmailPac() { return emailPac; }

    public void setEmailPac(String emailPac) { this.emailPac = emailPac; }

    public Pessoa getPessoa() { return pessoa; }

    public void setPessoa(Pessoa pessoa) { this.pessoa = pessoa; }

    public String getVacina() { return vacina;  }

    public void setVacina(String vacina) { this.vacina = vacina; }

    public Date getDtAdministracao() { return dtAdministracao; }

    public void setDtAdministracao(Date dtAdministracao) { this.dtAdministracao = dtAdministracao; }
}
```

* **@Entity**: exatamente mesma função da classe anterior;
* **@ManyToOne**: para eventual conexão com a tabela pessoa. do tipo n:1.

Aqui na classe Pessoa os atributos serão:

* **id**: Atribui a Anotação @Id(Informando que essa será a chave primária da nossa tabela), @GeneratedValue(Informa o tipo de geração de incremento que será utilizado, no caso utilizei a geração tipo Identity, aonde o banco de dados trata de gerar o Id sequencialmente) definido também como tipo Long, pois a tabela vai caber muitos registros.
* **vacina**: Atribui a Anotação @Column(Utilizando essa anotação defini os parâmetros da coluna, nesse caso defini que não pode ser nula) e definido ela como tipo String(Texto).
* **emailPac**: Atribui a Anotação @Column(Utilizando essa anotação defini os parâmetros da coluna, nesse caso definimos que não pode ser nula, também a coluna é unique, ou seja, não permite valores repetidos) e defini ela como tipo String(Texto).
* **dtAdministracao**: Atribui a Anotação @Column(Utilizando essa anotação defini os parâmetros da coluna, nesse caso defini que não pode ser nula) e defini ela como tipo Date(Data);
* **pessoa**: Atribui a Anotação @ManyToONe para o relacionamento com a tabela pessoa, na tabela vacinacao irá criar a coluna pessoa_id. Não foi implementado, mas o campo já está pronto para isso.

### PessoaRepository e VacinacaoRepository

Essa será a interface de comunicação direta ao banco, a função dela é prover os métodos e funcionalidades para o serviço.

```
@Repository
public interface PessoaRepository extends PagingAndSortingRepository <Pessoa,Long> { }
```

```
@Repository
public interface VacinacaoRepository extends PagingAndSortingRepository <Vacinacao,Long> { }
```

* Como mostrado acima, ela são bem simples, a interface PessoaRepository e VacinacaoRepository, herdam as funcionalidades do PagingAndSortingRepository, dessa maneira já temos todas as funcionalidades básicas de CRUD(Criar, Ler, Atualizar e Deletar ) para aplicação.

### PessoaService e VacinacaoService

Esses pacotes estão responsáveis por cadastrar, excluir, consultar e atualizar os nossos dados.

```
@Service
public class VacinacaoService {
    @Autowired
    private VacinacaoRepository vacinacaoRepository;

    public Iterable<Vacinacao> listar() {
        return vacinacaoRepository.findAll();
    }

    public void deletar(Long id) {
        Optional<Vacinacao> VacinacaoOpt = vacinacaoRepository.findById(id);
        if (VacinacaoOpt.isPresent()) {
            vacinacaoRepository.delete(VacinacaoOpt.get());
        }
    }

    public void criar(Vacinacao vacinacao) {
        vacinacaoRepository.save(vacinacao);
    }

    public void att(Vacinacao vacinacao) throws Exception {
        if (vacinacao.getId() == null){
            throw new Exception("");
        }
        Optional<Vacinacao> vacinacaoOpt = vacinacaoRepository.findById(vacinacao.getId());
        if (vacinacaoOpt.isPresent()) {
            vacinacaoRepository.save(vacinacao);
        } else {
            throw new Exception("");
        }
    }
}
```

```
@Service
public class PessoaService {
    @Autowired
    private PessoaRepository pessoaRepository;

    public Iterable<Pessoa> listar() {
        return pessoaRepository.findAll();
    }

    public void deletar(Long id) {
        Optional<Pessoa> pessoaOpt = pessoaRepository.findById(id);
        if (pessoaOpt.isPresent()) {
            pessoaRepository.delete(pessoaOpt.get());
        }
    }

    public void criar(Pessoa pessoa) {
        pessoaRepository.save(pessoa);
    }

    public void att(Pessoa pessoa) throws Exception {
        if (pessoa.getId() == null){
            throw new Exception("");
        }
            Optional<Pessoa> pessoaOpt = pessoaRepository.findById(pessoa.getId());
            if (pessoaOpt.isPresent()) {
                pessoaRepository.save(pessoa);
            } else {
            throw new Exception("");
        }
    }
}
```

* **@Service**: Marca a classe com essa anotação para o Spring saber que dentro dela irá conter a lógica de negócio.
* **@AutoWired**: Marcar isso no construtor para ele se tornar um ponto de injeção de dependência aonde "PessoaService" e "VacinacaoService" Necessite que os respectivos repository estejam instanciadas.

Aqui já podemos discutir sobre as regras de negócio da API.

* **listar**: Método a ser utilizado para trazer todos os dados das tabelas através da função "findAll" do repository;
* **delete**: Para esse método era necessário apagar um só argumento da tabela por isso sera utilizado o envelopamento do tipo "Optional" levado a uma condição de existência em "if" para validar o dados e leva-lo ao repository;
* **criar**: Esse método e auxiliado pela função "save" do repository para criar um novo argumento na tabela do banco de dados através dos dados fornecidos;
* **att**: Esse função precisou um pouco mais de analise através das condições "if", validando se o "id" fornecido e existente e valido, caso não exista parâmetro o método e encerrado no "throw", caso o parâmetro não exista no banco, também encerra o método e finalmente parâmetro valido, e executado com sucesso.

### PessoaController e VacinacaoController

Os pacotes "PessoaController" e "VacinacaoController" iram receber os parâmetros do usuário e encaminhar para o pacote "service", esses são os pontos de partida do usuário.

```
@RestController
@RequestMapping("pessoa")
public class PessoaController {
    @Autowired
    private PessoaService pessoaService;

    @GetMapping
    public ResponseEntity<Iterable<Pessoa>> listar() {
        return ResponseEntity.ok().body(pessoaService.listar());
    }

    @PutMapping
    public ResponseEntity att(@RequestBody Pessoa pessoa){
        try {
            pessoaService.criar(pessoa);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity deletar(@PathVariable("id") Long id) {
        pessoaService.deletar(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping
    public ResponseEntity criar(@RequestBody Pessoa pessoa) {
        try {
            pessoaService.criar(pessoa);
            return ResponseEntity.created(new URI("")).build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
```

```

@RestController
@RequestMapping("vacinacao")
public class VacinacaoController {
    @Autowired
    private VacinacaoService vacinacaoService;

    @GetMapping
    public ResponseEntity<Iterable<Vacinacao>> listar() {
        return ResponseEntity.ok().body(vacinacaoService.listar());
    }

    @PutMapping
    public ResponseEntity att (@RequestBody Vacinacao vacinacao){
        try {
            vacinacaoService.criar(vacinacao);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity deletar(@PathVariable("id") Long id) {
        vacinacaoService.deletar(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping
    public ResponseEntity criar(@RequestBody Vacinacao vacinacao) {
        try {
            vacinacaoService.criar(vacinacao);
            return ResponseEntity.created(new URI("")).build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
```

* **@RestController**: É uma anotação do framework Spring, ela marca que a classe é um controller, tipo "REST", com isso já implementa outros componentes como @ResponseBody e @RequestMapping, que utilizei;
* **@AutoWired**: Marcado isso no construtor para ele se tornar um ponto de injeção de dependência, também é uma anotação do Spring, nesse caso dizemos que a nossa classe "PessoaController" precisa de "PessoaService" instanciada. Também e valido paras a "Class Vacinacao".
