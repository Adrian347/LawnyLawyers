package ca.sheridancollege.davieadr.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ca.sheridancollege.davieadr.beans.Lawyer;
import ca.sheridancollege.davieadr.repositories.LawyerRepository;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/lawyers")
public class LawyerController {

	private LawyerRepository lRepo;
	
	// return collection of lawyers
	@GetMapping(value={"","/"})	// multiple URLS for same method
	public List<Lawyer> getLawyers() {
		return lRepo.findAll();
	}
	
	// return single lawyer element
	@GetMapping("/{id}")
	public Lawyer getLawyer(@PathVariable Long id) {
		Optional<Lawyer> l = lRepo.findById(id);
		if (l.isPresent())
			return lRepo.findById(id).get();
		else 
			return null;
	}
	
	// create single lawyer element
	@PostMapping(value={"","/"}, 
			headers={"Content-type=application/json"})	
			// expect a JSON record as part of request header
	public String postLawyer(@RequestBody Lawyer lawyer) {
		Lawyer l = lRepo.save(lawyer);
		return "Lawyer added at index " + l.getId();
	}
}
