package IJB.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import IJB.Enum.TipoPessoaEnum;
import IJB.model.dto.PessoaDTO;
import IJB.model.dto.VoluntarioDTO;
import IJB.model.entity.PessoaEntity;
import IJB.model.entity.VoluntarioEntity;
import IJB.model.repository.PessoaRepository;
import IJB.model.repository.VoluntarioRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PessoaService {
    @Autowired
    PessoaRepository injecaoPessoa;
    @Autowired
    VoluntarioRepository injecaoVoluntario;

    public PessoaDTO insere(PessoaDTO pessoaDTO){
        PessoaEntity pessoaEntity = injecaoPessoa.save(converteDtoParaEntity(pessoaDTO));

        // 1 - Criar metodo para conversao de PessoaDTO para VoluntarioEntity
        //     VoluntarioEntity voluntarioEntity = injecaoVoluntario.save(??);
        // 2 - Retornar PessoaDTO com as informacoes do VoluntarioEntity
        // 3 - Criar IF para TipoPessoaEnum para saber se a pessoa é um Voluntario ou Apoiador

        // Verifica se a pessoa é um voluntário
        if (pessoaDTO.getTipoPessoa() == TipoPessoaEnum.VOLUNTARIO) {
            // Converte o PessoaDTO para VoluntarioEntity
            VoluntarioEntity voluntarioEntity = convertePessoaDtoParaVoluntarioEntity(pessoaDTO);

            // Salva o VoluntarioEntity no banco de dados
            voluntarioEntity = injecaoVoluntario.save(voluntarioEntity);

            // Converte o VoluntarioEntity salvo para VoluntarioDTO
            VoluntarioDTO voluntarioDTO = converteVoluntarioEntityParaVoluntarioDto(voluntarioEntity);

            // Adiciona as informações do VoluntarioDTO ao PessoaDTO
            pessoaDTO.setVoluntarioDTO(voluntarioDTO);

            VoluntarioEntity Vol = new VoluntarioEntity("Administrador", "Terça das 8 as 10");

            return pessoaDTO;
        } else {


           // PessoaDTO.setCargoDesejado == Administrador();

            return converteEntityParaDto(pessoaEntity);
        }
    }



    public List<PessoaDTO> consultaTodos(){
        return converteEntities(injecaoPessoa.findAll());
    }

    public PessoaDTO consultaPorId(Long id){
        // Retorna um valor opcional, pois pode encontrar ou não
        Optional<PessoaEntity> optional = injecaoPessoa.findById(id);
        if (optional.isPresent()){
            return converteEntityParaDto(optional.get()); // Converte Entity em DTO
        }
        else return null; // Não encontrou
    }

    public String remove(Long id){
        if (injecaoPessoa.existsById(id)){
            injecaoPessoa.deleteById(id);
            return "Cadastro removido com sucesso";
        }
        else {
            return "Cadastro não encontrado";
        }
    }
    public String removeAll(){
            injecaoPessoa.deleteAll();
            return "Todos os cadastro foram removidos com sucesso";
    }

    public List<PessoaDTO> converteEntities(List<PessoaEntity> cadastrosEntities){
        List<PessoaDTO> cadastrosDTOs = new ArrayList<PessoaDTO>();
        for(PessoaEntity pessoaEntity : cadastrosEntities){
            cadastrosDTOs.add(converteEntityParaDto(pessoaEntity));
        }
        return cadastrosDTOs;
    }

    public PessoaEntity converteDtoParaEntity(PessoaDTO pessoaDTO){
        return new PessoaEntity(pessoaDTO.getCpf(), pessoaDTO.getNome(), pessoaDTO.getTelefone(),
                pessoaDTO.getEmail(), pessoaDTO.getSobreVoce(), pessoaDTO.getEmpregoAtual(),
                pessoaDTO.getHobby(), pessoaDTO.getIntencao());
    }

    public PessoaDTO converteEntityParaDto(PessoaEntity pessoaEntity){
        return new PessoaDTO(pessoaEntity.getCpf(), pessoaEntity.getNome(), pessoaEntity.getTelefone(),
                pessoaEntity.getEmail(), pessoaEntity.getEmpregoAtual(),
                pessoaEntity.getHobby(), pessoaEntity.getIntencao());
    }

    public PessoaEntity converteTipoDTO(PessoaDTO pessoaDTO){
        return new PessoaEntity(pessoaDTO.getTipoPessoa());
    }

    public PessoaDTO converteTipoEntity(PessoaEntity pessoaEntity){
        return new PessoaDTO(pessoaEntity.getTipoPessoa());
    }

    public VoluntarioEntity convertePessoaDtoParaVoluntarioEntity(PessoaDTO pessoaDTO) {
        VoluntarioEntity voluntarioEntity = new VoluntarioEntity();
        if (pessoaDTO.getVoluntarioDTO() != null) {
            voluntarioEntity.setCargoDesejado(pessoaDTO.getVoluntarioDTO().getCargoDesejado());
            voluntarioEntity.setDataDisponivel(pessoaDTO.getVoluntarioDTO().getDataDisponivel());
        }
        // Aqui você deve lidar com a conversão de PessoaDTO para PessoaEntity, se necessário
        // Exemplo:
        // PessoaEntity pessoaEntity = converteDTO(pessoaDTO);
        voluntarioEntity.setPessoa(converteDtoParaEntity(pessoaDTO));
        return voluntarioEntity;
    }
//
    public VoluntarioDTO converteVoluntarioEntityParaVoluntarioDto(VoluntarioEntity voluntarioEntity) {
        VoluntarioDTO voluntarioDTO = new VoluntarioDTO();
        voluntarioDTO.setCargoDesejado(voluntarioEntity.getCargoDesejado());
        voluntarioDTO.setDataDisponivel(voluntarioEntity.getDataDisponivel());
        // Aqui você deve lidar com a conversão de PessoaEntity para PessoaDTO, se necessário
        // Exemplo:
        // PessoaDTO pessoaDTO = converteEntity(pessoaEntity);
        // voluntarioDTO.setPessoa(pessoaDTO);
        return voluntarioDTO;
    }



}
