package org.java.spring.controller;

import java.util.List;

import org.java.spring.db.pojo.Pizza;
import org.java.spring.db.serv.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.validation.Valid;

@Controller
public class PizzaController {

	
	@Autowired
	private PizzaService pizzaService;
	
	@GetMapping
	public String getPizzas(Model model,
			@RequestParam(required = false) String search) {
		List<Pizza> pizzas = search == null 
				? pizzaService.findAll()
				: pizzaService.findByName(search);
		
	
		model.addAttribute("pizze", pizzas);
		model.addAttribute("search", search == null ? "" : search);
		
		return "firstPage";
	}
	
	@GetMapping("/pizza/{id}")
	public String getPizza(Model model, 
				@PathVariable int id) {
		Pizza pizza = pizzaService.findById(id);
		model.addAttribute("pizza", pizza);
		
		return "showPizza";
	}
	
	@GetMapping("/pizze/create")
	public String createPizza(Model model) {
		Pizza pizza = new Pizza();
		model.addAttribute("pizza", pizza);
		
		return "pizzaCreate";
	}
	
	@PostMapping("/pizze/create")
	public String storePizza(Model model,
					@Valid @ModelAttribute Pizza pizza,
					BindingResult bindingResult) {
		
		
		if(bindingResult.hasErrors()) {
			model.addAttribute("pizza", pizza);
			return "pizzaCreate";
		}
		
		pizzaService.save(pizza);
		
		return "redirect:/";
	}
	
	@GetMapping("/pizza/edit/{id}")
	public String editPizza (Model model,
				@PathVariable int id) {
		Pizza pizza = pizzaService.findById(id);
		model.addAttribute("pizza", pizza);
		
		return "pizzaCreate";
	}
	
	@PostMapping("/pizza/edit/{id}")
	public String updatePizza(Model model,
				@Valid @ModelAttribute Pizza pizza,
				BindingResult bindingResult) {
		return storePizza(model, pizza, bindingResult);
	}
	
	@PostMapping("/pizza/delete/{id}")
	public String deletePizza(@PathVariable int id) {
		Pizza pizza = pizzaService.findById(id);
		pizzaService.delete(pizza);
		
		return "redirect:/";
	}
	
}
