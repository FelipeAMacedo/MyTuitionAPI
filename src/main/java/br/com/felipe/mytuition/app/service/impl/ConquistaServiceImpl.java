package br.com.felipe.mytuition.app.service.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.felipe.mytuition.app.entity.Conquista;
import br.com.felipe.mytuition.app.repository.ConquistaRepository;
import br.com.felipe.mytuition.app.service.ConquistaService;

@Service
@Transactional
public class ConquistaServiceImpl implements ConquistaService {
	private static Logger LOGGER = LoggerFactory.getLogger(ConquistaServiceImpl.class);

	@Autowired
	private ConquistaRepository repository;

	@Override
	public Conquista insert(Conquista conquista) throws Exception {
		try {
			LOGGER.info("Vai inserir uma nova conquista");
			return repository.save(conquista);
		} catch (Exception e) {
			throw new Exception("Não foi possível cadastrar a conquista", e);
		}
	}

	@Override
	public List<Conquista> buscarNovasAtualizacoes(List<Conquista> conquistas, String email) throws Exception {
		try {
			LOGGER.info("Vai buscar atualizações e novas conquistas");
			if (!conquistas.isEmpty()) {

				List<Long> listaId = new ArrayList<>();
				List<LocalDateTime> listaData = new ArrayList<>();
				
				List<Conquista> conquistasAtualizadas = new ArrayList<>();

				
				
				for (Conquista c : conquistas) {
					listaId.add(c.getId());
					listaData.add(c.getDataAlteracao());
					
					
					Conquista conquistaAtualizada = repository.verificarAtualizacao(c.getId(), c.getDataAlteracao()); 
					if(conquistaAtualizada != null)
						conquistasAtualizadas.add(conquistaAtualizada);
				}
				
				conquistasAtualizadas.addAll(repository.buscarNovasConquistas(listaId, email));
				
				return conquistasAtualizadas;
				
			} else {
				return repository.findAll();
			}
		} catch (Exception e) {
			throw new Exception("Não foi possível buscar por atualizações nas conquistas", e);
		}
	}

}
