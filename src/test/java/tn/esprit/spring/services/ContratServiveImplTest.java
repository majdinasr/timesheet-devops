package tn.esprit.spring.services;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import tn.esprit.spring.entities.Contrat;


@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class ContratServiveImplTest {
	@Autowired
	IContratService us;

	
	public void testRetrieveAllContrats() {
	List<Contrat> listContrats = us.retrieveAllContrats();
	Assertions.assertEquals(20, listContrats.size());
	}
	
	
	public void testAddContrat() throws ParseException, java.text.ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date d = dateFormat.parse("2015-03-23");
		Contrat c = new Contrat (d,"affaire", 15,100);
		Contrat contratAdded = us.addContrat(c);
		Assertions.assertEquals(c.getReference(), contratAdded.getReference());
	}
		
	
	public void testUpdateContrat() throws ParseException, java.text.ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date d = dateFormat.parse("2015-03-15");
		Contrat c = new Contrat (d,"affaire", 15,100);
		Contrat contratUpdated = us.addContrat(c);
		Assertions.assertEquals(c.getReference(), contratUpdated.getReference());
		
		
	}
	
	public void testDeleteContrat(){
		us.deleteContrat("25");
		Assertions.assertNull(us.retrieveContrat("25"));
		
	}
	
	
	
	
	private static final Logger L = LogManager.getLogger(ContratServiceImpl.class);
	
	@Test
	public void testAll(){
		try{
			L.info("In testAll()");
			testRetrieveAllContrats();
			testAddContrat();
			testUpdateContrat();
			testDeleteContrat();
			L.info("Out of testAll()");
		}catch(Exception e){
			L.error("Out of testAll()with error:" +e);
		}
		
	}
	

}


