package unifacef.edu.IJB.model.dto;

import unifacef.edu.IJB.Enum.TipoPessoaEnum;
import unifacef.edu.IJB.model.entity.VoluntarioEntity;

public class PessoaDTO {
    private Long id;
    private String cpf;
    private String nome;
    private String telefone;
    private String email;
    private String sobreVoce;
    private String empregoAtual;
    private String hobby;
    private String intencao ;
    private TipoPessoaEnum tipoPessoa;
    private VoluntarioDTO voluntarioDTO;

    public PessoaDTO() {
    }

    public PessoaDTO(String cpf, String nome, String telefone, String email, String empregoAtual, String hobby, String intencao) {
    }
    public PessoaDTO(TipoPessoaEnum tipoPessoa){this.tipoPessoa = tipoPessoa;}
    public PessoaDTO(
            String cpf,
            String nome,
            String telefone,
            String email,
            String sobreVoce,
            String empregoAtual,
            String hobby,
            String intencao) {
        this.cpf = cpf;
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.sobreVoce = sobreVoce;
        this.empregoAtual = empregoAtual;
        this.hobby = hobby;
        this.intencao = intencao;
    }


    public Long getId(){
        return id;
    }

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

    public void setTipoPessoa(TipoPessoaEnum tipoPessoa) {
        this.tipoPessoa = tipoPessoa;
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

    public VoluntarioDTO getVoluntarioDTO() {
        return voluntarioDTO;
    }

    public void setVoluntarioDTO(VoluntarioDTO voluntarioDTO) {
        this.voluntarioDTO = voluntarioDTO;
    }

    private VoluntarioEntity voluntarioEntity;
    public VoluntarioEntity getVoluntarioEntity(){return voluntarioEntity;}
    public void setVoluntarioEntity(VoluntarioEntity voluntarioEntity){this.voluntarioEntity = voluntarioEntity;}

}
