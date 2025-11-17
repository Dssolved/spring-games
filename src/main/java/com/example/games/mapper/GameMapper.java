package com.example.games.mapper;

import com.example.games.dto.GameDTO;
import com.example.games.entity.Game;
import com.example.games.entity.Tag;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Mapper(componentModel = "spring")
public interface GameMapper {

	@Mapping(source = "publisher.name", target = "publisherName")
	@Mapping(source = "tags", target = "tags", qualifiedByName = "tagsToNames")
	GameDTO toDto(Game game);

	@Mapping(target = "publisher", ignore = true)
	@Mapping(target = "tags", ignore = true)
	Game toEntity(GameDTO dto);

	@Named("tagsToNames")
	default Set<String> tagsToNames(Set<Tag> tags) {
		Set<String> result = new HashSet<>();
		if (tags == null) {
			return result;
		}
		for (Tag tag : tags) {
			result.add(tag.getName());
		}
		return result;
	}

	List<GameDTO> toDtoList(List<Game> games);
}
