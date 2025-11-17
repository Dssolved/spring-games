package com.example.games.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "games")
public class Game {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String title;
	private String genre;
	private int releaseYear;
	private double rating;

	@ManyToOne
	@JoinColumn(name = "publisher_id")
	private Publisher publisher;

	@ManyToMany
	@JoinTable(
		name = "game_tags",
		joinColumns = @JoinColumn(name = "game_id"),
		inverseJoinColumns = @JoinColumn(name = "tag_id")
	)
	private Set<Tag> tags = new HashSet<>();
}
