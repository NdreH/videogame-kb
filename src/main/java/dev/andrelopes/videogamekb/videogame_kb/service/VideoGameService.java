package dev.andrelopes.videogamekb.videogame_kb.service;

import dev.andrelopes.videogamekb.videogame_kb.model.VideoGame;
import java.util.List;

/**
 * @author <a href="mailto:<andre.matos.lopes@xpand-it.com>"><Andre Lopes></a>
 * @version $Revision: 666 $
 */
public interface VideoGameService {
  List<VideoGame> getAllGames();

  VideoGame getGameById(Long id);

  VideoGame addGame(VideoGame videoGame);

  VideoGame updateGame(Long id, VideoGame videoGame);

  VideoGame deleteGame(Long id);
}
