package dev.andrelopes.videogamekb.videogame_kb.controller;

import dev.andrelopes.videogamekb.videogame_kb.model.VideoGame;
import java.util.List;
import org.springframework.http.ResponseEntity;

/**
 * @author <a href="mailto:<andre.matos.lopes@xpand-it.com>"><Andre Lopes></a>
 * @version $Revision: 666 $
 */
public interface VideoGameController {

  ResponseEntity<List<VideoGame>> getAllGames();

  ResponseEntity<VideoGame> getGameById(Long id);

  ResponseEntity<VideoGame> createGame(VideoGame videoGame);

  ResponseEntity<VideoGame> updateGame(Long id, VideoGame videoGame);

  ResponseEntity<Void> deleteGame(Long id);

}
