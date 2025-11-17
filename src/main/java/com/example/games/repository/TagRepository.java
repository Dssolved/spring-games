package com.example.games.repository;

import com.example.games.entity.Tag;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
@Transactional
public interface TagRepository extends JpaRepository<Tag, Long> {
	Set<Tag> findAllByNameIn(Set<String> names);
}
