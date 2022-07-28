package br.com.radixeng.exemplo;

import java.lang.reflect.Field;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import javax.persistence.EntityManager;

import org.hibernate.internal.build.AllowSysOut;

import br.com.radixeng.dao.AddressDao;
import br.com.radixeng.dao.ContactDao;
import br.com.radixeng.dao.CustomerAddressDao;
import br.com.radixeng.dao.CustomerDao;
import br.com.radixeng.dao.DAO;
import br.com.radixeng.dao.EmployeeDao;
import br.com.radixeng.dao.ProductDao;
import br.com.radixeng.dao.ProductModelDao;
import br.com.radixeng.dao.PurchaseOrderDetailDao;
import br.com.radixeng.dao.PurchaseOrderHeaderDao;
import br.com.radixeng.dao.SalesOrderDetailDao;
import br.com.radixeng.dao.SalesOrderHeaderDao;
import br.com.radixeng.dao.StateProvinceDao;
import br.com.radixeng.modelo.Address;
import br.com.radixeng.modelo.Contact;
import br.com.radixeng.modelo.Customer;
import br.com.radixeng.modelo.CustomerAddress;
import br.com.radixeng.modelo.Employee;
import br.com.radixeng.modelo.Entidade;
import br.com.radixeng.modelo.Product;
import br.com.radixeng.modelo.ProductModel;
import br.com.radixeng.modelo.PurchaseOrderDetail;
import br.com.radixeng.modelo.PurchaseOrderHeader;
import br.com.radixeng.modelo.SalesOrderDetail;
import br.com.radixeng.modelo.SalesOrderHeader;
import br.com.radixeng.modelo.StateProvince;
import br.com.radixeng.util.JPAUtil;

public class ExemploSelectTodos {
	public static void main(String[] args) {
		EntityManager em = JPAUtil.getEntityManager();
		em.getTransaction().begin();
		
		DAO[] daos = {	
			new AddressDao(em),
			new ContactDao(em),
			new CustomerAddressDao(em),
			new CustomerDao(em),
			new EmployeeDao(em),
			new ProductDao(em),
			new ProductModelDao(em),
			new PurchaseOrderDetailDao(em),
			new PurchaseOrderHeaderDao(em),
			new SalesOrderHeaderDao(em),
			new SalesOrderDetailDao(em),
			new StateProvinceDao(em)
		};
		
		Entidade[] entidades = new Entidade[daos.length];
		
		int iterador = 0; 
		for (DAO dao: daos) {
			entidades[iterador++] = (Entidade) dao.buscarTodos().get(0);
		}
		
		em.flush();		
		em.close();
		
		System.out.println("\nRECEBIDOS: \n");
		for (iterador=0; iterador < entidades.length; iterador++) {
			System.out.println(toJSON(entidades[iterador]));
		}
		
	}
	
	public static String toJSON(Object obj) {
		  StringBuilder result = new StringBuilder();
		  String newLine = System.getProperty("line.separator");

		  result.append( obj.getClass().getName() );
		  result.append( " Object {" );
		  result.append(newLine);

		  //determine fields declared in this class only (no fields of superclass)
		  Field[] fields = obj.getClass().getDeclaredFields();

		  //print field names paired with their values
		  for ( Field field : fields  ) {
		    result.append("\t");
		    try {
		      result.append( field.getName() );
		      result.append(": ");
		      //requires access to private field:
		      result.append( field.get(obj) );
		    } catch ( IllegalAccessException ex ) {
		      System.out.println(ex);
		    }
		    result.append(newLine);
		  }
		  result.append("}");

		  return result.toString();
	}
}
