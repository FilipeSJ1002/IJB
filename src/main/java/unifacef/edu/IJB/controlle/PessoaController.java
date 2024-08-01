package unifacef.edu.IJB.controlle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import unifacef.edu.IJB.model.dto.PessoaDTO;
import unifacef.edu.IJB.service.PessoaService;

import java.util.List;

@RestController
@RequestMapping("/cadastro")
public class PessoaController {
    @Autowired
    PessoaService injecao;

    @PostMapping
    public PessoaDTO inserir(@RequestBody PessoaDTO pessoaDTO){
        return injecao.insere(pessoaDTO);
    }

    @GetMapping
    public List<PessoaDTO> consultaTodos(){
        return injecao.consultaTodos();
    }

    @GetMapping("/{id}")
    public PessoaDTO consultaPorId(@PathVariable Long id){
        return injecao.consultaPorId(id);
    }

    @DeleteMapping("/{id}")
    public String remove(@PathVariable Long id){
        return injecao.remove(id);
    }

}
