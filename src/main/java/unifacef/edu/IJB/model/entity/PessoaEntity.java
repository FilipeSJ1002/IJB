package unifacef.edu.IJB.model.entity;


import jakarta.persistence.*;
import unifacef.edu.IJB.Enum.TipoPessoaEnum;

@Entity
@Table(name="pessoa")
public class PessoaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="cpf")
    private String cpf;
    @Column(name="nome")
    private String nome;
    @Column(name="telefone")
    private String telefone;
    @Column(name="email")
    private String email;
    @Column(name="tipoPessoa")
    private TipoPessoaEnum tipoPessoa;
    @Column(name="sobreVoce")
    private String sobreVoce;
    @Column(name="empregoAtual")
    private String empregoAtual;
    @Column(name="hobby")
    private String hobby;
    @Column(name="intencao")
    private String intencao;


    public PessoaEntity() {
    }
    public PessoaEntity(int tipoPessoa) {}
    public PessoaEntity(TipoPessoaEnum tipoPessoa){
        this.tipoPessoa = tipoPessoa;
    }

    public PessoaEntity(String cpf, String nome, String telefone, String email,
                        String sobreVoce, String empregoAtual, String hobby, String intencao) {
        this.cpf = cpf;
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.sobreVoce = sobreVoce;
        this.empregoAtual = empregoAtual; // VAI VIRAR CARGO DESEJADO // será removido da classe de Voluntario
        this.hobby = hobby;
        this.intencao = intencao;
    }

    public Long getId(){return id;}

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public TipoPessoaEnum getTipoPessoa() {
        return tipoPessoa;
    }

    public void setTipoPessoa(TipoPessoaEnum tipoVoluntario) {
        this.tipoPessoa = tipoVoluntario;
    }

    public String getSobreVoce() {
        return sobreVoce;
    }

    public void setSobreVoce(String sobreVoce) {
        this.sobreVoce = sobreVoce;
    }

    public String getEmpregoAtual() {
        return empregoAtual;
    }

    public void setEmpregoAtual(String empregoAtual) {
        this.empregoAtual = empregoAtual;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public String getIntencao() {
        return intencao;
    }

    public void setIntencao(String intencao) {
        this.intencao = intencao;
    }

}
