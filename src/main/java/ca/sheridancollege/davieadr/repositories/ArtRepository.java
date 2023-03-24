package ca.sheridancollege.davieadr.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ca.sheridancollege.davieadr.beans.Art;

public interface ArtRepository extends JpaRepository<Art, Long> {

}
