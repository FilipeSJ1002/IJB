package IJB.Enum;

public enum TipoPessoaEnum {
    VOLUNTARIO(1),
    APOIADOR(2),
    COLABORADOR(3);

    private final int valor;

    TipoPessoaEnum(int valor) {
        this.valor = valor;
    }

    public int getValor() {
        return valor;
    }
}
