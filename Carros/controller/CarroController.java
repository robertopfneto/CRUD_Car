package br.edu.ifms.Carros.controller;



import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.stereotype.Controller;

import br.edu.ifms.Carros.modelo.Carros;
import br.edu.ifms.Carros.repository.CarrosRepository;

@Controller
public class CarroController {

	@Autowired
	private CarrosRepository carrosRepository;
	
	
	@RequestMapping("/") 
	public String index(Model model) {
		model.addAttribute("carros", carrosRepository.findAll());		
		return "admin/lista-carros";
	}
	
	@GetMapping("/carro/new")
	public String addCarros(Model model) {
		model.addAttribute("carros", new Carros());
		return "cadastro/cadastro-carros";
	}
	
	@PostMapping("/carro/save")
	public String saveCarros(@Valid Carros carro,BindingResult result, Model model, 
				RedirectAttributes attributes) {
		
		if (result.hasErrors()) {
			return "cadastro/cadastro-carros";
		}
		
		carrosRepository.save(carro);
		attributes.addFlashAttribute("mensagem", "Carro cadastrado!");  
		return "redirect:/";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteUser(@PathVariable("id") long id, Model model) {
		Carros carro = carrosRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Não há um carro cadastrado no id:" + id));
		carrosRepository.delete(carro);
	    return "redirect:/";
	}
	
	@GetMapping("/edit/{id}")
	public String editarUsuario(@PathVariable("id") long id, Model model) {
		Optional<Carros> carroOld = carrosRepository.findById(id);
		if (!carroOld.isPresent()) {
            throw new IllegalArgumentException("Carro não encontrado:" + id);
        } 
		Carros carro = carroOld.get();
	    model.addAttribute("carro", carro);
	    return "/admin/editar-carro";
	}
	
	@PostMapping("/edit/{id}")
	public String editarUsuario(@PathVariable("id") long id, 
			@Valid Carros carro, BindingResult result) {
		if (result.hasErrors()) {
	    	carro.setId(id);
	        return "/auth/user/user-alterar-usuario";
	    }
		carrosRepository.save(carro);
	    return "redirect:/";
	}

	
	
	
}
