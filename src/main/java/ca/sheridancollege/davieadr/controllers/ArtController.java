package ca.sheridancollege.davieadr.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ca.sheridancollege.davieadr.beans.Art;
import ca.sheridancollege.davieadr.beans.Lawyer;
import ca.sheridancollege.davieadr.repositories.ArtRepository;
import ca.sheridancollege.davieadr.repositories.LawyerRepository;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/art")
public class ArtController {

	private ArtRepository aRepo;
	private LawyerRepository lRepo;
	
	// return collection of art
	@GetMapping(value={"","/"})	// multiple URLS for same method
	public List<Art> getArtCollection() {
		return aRepo.findAll();
	}
	
	// return single art element
	@GetMapping("/{id}")
	public Art getArt(@PathVariable Long id) {
		Optional<Art> a = aRepo.findById(id);
		if (a.isPresent())
			return aRepo.findById(id).get();
		else 
			return null;
	}
		
	// create single art element
	@PostMapping(value={"","/"}, 
			headers={"Content-type=application/json"})	
			// expect a JSON record as part of request header
	public String postArt(@RequestBody Art art) {
		Art a = aRepo.save(art);
		return "Art added at index " + a.getId();
	}
	
	// Still can't add the Lawyer to the art, but can change the employee name
	
	// update single art element
	@PutMapping(value={"/{id}"}, 
			headers={"Content-type=application/json"})
	public Art putArt(@RequestBody Art art, @PathVariable Long id)
			// @RequestParam Long lawyerId) 
	{
		art.setId(id);
		// Lawyer l = lRepo.findById(lawyerId).get();
		// art.setLawyer(l);
		return aRepo.save(art);
	}
	
	// delete art
	@DeleteMapping("/{id}")
	public String deleteArt(@PathVariable Long id) {
		if (id != null && aRepo.findById(id).isPresent()) {
			aRepo.deleteById(id);
			return "Record at index " + id + " was deleted.";
		}
		else {
			return "No record found at index " + id;
		}
	}
}
