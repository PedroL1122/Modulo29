package org.example.test;

import org.example.dao.IProdutoDAO;
import org.example.dao.ProdutoDAO;
import org.example.domain.Produto;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class ProdutoTest {
    @Test
    public void cadastrarTest() throws Exception {
        IProdutoDAO dao = new ProdutoDAO();

        Produto produto = new Produto();
        produto.setCodigo("01");
        produto.setNome("Tv");

        Integer qtd = dao.cadastrar(produto);
        assertTrue(qtd == 1);

        Produto produtoBD = dao.consultar(produto.getCodigo());
        assertNotNull(produtoBD);
        assertNotNull(produtoBD.getId());
        assertEquals(produto.getCodigo(), produtoBD.getCodigo());
        assertEquals(produto.getNome(), produtoBD.getNome());

        Integer qtdDel = dao.excluir(produtoBD);
        assertNotNull(qtdDel);
    }

    @Test
    public void consultarTest() throws Exception {
        IProdutoDAO dao = new ProdutoDAO();

        Produto produto = new Produto();
        produto.setCodigo("01");
        produto.setNome("Tv");

        Integer qtd = dao.cadastrar(produto);
        assertTrue(qtd == 1);

        Produto produtoBD = dao.consultar(produto.getCodigo());
        assertNotNull(produtoBD);
        assertNotNull(produtoBD.getId());
        assertEquals(produto.getCodigo(), produtoBD.getCodigo());
        assertEquals(produto.getNome(), produtoBD.getNome());

        Integer qtdDel = dao.excluir(produtoBD);
        assertNotNull(qtdDel);
    }

    @Test
    public void consultarTodosTest() throws Exception {
        IProdutoDAO dao = new ProdutoDAO();

        List<Produto> produtos = dao.consultarTodos();
        assertNotNull(produtos);
        assertTrue(produtos.size() > 0);
    }


    @Test
    public void atualizarTest() throws Exception {
        IProdutoDAO dao = new ProdutoDAO();

        Produto produto = new Produto();
        produto.setCodigo("01");
        produto.setNome("Tv");

        Integer qtd = dao.cadastrar(produto);
        assertTrue(qtd == 1);

        produto.setNome("Tv Atualizado");

        Integer qtdAtualizacao = dao.atualizar(produto);
        assertTrue(qtdAtualizacao == 1);

        Produto produtoAtualizado = dao.consultar(produto.getCodigo());
        assertNotNull(produtoAtualizado);
        assertEquals(produto.getCodigo(), produtoAtualizado.getCodigo());
        assertEquals(produto.getNome(), produtoAtualizado.getNome());

        Integer qtdDel = dao.excluir(produtoAtualizado);
        assertNotNull(qtdDel);
    }

    @Test
    public void excluirTest() throws Exception {
        IProdutoDAO dao = new ProdutoDAO();

        Produto produto = new Produto();
        produto.setCodigo("01");
        produto.setNome("Pedro");

        Integer qtd = dao.cadastrar(produto);
        assertTrue(qtd == 1);

        Produto produtoBD = dao.consultar(produto.getCodigo());
        assertNotNull(produtoBD);
        assertNotNull(produtoBD.getId());
        assertEquals(produto.getCodigo(), produtoBD.getCodigo());
        assertEquals(produto.getNome(), produtoBD.getNome());

        Integer qtdDel = dao.excluir(produtoBD);
        assertNotNull(qtdDel);
        assertTrue(qtdDel == 1);

        Produto produtoExcluido = dao.consultar(produto.getCodigo());
        assertNull(produtoExcluido);
    }
}