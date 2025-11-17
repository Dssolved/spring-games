package com.example.games.service;

import com.example.games.dto.GameDTO;
import com.example.games.entity.Game;
import com.example.games.entity.Publisher;
import com.example.games.entity.Tag;
import com.example.games.mapper.GameMapper;
import com.example.games.repository.GameRepository;
import com.example.games.repository.PublisherRepository;
import com.example.games.repository.TagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class GameService {

	private final GameRepository gameRepository;
	private final PublisherRepository publisherRepository;
	private final TagRepository tagRepository;
	private final GameMapper gameMapper;

	public List<GameDTO> getAll() {
		List<Game> games = gameRepository.findAll();
		return gameMapper.toDtoList(games);
	}

	public GameDTO create(GameDTO dto) {
		Game game = gameMapper.toEntity(dto);
		Publisher publisher = publisherRepository.findByName(dto.getPublisherName())
			.orElse(null);
		game.setPublisher(publisher);
		Set<Tag> tags = tagRepository.findAllByNameIn(dto.getTags());
		game.setTags(tags);
		return gameMapper.toDto(gameRepository.save(game));
	}
}
