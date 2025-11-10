package com.example.games.repository;

import com.example.games.entity.Game;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface GameRepository extends JpaRepository<Game, Long> {
}
