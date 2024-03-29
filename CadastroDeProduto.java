package br.com.alura.loja.testes;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.alura.loja.dao.CategoriaDao;
import br.com.alura.loja.dao.ProdutoDao;
import br.com.alura.loja.modelo.Categoria;
import br.com.alura.loja.modelo.CategoriaId;
import br.com.alura.loja.modelo.Produto;
import br.com.alura.loja.util.JPAUtil;


public class CadastroDeProduto {

	public static void main(String[] args) {
		    cadastrarProduto();
		        EntityManager em = JPAUtil.getEntityManager();
		        ProdutoDao produtoDao = new ProdutoDao(em);
		        
		        Produto p = produtoDao.buscarPorId(1l);
		        System.out.println(p.getPreco());
		        
		        List<Produto> todos = produtoDao.buscarTodos();
		        todos.forEach(p2 -> System.out.println(p.getNome()));


		    }

	private static void cadastrarProduto() {
		Categoria celulares = new Categoria("CELULARES");
		Produto celular = new Produto("XIAOMI", "mi 9 lite", new BigDecimal("800"), celulares);
		
		// criando uma conexão
		EntityManager em = JPAUtil.getEntityManager();
		// criando um obj do tipo dao onde realiza as operações do bd
		ProdutoDao produtoDao = new ProdutoDao(em);
		CategoriaDao categoriaDao = new CategoriaDao(em);

		      em.getTransaction().begin();
		      categoriaDao.cadastrar(celulares);       
		      produtoDao.cadastrar(celular);
		      em.getTransaction().commit();
		      em.find(Categoria.class, new CategoriaId("CELULARES", "XIAOMI"));
		      em.close();
	}

		}