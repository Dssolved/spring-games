package com.example.games.dto;

import com.example.games.entity.Game;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GameDTO {
	private Long id;
	private String title;
	private String genre;
	private Integer releaseYear;
	private Double rating;

	public static GameDTO toDto(Game game) {
		return GameDTO.builder()
			.id(game.getId())
			.title(game.getTitle())
			.genre(game.getGenre())
			.releaseYear(game.getReleaseYear())
			.rating(game.getRating())
			.build();
	}

	public static Game toEntity(GameDTO dto) {
		return Game.builder()
			.id(dto.getId())
			.title(dto.getTitle())
			.genre(dto.getGenre())
			.releaseYear(dto.getReleaseYear())
			.rating(dto.getRating())
			.build();
	}
}
