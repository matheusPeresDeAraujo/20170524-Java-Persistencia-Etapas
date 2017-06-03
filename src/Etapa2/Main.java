package Etapa2;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;


public class Main {

	public static void main(String[] args) {
		
		EntityManager em = Persistence.createEntityManagerFactory("20170524_unit").createEntityManager();
		em.getTransaction().begin();
		
		Projeto projeto = new Projeto();
		projeto.setNome("Projeto 1");
		//projeto.setNumero(100);
		projeto.setOrcamento(100.0001f);
		projeto.setDuracao(100);
		projeto.setInicio(new Date());
		em.persist(projeto);
		em.flush();
		
		projeto.setNome("NovoNome");
		em.merge(projeto);
		em.flush();
		
		em.refresh(projeto);
		em.flush();
		
		em.remove(projeto);
		em.flush();
		
		em.getTransaction().commit();
		em.close();

	}

}
