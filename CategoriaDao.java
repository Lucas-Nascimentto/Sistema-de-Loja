package br.com.alura.loja.dao;

import javax.persistence.EntityManager;

import br.com.alura.loja.modelo.Categoria;

public class CategoriaDao {

    private EntityManager em;
    
    

    public CategoriaDao() {
	}

	// construtor. pq para realizar qualquer operação na tabela, precisamos abrir uma conexão
    public CategoriaDao(EntityManager em) {
        this.em = em;
    }

    //insere a categoria
    public void cadastrar(Categoria categoria) {
        this.em.persist(categoria);
    }

    public void atualizar(Categoria categoria) {
    	this.em.merge(categoria);
    }
    
    public void remover(Categoria categoria) {
    	categoria = em.merge(categoria);
    	this.em.remove(categoria);
    }
}
