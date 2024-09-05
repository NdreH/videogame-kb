package dev.andrelopes.videogamekb.videogame_kb.controller;

/**
 * @author <a href="mailto:<andre.matos.lopes@xpand-it.com>"><Andre Lopes></a>
 * @version $Revision: 666 $
 */

import dev.andrelopes.videogamekb.videogame_kb.model.VideoGame;
import dev.andrelopes.videogamekb.videogame_kb.service.VideoGameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/games")
public class VideoGameControllerImpl implements VideoGameController {

  private final VideoGameService videoGameServiceImpl;

  @Autowired
  public VideoGameControllerImpl(VideoGameService videoGameService) {
    this.videoGameServiceImpl = videoGameService;
  }

  @Override
  @GetMapping
  public ResponseEntity<List<VideoGame>> getAllGames() {
    return ResponseEntity.ok(videoGameServiceImpl.getAllGames());
  }

  @Override
  @GetMapping("/{id}")
  public ResponseEntity<VideoGame> getGameById(@PathVariable Long id) {
    VideoGame game = videoGameServiceImpl.getGameById(id);
    return game != null ? ResponseEntity.ok(game) : ResponseEntity.notFound().build();
  }

  @Override
  @PostMapping
  public ResponseEntity<VideoGame> createGame(@RequestBody VideoGame game) {
    return ResponseEntity.ok(videoGameServiceImpl.addGame(game));
  }

  @Override
  @PutMapping("/{id}")
  public ResponseEntity<VideoGame> updateGame(@PathVariable Long id,
      @RequestBody VideoGame gameDetails) {
    VideoGame updatedVideoGame = videoGameServiceImpl.updateGame(id, gameDetails);
    return updatedVideoGame != null ? ResponseEntity.ok(updatedVideoGame)
        : ResponseEntity.notFound().build();
  }

  @Override
  @DeleteMapping("/{id}")
  public ResponseEntity<VideoGame> deleteGame(@PathVariable Long id) {
    VideoGame game = videoGameServiceImpl.getGameById(id);
    if (game != null) {
      VideoGame deletedGame = videoGameServiceImpl.deleteGame(id);
      return ResponseEntity.ok(deletedGame);
    } else {
      return ResponseEntity.notFound().build();
    }
  }
}
