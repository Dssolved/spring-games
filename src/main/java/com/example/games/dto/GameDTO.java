package com.example.games.dto;

import lombok.Data;

import java.util.Set;

@Data
public class GameDTO {
	private Long id;
	private String title;
	private String genre;
	private int releaseYear;
	private double rating;
	private String publisherName;
	private Set<String> tags;
}
