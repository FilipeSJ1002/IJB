package IJB.model.entity;

import jakarta.persistence.*;

@Entity // Enditdade de banco de dados
public class ApoiadorEntity {
    @Id
    @Column(name="idApoiador")
    private int idApoiador;
    
    @Column(name="quantoInvesteMes")
    private Double quantoInvesteMes;

    @Column(name="qnttMaterial")
    private int qnttMaterial;

    @Column(name="material")
    private String material;
}
