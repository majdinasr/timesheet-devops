package tn.esprit.spring.services;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Contrat;
import tn.esprit.spring.repository.ContratRepository;
@Service
public class ContratServiceImpl implements IContratService {

	@Autowired
	ContratRepository contratRepository;
	private static final Logger L = LogManager.getLogger(ContratServiceImpl.class);

	 
	
	@Override
	public List<Contrat> retrieveAllContrats() { 
		List<Contrat> contrats = null; 
		try {
	
			
			L.info("In Method retrieveAllContrats :");
			contrats = (List<Contrat>) contratRepository.findAll();  
			for (Contrat contrat : contrats) {
				L.debug("connexion à la DB OK :");
				  
			} 
			L.info("Out of Method retrieveAllContrats with Sucess");
		}catch (Exception e) {
			L.error("Out of Method retrieveAllContrats with Erroes : " +e);
		}

		return contrats;
	}


	@Override
	public Contrat addContrat(Contrat c) {
		
		L.info("In Method addContrat :");
		Contrat c_saved = contratRepository.save(c); 
		L.info("Out of Method addContrat with Sucess"); 
		return c_saved; 
	}

	@Override 
	public Contrat updateContrat(Contrat c) { 
		L.info("In Method updateContrat :"); 
		Contrat c_saved = contratRepository.save(c); 
		L.info("Out of Method updateContrat with Sucess"); 
		return c_saved; 
	}

	@Override
	public void deleteContrat(String id) {
		L.info("In Method deleteContrat :"); 
		contratRepository.deleteById(Long.parseLong(id)); 
		L.info("Out of Method deleteContrat with Sucess");  
	}

	@Override
	public Contrat retrieveContrat(String id) {
		L.info("In Method retrieveContrat :");
		//Contrat c =  contratRepository.findById(Long.parseLong(id)).orElse(null);
		Contrat c =  contratRepository.findById(Long.parseLong(id)).get(); 
		L.info("Out of Method retrieveContrat with Sucess"); 
		return c; 
	}

}
