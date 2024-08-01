package unifacef.edu.IJB.model.entity;


import jakarta.persistence.*;

@Entity
@Table(name="voluntario")
public class VoluntarioEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "cargoDesejado")
    private String cargoDesejado;
    @Column(name = "dataDisponivel")
    private String dataDisponivel;

    public PessoaEntity getPessoa() {
        return pessoa;
    }

   //Getters and Setters -> cargoDesejado e dataDisponivel ...
   public String getCargoDesejado() {
        return cargoDesejado;
    }

    public void setCargoDesejado(String cargoDesejado) {
        this.cargoDesejado = cargoDesejado;
    }

    public String getDataDisponivel() {
        return dataDisponivel;
    }

    public void setDataDisponivel(String dataDisponivel) {
        this.dataDisponivel = dataDisponivel;
    }


    public void setPessoa(PessoaEntity pessoa) {
        this.pessoa = pessoa;
    }

    // Relacionamentos entre as tabelas
    @OneToOne
    @JoinColumn(name = "pessoa_id")
    private PessoaEntity pessoa;

    public VoluntarioEntity() {}

    public VoluntarioEntity(String cargoDesejado, String dataDisponivel, PessoaEntity pessoa) {
        this.cargoDesejado = cargoDesejado;
        this.dataDisponivel = dataDisponivel;
        this.pessoa = pessoa;
    }
}
