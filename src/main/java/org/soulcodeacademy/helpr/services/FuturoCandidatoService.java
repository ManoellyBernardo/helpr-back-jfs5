package org.soulcodeacademy.helpr.services;

import org.soulcodeacademy.helpr.domain.FuturoCandidato;
import org.soulcodeacademy.helpr.domain.dto.FuturoCandidatoDTO;
import org.soulcodeacademy.helpr.domain.enums.Setor;
import org.soulcodeacademy.helpr.repositories.FuturoCandidatoRepository;
import org.soulcodeacademy.helpr.services.errors.RecursoNaoEncontradoError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuturoCandidatoService {

    @Autowired
    private FuturoCandidatoRepository futuroCandidatoRepository;

    /**
     * Buscar todos os Futuros Candidatos
     * @return List<FuturoCandidato>
     */
    public List<FuturoCandidato> listar() {
        return this.futuroCandidatoRepository.findAll();
    }

    /**
     * Pesquisa de FuturoCandidato por id
     * @param idFuturoCandidato
     * @return FuturoCandidato
     */
    public FuturoCandidato getFunturoCandidato(Integer idFuturoCandidato) {
        return this.futuroCandidatoRepository.findById(idFuturoCandidato).
                orElseThrow(() ->
                        new RecursoNaoEncontradoError("Não existe um Futuro candidato com o id: " + idFuturoCandidato +
                        " no banco de dados"));
    }

    /**
     *
     * @param email
     * @return FuturoCandidato
     */
    public FuturoCandidato getFunturoCandidatoPorEmail(String email) {
        return this.futuroCandidatoRepository.findByEmail(email).
                orElseThrow(() ->
                        new RecursoNaoEncontradoError("Não existe um Futuro candidato com o e-mail: " + email +
                        " no banco de dados"));
    }

    /**
     * Pesquisa de Futuros Candidatos por nome
     * @param nome
     * @return List<FuturoCandidato>
     */
    public List<FuturoCandidato> buscarCandidatosPorNome(String nome) {
        return futuroCandidatoRepository.findByNomeContaining(nome);
    }

    /**
     * Pesquisa de FuturoCandidato por setor
     * @param setor
     * @return List<FuturoCandidato>
     */
    public List<FuturoCandidato> buscarCandidatosPorSetor(Setor setor) {
        return futuroCandidatoRepository.findBySetor(setor);
    }


    /**
     * Salva um novo FuturoCandidato
     * @param dto
     * @return novoFuturoCandidato
     */
    public FuturoCandidato salvar(FuturoCandidatoDTO dto) {
        FuturoCandidato novoFuturoCandidato = new FuturoCandidato(null, dto.getNome(), dto.getEmail(), dto.getDescricao(), dto.getSetor());
        return this.futuroCandidatoRepository.save(novoFuturoCandidato);
    }


    /**
     * Deletar um FururoCandidato
     * @param idFuturoCandidato
     */
    public void deletar(Integer idFuturoCandidato) {
        FuturoCandidato futuroCandidato = this.getFunturoCandidato(idFuturoCandidato);
        this.futuroCandidatoRepository.delete(futuroCandidato);
    }
}
