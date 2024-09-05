package dev.andrelopes.videogamekb.videogame_kb;

import dev.andrelopes.videogamekb.videogame_kb.repository.VideoGameRepository;
import dev.andrelopes.videogamekb.videogame_kb.service.VideoGameService;
import dev.andrelopes.videogamekb.videogame_kb.service.VideoGameServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class VideogameKnowledgeBaseApplication {

	public static void main(String[] args) {
		SpringApplication.run(VideogameKnowledgeBaseApplication.class, args);
	}

	@Bean
	public VideoGameService videoGameService(VideoGameRepository videoGameRepository) {
		return new VideoGameServiceImpl(videoGameRepository);
	}

}
