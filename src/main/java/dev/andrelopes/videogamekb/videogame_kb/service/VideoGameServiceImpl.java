package dev.andrelopes.videogamekb.videogame_kb.service;

/**
 * @author <a href="mailto:<andre.matos.lopes@xpand-it.com>"><Andre Lopes></a>
 * @version $Revision: 666 $
 */

import dev.andrelopes.videogamekb.videogame_kb.model.VideoGame;
import dev.andrelopes.videogamekb.videogame_kb.repository.VideoGameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VideoGameServiceImpl implements VideoGameService {

  private final VideoGameRepository videoGameRepository;

  @Autowired
  public VideoGameServiceImpl(VideoGameRepository videoGameRepository) {
    this.videoGameRepository = videoGameRepository;
  }


  public List<VideoGame> getAllGames() {
    return videoGameRepository.findAll();
  }

  public VideoGame getGameById(Long id) {
    return videoGameRepository.findById(id).orElse(null);
  }

  @Override
  public VideoGame addGame(VideoGame videoGame) {
    return videoGameRepository.save(videoGame);
  }

  @Override
  public VideoGame updateGame(Long id, VideoGame videoGame) {
    if (videoGameRepository.existsById(id)) {
      return videoGameRepository.save(videoGame);
    } else {
      return null;
    }
  }

  public void deleteGame(Long id) {
    videoGameRepository.deleteById(id);
  }

  // Additional business logic can go here
}

