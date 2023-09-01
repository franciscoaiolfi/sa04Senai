package br.com.senai.services;

import java.util.List;

import br.com.senai.model.Livro;

public interface LivroServicesInterface {

	public List<Livro>ListarLivros();
	 Livro salvarLivro(Livro livro);
	Livro encontrarLivroPorId(Long id);
	Livro atualizarLivro(Long id, Livro livroAtualizado);
	public void excluirLivro(Long id);
}
