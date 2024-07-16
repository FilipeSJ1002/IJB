package unifacef.edu.IJB.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unifacef.edu.IJB.Enum.TipoPessoaEnum;
import unifacef.edu.IJB.model.dto.PessoaDTO;
import unifacef.edu.IJB.model.dto.VoluntarioDTO;
import unifacef.edu.IJB.model.entity.PessoaEntity;
import unifacef.edu.IJB.model.entity.VoluntarioEntity;
import unifacef.edu.IJB.model.repository.PessoaRepository;
import unifacef.edu.IJB.model.repository.VoluntarioRepository;

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
        PessoaEntity pessoaEntity = injecaoPessoa.save(converteDTO(pessoaDTO));

        // 1 - Criar metodo para conversao de PessoaDTO para VoluntarioEntity
        //     VoluntarioEntity voluntarioEntity = injecaoVoluntario.save(??);
        // 2 - Retornar PessoaDTO com as informacoes do VoluntarioEntity
        // 3 - Criar IF para TipoPessoaEnum para saber se a pessoa é um Voluntario ou Apoiador
        if (pessoaDTO.getTipoPessoa() == TipoPessoaEnum.VOLUNTARIO) {
            VoluntarioEntity voluntarioEntity = injecaoVoluntario.save(converteVoluntarioDTO(pessoaDTO));
            // Adiciona as informações do VoluntarioEntity ao PessoaDTO
            pessoaDTO.setVoluntarioDTO(converteVoluntarioEntity(voluntarioEntity.getPessoa()));
        }

        return converteEntity(pessoaEntity);
    }

    public List<PessoaDTO> consultaTodos(){
        return converteEntities(injecaoPessoa.findAll());
    }

    public PessoaDTO consultaPorId(Long id){
        // Retorna um valor opcional, pois pode encontrar ou não
        Optional<PessoaEntity> optional = injecaoPessoa.findById(id);
        if (optional.isPresent()){
            return converteEntity(optional.get()); // Converte Entity em DTO
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

    public List<PessoaDTO> converteEntities(List<PessoaEntity> cadastrosEntities){
        List<PessoaDTO> cadastrosDTOs = new ArrayList<PessoaDTO>();
        for(PessoaEntity pessoaEntity : cadastrosEntities){
            cadastrosDTOs.add(converteEntity(pessoaEntity));
        }
        return cadastrosDTOs;
    }

    public PessoaEntity converteDTO(PessoaDTO pessoaDTO){
        return new PessoaEntity(pessoaDTO.getCpf(), pessoaDTO.getNome(), pessoaDTO.getTelefone(),
                pessoaDTO.getEmail(), pessoaDTO.getSobreVoce(), pessoaDTO.getEmpregoAtual(),
                pessoaDTO.getHobby(), pessoaDTO.getIntencao());
    }

    public PessoaDTO converteEntity(PessoaEntity pessoaEntity){
        return new PessoaDTO(pessoaEntity.getCpf(), pessoaEntity.getNome(), pessoaEntity.getTelefone(),
                pessoaEntity.getEmail(), pessoaEntity.getEmpregoAtual(),
                pessoaEntity.getHobby(), pessoaEntity.getIntencao());
    }

    public PessoaEntity converteTipoDTO(PessoaDTO pessoaDTO){
        return new PessoaEntity(pessoaDTO.getTipoPessoa());
    }

    public PessoaDTO convertetipoEntity(PessoaEntity pessoaEntity){
        return new PessoaDTO(pessoaEntity.getTipoPessoa());
    }

    public VoluntarioEntity converteVoluntarioDTO(PessoaDTO pessoaDTO) {
        VoluntarioEntity voluntarioEntity = new VoluntarioEntity();
        voluntarioEntity.setCargoDesejado(pessoaDTO.getVoluntarioDTO().getCargoDesejado());
        voluntarioEntity.setDataDisponivel(pessoaDTO.getVoluntarioDTO().getDataDisponivel());
        // Aqui você deve lidar com a conversão de PessoaDTO para PessoaEntity, se necessário
        // Exemplo:
        // PessoaEntity pessoaEntity = converteDTO(pessoaDTO);
        // voluntarioEntity.setPessoa(pessoaEntity);
        return voluntarioEntity;
    }

    public VoluntarioDTO converteVoluntarioEntity(PessoaEntity pessoaEntity) {
        VoluntarioDTO voluntarioDTO = new VoluntarioDTO();
        voluntarioDTO.setCargoDesejado(pessoaEntity.getVoluntarioEntity().getCargoDesejado());
        voluntarioDTO.setDataDisponivel(pessoaEntity.getVoluntarioEntity().getDataDisponivel());
        // Aqui você deve lidar com a conversão de PessoaEntity para PessoaDTO, se necessário
        // Exemplo:
        // PessoaDTO pessoaDTO = converteEntity(pessoaEntity);
        // voluntarioDTO.setPessoa(pessoaDTO);
        return voluntarioDTO;
    }


}
