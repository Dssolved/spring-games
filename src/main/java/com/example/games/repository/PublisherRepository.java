package com.example.games.repository;

import com.example.games.entity.Publisher;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@Transactional
public interface PublisherRepository extends JpaRepository<Publisher, Long> {
	Optional<Publisher> findByName(String name);
}
