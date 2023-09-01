package br.com.senai.controller;

import br.com.senai.model.Livro;
import br.com.senai.services.LivroServicesInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class LivroController {
	
	@Autowired
	private LivroServicesInterface servico;
	
	@GetMapping({"/livro"})
	public String ListarLivros(Model modelo) {
		modelo.addAttribute("livro",servico.ListarLivros());
		return "livro";
	}
	
	
	 @GetMapping("/livros/novo")
	    public String exibirFormularioNovoLivro(Model model) {
	        model.addAttribute("livro", new Livro());
	        return "formularioNovoLivro";
	    }

	    @PostMapping("/livros/novo")
	    public String salvarNovoLivro(@ModelAttribute Livro livro) {
	        servico.salvarLivro(livro); 
	        return "redirect:/livro"; 
	    }
	    
	    @GetMapping("/livros/{id}/editar")
	    public String exibirFormularioEditarLivro(@PathVariable Long id, Model model) {
	        Livro livro = servico.encontrarLivroPorId(id);
	        model.addAttribute("livro", livro);
	        return "formularioEditarLivro";
	    }

	    @PostMapping("/livros/{id}/editar")
	    public String salvarLivroEditado(@PathVariable Long id, @ModelAttribute Livro livro) {
	        servico.atualizarLivro(id, livro); 
	        return "redirect:/livro";
	    }
	    @GetMapping("/livros/{id}/excluir")
	    public String excluirLivro(@PathVariable Long id) {
	        servico.excluirLivro(id);
	        return "redirect:/livro";
	    }
	    
}
