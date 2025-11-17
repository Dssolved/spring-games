package com.example.games.controller;

import com.example.games.dto.PublisherDTO;
import com.example.games.entity.Publisher;
import com.example.games.repository.PublisherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/publishers")
@RequiredArgsConstructor
public class PublisherController {

	private final PublisherRepository repo;

	@GetMapping
	public List<PublisherDTO> getAll() {
		return repo.findAll().stream()
			.map(p -> {
				PublisherDTO dto = new PublisherDTO();
				dto.setId(p.getId());
				dto.setName(p.getName());
				return dto;
			})
			.toList();
	}

	@PostMapping
	public PublisherDTO create(@RequestBody PublisherDTO dto) {
		Publisher publisher = Publisher.builder()
			.name(dto.getName())
			.build();
		repo.save(publisher);
		dto.setId(publisher.getId());
		return dto;
	}
}
