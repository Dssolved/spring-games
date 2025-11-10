package com.example.games.controller;

import com.example.games.dto.GameDTO;
import com.example.games.service.GameService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/games")
public class GameController {

	private final GameService gameService;

	@GetMapping
	public ResponseEntity<List<GameDTO>> getAllGames() {
		return ResponseEntity.ok(gameService.getAllGames());
	}

	@GetMapping("/{id}")
	public ResponseEntity<GameDTO> getGameById(@PathVariable Long id) {
		GameDTO dto = gameService.getGameById(id);
		return dto != null ? ResponseEntity.ok(dto) : ResponseEntity.notFound().build();
	}

	@PostMapping
	public ResponseEntity<GameDTO> createGame(@RequestBody GameDTO dto) {
		return ResponseEntity.ok(gameService.createGame(dto));
	}

	@PutMapping("/{id}")
	public ResponseEntity<GameDTO> updateGame(@PathVariable Long id, @RequestBody GameDTO dto) {
		GameDTO updated = gameService.updateGame(id, dto);
		return updated != null ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteGame(@PathVariable Long id) {
		boolean deleted = gameService.deleteGame(id);
		return deleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
	}
}
