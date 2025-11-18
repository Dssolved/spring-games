package com.example.games.controller;

import com.example.games.dto.GameDTO;
import com.example.games.service.GameService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/games")
@RequiredArgsConstructor
public class GameController {

	private final GameService gameService;

	@GetMapping
	public List<GameDTO> getAll() {
		return gameService.getAll();
	}

	@PostMapping
	public GameDTO create(@RequestBody GameDTO dto) {
		return gameService.create(dto);
	}

	@PutMapping("/{id}")
	public GameDTO update(@PathVariable Long id, @RequestBody GameDTO dto) {
		return gameService.update(id, dto);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		gameService.delete(id);
	}
}
