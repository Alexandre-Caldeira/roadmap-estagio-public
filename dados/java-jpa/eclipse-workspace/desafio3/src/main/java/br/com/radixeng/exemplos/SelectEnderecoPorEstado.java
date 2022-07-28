package br.com.radixeng.exemplos;

import java.util.List;

import javax.persistence.EntityManager;


import br.com.radixeng.dao.AddressDao;
import br.com.radixeng.dao.StateProvinceDao;
import br.com.radixeng.modelo.Address;
import br.com.radixeng.util.JPAUtil;

public class SelectEnderecoPorEstado {

	public static void main(String[] args) {
		EntityManager em = JPAUtil.getEntityManager();
		
		StateProvinceDao StateProvinceDao = new StateProvinceDao(em);
		AddressDao AddressDao = new AddressDao(em);
		
		em.getTransaction().begin();
				
		Long californiaID = StateProvinceDao.buscarIdPorCodigoDoEstado("CA ");
		
		em.flush();
		
		// Cria lista de Address usando id coletado anteriormente para apresentar
		List<Address> EnderecosNaCalifornia = AddressDao.buscarEnderecosComEstado(californiaID);
		
		em.getTransaction().commit();
		
		EnderecosNaCalifornia.forEach(
				endereco -> System.out.println(endereco.getAddressLine1()+", "+endereco.getCity()+", ID_estado:"+endereco.getStateProvince().getStateProvinceID())
		);
		
		System.out.println("\n\nID da California: "+ californiaID);
		
		em.close();
	
		
	}
}
