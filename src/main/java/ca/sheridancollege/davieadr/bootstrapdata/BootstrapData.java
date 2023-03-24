package ca.sheridancollege.davieadr.bootstrapdata;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import ca.sheridancollege.davieadr.beans.Art;
import ca.sheridancollege.davieadr.beans.Lawyer;
import ca.sheridancollege.davieadr.repositories.ArtRepository;
import ca.sheridancollege.davieadr.repositories.LawyerRepository;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class BootstrapData implements CommandLineRunner {

	private LawyerRepository lawyerRepo;
	private ArtRepository artRepo;
	
	@Override
	public void run(String... args) throws Exception {

		Lawyer l1 = Lawyer.builder()
				.name("Ricky")
				.build();
		Lawyer l2 = Lawyer.builder()
				.name("Julian")
				.build();
		Lawyer l3 = Lawyer.builder()
				.name("Bubbles")
				.build();
		
		Art a1 = Art.builder()
				.name("Portrait")
				.price(69.99)
				.quantity(5)
				.employeeName("Ricky")
				.build();
		Art a2 = Art.builder()
				.name("Landscape")
				.price(69.99)
				.quantity(6)
				.employeeName("Ricky")
				.build();
		Art a3 = Art.builder()
				.name("Sculpture")
				.price(79.99)
				.quantity(3)
				.employeeName("Ricky")
				.build();
		Art a4 = Art.builder()
				.name("Photograph")
				.price(49.99)
				.quantity(10)
				.employeeName("Julian")
				.build();
		Art a5 = Art.builder()
				.name("Sketch")
				.price(29.99)
				.quantity(30)
				.employeeName("Julian")
				.build();
		Art a6 = Art.builder()
				.name("Painting")
				.price(89.99)
				.quantity(8)
				.employeeName("Julian")
				.build();
		Art a7 = Art.builder()
				.name("Still Life")
				.price(69.99)
				.quantity(7)
				.employeeName("Bubbles")
				.build();
		Art a8 = Art.builder()
				.name("Mixed Media")
				.price(109.99)
				.quantity(5)
				.employeeName("Bubbles")
				.build();
		Art a9 = Art.builder()
				.name("Sound Installation")
				.price(209.99)
				.quantity(1)
				.employeeName("Bubbles")
				.build();
		Art a10 = Art.builder()
				.name("Art No. 10")
				.price(9.99)
				.quantity(35)
				.employeeName("Julian")
				.build();
		
		a1.setLawyer(l1);
		a2.setLawyer(l1);
		a3.setLawyer(l1);
		a4.setLawyer(l2);
		a5.setLawyer(l2);
		a6.setLawyer(l2);
		a7.setLawyer(l3);
		a8.setLawyer(l3);
		a9.setLawyer(l3);
		a10.setLawyer(l2);
		
		lawyerRepo.save(l1);
		lawyerRepo.save(l2);
		lawyerRepo.save(l3);
		
		artRepo.save(a1);
		artRepo.save(a2);
		artRepo.save(a3);
		artRepo.save(a4);
		artRepo.save(a5);
		artRepo.save(a6);
		artRepo.save(a7);
		artRepo.save(a8);
		artRepo.save(a9);
		artRepo.save(a10);
	}

}
