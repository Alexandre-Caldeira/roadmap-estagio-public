package br.com.radixeng.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.radixeng.modelo.Contact;

public interface DAO<T> {	    
	// TODO: refatorar para Optional<T> ?
    T buscarPorId(Long id); // select where PK
    
    List<T> buscarTodos(); // select *
    
    void cadastrar(T t); // insert
    
    // TODO: refatorar para receber (T t, String[] params) ?
    // perguntar: deveria ser Optional<T> ?
    T atualizar(T t); // update
    
    void remover(T t); // delete
}
