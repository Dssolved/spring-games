package com.example.games.service;

import com.example.games.dto.GameDTO;
import com.example.games.entity.Game;
import com.example.games.repository.GameRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class GameService {

	private final GameRepository gameRepository;

	public List<GameDTO> getAllGames() {
		List<Game> games = gameRepository.findAll();
		List<GameDTO> gameDtoList = new ArrayList<>();
		games.forEach(game -> {
			GameDTO dto = GameDTO.toDto(game);
			gameDtoList.add(dto);
		});
		return gameDtoList;
	}

	public GameDTO getGameById(Long id) {
		Game game = gameRepository.findById(id).orElse(null);
		if (Objects.isNull(game)) return null;
		return GameDTO.toDto(game);
	}

	public GameDTO createGame(GameDTO dto) {
		Game game = GameDTO.toEntity(dto);
		Game saved = gameRepository.save(game);
		return GameDTO.toDto(saved);
	}

	public GameDTO updateGame(Long id, GameDTO dto) {
		Game existing = gameRepository.findById(id).orElse(null);
		if (existing == null) return null;

		existing.setTitle(dto.getTitle());
		existing.setRating(dto.getRating());
		Game updated = gameRepository.save(existing);
		return GameDTO.toDto(updated);
	}

	public boolean deleteGame(Long id) {
		if (gameRepository.existsById(id)) {
			gameRepository.deleteById(id);
			return true;
		}
		return false;
	}
}
