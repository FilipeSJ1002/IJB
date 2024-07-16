package IJB.model.entity;

import jakarta.persistence.*;

@Entity // Enditdade de banco de dados
@Table(name="ContatoAdicional") // tablea filme do banco de dados
public class ContatoAdicionalEntity {

    @Id
    @Column(name="idCnttAdd")
    private int idCnttAdd;
    @Column(name="nomeCntt")
    private String nomeCntt;
    @Column(name="telefoneCntt")
    private String telefoneCntt;
    @Column(name="emailCntt")
    private String emailCntt;

}
