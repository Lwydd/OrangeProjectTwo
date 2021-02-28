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

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public String getVacina() {
        return vacina;
    }

    public void setVacina(String vacina) {
        this.vacina = vacina;
    }

    public Date getDtAdministracao() {
        return dtAdministracao;
    }

    public void setDtAdministracao(Date dtAdministracao) {
        this.dtAdministracao = dtAdministracao;
    }
}
