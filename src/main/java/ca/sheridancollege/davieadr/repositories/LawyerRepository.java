package ca.sheridancollege.davieadr.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import ca.sheridancollege.davieadr.beans.Lawyer;

public interface LawyerRepository extends JpaRepository<Lawyer, Long> {

	public Lawyer findByNameContainingIgnoreCase(String name);

}
