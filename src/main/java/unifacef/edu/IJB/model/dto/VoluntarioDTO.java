package unifacef.edu.IJB.model.dto;

public class VoluntarioDTO {
    private String cargoDesejado;
    private String dataDisponivel;

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

    public VoluntarioDTO() {
    }

    public VoluntarioDTO(String cargoDesejado, String dataDisponivel) {
        this.cargoDesejado = cargoDesejado;
        this.dataDisponivel = dataDisponivel;
    }

    private PessoaDTO pessoa;
    public VoluntarioDTO(String cargoDesejado, String dataDisponivel, PessoaDTO pessoa) {
        this.cargoDesejado = cargoDesejado;
        this.dataDisponivel = dataDisponivel;
        this.pessoa = pessoa;
    }
}
