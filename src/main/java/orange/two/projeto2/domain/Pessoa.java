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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) { this.email = email; }

    public String getCpf() { return cpf;  }

    public void setCpf(String cpf) { this.cpf = cpf; }

    public Date getDtNascimento() { return dtNascimento; }

    public void setDtNascimento(Date dtNascimento) { this.dtNascimento = dtNascimento; }
}
