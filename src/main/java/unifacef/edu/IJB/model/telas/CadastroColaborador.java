package unifacef.edu.IJB.model.telas;

public interface CadastroColaborador extends TipoCadastro{
    private void cpf(){}
    private void nome(){}
    private void telefone(){}
    private void email(){}
    private void sobreVoce(){}
    private void empregoAtual(){}
    private void hobby(){}
    private void intencao(){}

    private void cargoDesejado(){}
    private void dataDisponivel() {}
    private void quantoInvesteMes(){}
    private void qnttMaterial(){}
    private void material(){}


    default void xCpf(){ cpf(); }
    default void xNome(){ nome(); }
    default void xTelefone(){ telefone(); }
    default void xEmail(){ email(); }
    default void xSobreVoce(){ sobreVoce(); }
    default void xEmpregoAtual(){ empregoAtual(); }
    default void xHobby(){ hobby(); }
    default void xIntecao(){ intencao(); }

    default void xCargoDesejado(){ cargoDesejado(); }
    default void xDataDisponivel(){ dataDisponivel(); }
    default void xQuantoInvesteMes(){ quantoInvesteMes(); }
    default void xQnttMaterial(){ qnttMaterial(); }
    default void xMaterial(){ material(); }
}
