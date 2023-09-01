package br.com.senai.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.senai.model.Livro;
import br.com.senai.repository.LivroRepository;

@Service
public class LivrosService implements LivroServicesInterface {

	@Autowired
	private LivroRepository repositorio;

	public List<Livro> ListarLivros() {
		return (List<Livro>) repositorio.findAll();
	}
	
	 @Override
	    public Livro salvarLivro(Livro livro) {
	        return repositorio.save(livro);
}
	 
	 @Override
	 public Livro encontrarLivroPorId(Long id) {
		    return repositorio.findById(id).orElse(null);
		}

	 @Override
	 public Livro atualizarLivro(Long id, Livro livroAtualizado) {
	     Livro livroExistente = repositorio.findById(id).orElse(null);
	     if (livroExistente != null) {
	         livroExistente.setNome(livroAtualizado.getNome());
	         livroExistente.setValor(livroAtualizado.getValor());
	         return repositorio.save(livroExistente);
	     }
	     return null;
	 }
	 
	 public void excluirLivro(Long id) {
		    repositorio.deleteById(id);
		}


}