package unifacef.edu.IJB.model.entity;

import jakarta.persistence.*;

@Entity // Enditdade de banco de dados
@Table(name="Endereco") // tablea filme do banco de dados
public class EnderecoEntity {

    @Id
    @Column(name="idEndereco")
    private int idEndereco;
    @Column(name="cep")
    private String cep;
    @Column(name="bairro")
    private String bairro;
    @Column(name="rua")
    private String rua;
    @Column(name="numero")
    private int numero;
    @Column(name="inform")
    private String inform;

}
