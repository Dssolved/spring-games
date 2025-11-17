package com.example.games.controller;

import com.example.games.dto.TagDTO;
import com.example.games.entity.Tag;
import com.example.games.repository.TagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tags")
@RequiredArgsConstructor
public class TagController {

	private final TagRepository repo;

	@GetMapping
	public List<TagDTO> getAll() {
		return repo.findAll().stream()
			.map(t -> {
				TagDTO dto = new TagDTO();
				dto.setId(t.getId());
				dto.setName(t.getName());
				return dto;
			})
			.toList();
	}

	@PostMapping
	public TagDTO create(@RequestBody TagDTO dto) {
		Tag tag = Tag.builder()
			.name(dto.getName())
			.build();
		repo.save(tag);
		dto.setId(tag.getId());
		return dto;
	}
}
