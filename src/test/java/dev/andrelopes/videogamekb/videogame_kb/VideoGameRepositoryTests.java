package dev.andrelopes.videogamekb.videogame_kb;

import static org.assertj.core.api.Assertions.assertThat;

import dev.andrelopes.videogamekb.videogame_kb.model.VideoGame;
import dev.andrelopes.videogamekb.videogame_kb.repository.VideoGameRepository;
import java.time.LocalDate;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author <a href="mailto:<andre.matos.lopes@xpand-it.com>"><Andre Lopes></a>
 * @version $Revision: 666 $
 */

//@RunWith(SpringRunner.class)
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE,
//    properties = "blog-service.base-url:http://localhost:8082",
//    classes = VideoGame.class)
//@ContextConfiguration
@DataJpaTest
public class VideoGameRepositoryTests {

  @Autowired
  private VideoGameRepository videoGameRepository;

  @BeforeEach
  void setUp() {
    videoGameRepository.deleteAll();
  }

  @Test
  @Transactional
  public void testCreateAndFindVideoGame() {
    VideoGame videoGame1 = new VideoGame.Builder("VideoGame1", "Category1", "Genre1")
        .build();
    VideoGame videoGame2 = new VideoGame.Builder("VideoGame2", "Category2", "Genre2")
        .platform("PC")
        .developer("Valve")
        .publisher("CD Projekt Red")
        .description("Some description")
        .pegiRating(18)
        .netRevenue(10000000)
        .rating(9.1)
        .copiesSold(1000000)
        .releaseDate(LocalDate.of(2015, 10, 29))
        .build();

    VideoGame savedVideoGame1 = videoGameRepository.save(videoGame1);
    VideoGame savedVideoGame2 = videoGameRepository.save(videoGame2);

    Optional<VideoGame> foundVideoGame1 = videoGameRepository.findById(savedVideoGame1.getId());
    Optional<VideoGame> foundVideoGame2 = videoGameRepository.findById(savedVideoGame2.getId());

    assertThat(foundVideoGame1).isPresent();
    assertThat(foundVideoGame1.get().getName()).isEqualTo("VideoGame1");
    assertThat(foundVideoGame1.get().getCategory()).isEqualTo("Category1");
    assertThat(foundVideoGame1.get().getGenre()).isEqualTo("Genre1");
    assertThat(foundVideoGame1.get().getPlatform()).isEqualTo("N/A");
    assertThat(foundVideoGame1.get().getDeveloper()).isEqualTo("N/A");
    assertThat(foundVideoGame1.get().getPublisher()).isEqualTo("N/A");
    assertThat(foundVideoGame1.get().getDescription()).isEqualTo("N/A");
    assertThat(foundVideoGame1.get().getPegiRating()).isEqualTo(0);
    assertThat(foundVideoGame1.get().getNetRevenue()).isEqualTo(0.0);
    assertThat(foundVideoGame1.get().getRating()).isEqualTo(0.0);
    assertThat(foundVideoGame1.get().getCopiesSold()).isEqualTo(0);
    assertThat(foundVideoGame1.get().getReleaseDate()).isNull();

    assertThat(foundVideoGame2).isPresent();
    assertThat(foundVideoGame2.get().getName()).isEqualTo("VideoGame2");
    assertThat(foundVideoGame2.get().getCategory()).isEqualTo("Category2");
    assertThat(foundVideoGame2.get().getGenre()).isEqualTo("Genre2");
    assertThat(foundVideoGame2.get().getPlatform()).isEqualTo("PC");
    assertThat(foundVideoGame2.get().getDeveloper()).isEqualTo("Valve");
    assertThat(foundVideoGame2.get().getPublisher()).isEqualTo("CD Projekt Red");
    assertThat(foundVideoGame2.get().getDescription()).isEqualTo("Some description");
    assertThat(foundVideoGame2.get().getPegiRating()).isEqualTo(18);
    assertThat(foundVideoGame2.get().getNetRevenue()).isEqualTo(10000000);
    assertThat(foundVideoGame2.get().getRating()).isEqualTo(9.1);
    assertThat(foundVideoGame2.get().getCopiesSold()).isEqualTo(1000000);
    assertThat(foundVideoGame2.get().getReleaseDate()).isNotNull();
    assertThat(foundVideoGame2.get().getReleaseDate()).isEqualTo("2015-10-29");
  }

  @Test
  @Transactional
  public void testUpdateVideoGame() {
    VideoGame videoGame = new VideoGame.Builder("VideoGame", "Category", "Genre")
        .build();
    VideoGame savedVideoGame = videoGameRepository.save(videoGame);

    assertThat(savedVideoGame.getName()).isNotEqualTo("VideoGame Updated");
    assertThat(savedVideoGame.getCategory()).isNotEqualTo("Category Updated");
    assertThat(savedVideoGame.getGenre()).isNotEqualTo("Genre Updated");

    savedVideoGame.setName("VideoGame Updated");
    savedVideoGame.setCategory("Category Updated");
    savedVideoGame.setGenre("Genre Updated");
    VideoGame updatedVideoGame = videoGameRepository.save(savedVideoGame);

    assertThat(updatedVideoGame.getName()).isEqualTo("VideoGame Updated");
    assertThat(updatedVideoGame.getCategory()).isEqualTo("Category Updated");
    assertThat(updatedVideoGame.getGenre()).isEqualTo("Genre Updated");

    Optional<VideoGame> foundVideoGame = videoGameRepository.findById(updatedVideoGame.getId());

    assertThat(foundVideoGame).isPresent();
    assertThat(foundVideoGame.get().getName()).isEqualTo("VideoGame Updated");
    assertThat(foundVideoGame.get().getCategory()).isEqualTo("Category Updated");
    assertThat(foundVideoGame.get().getGenre()).isEqualTo("Genre Updated");
  }

  @Test
  @Transactional
  public void testDeleteVideoGame() {
    VideoGame videoGame = new VideoGame.Builder("VideoGame", "Category", "Genre")
        .build();
    VideoGame savedVideoGame = videoGameRepository.save(videoGame);

    videoGameRepository.deleteById(savedVideoGame.getId());
    Optional<VideoGame> foundVideoGame = videoGameRepository.findById(savedVideoGame.getId());

    assertThat(foundVideoGame).isNotPresent();
  }

  @Test
  @Transactional
  public void testFindAllVideoGames() {
    VideoGame videoGame1 = new VideoGame.Builder("VideoGame1", "Category1", "Genre1")
        .build();
    VideoGame videoGame2 = new VideoGame.Builder("VideoGame2", "Category2", "Genre2")
        .build();
    VideoGame videoGame3 = new VideoGame.Builder("VideoGame3", "Category3", "Genre3")
        .build();

    videoGameRepository.save(videoGame1);
    videoGameRepository.save(videoGame2);
    videoGameRepository.save(videoGame3);

    assertThat(videoGameRepository.findAll()).hasSize(3);
  }

//  private static final int port = 8082;
//  private static ClientAndServer mockServer;
//
//  @BeforeClass
//  public static void startServer() {
//    mockServer = startClientAndServer(port);
//    createExpectationForInvalidAuth();
//  }
//
//  private static void createExpectationForInvalidAuth() {
//    new MockServerClient("127.0.0.1", port)
//        .when(
//            request()
//                .withMethod("GET")
//                .withPath("/blog/1")
//                .withHeader("\"Content-type\", \"application/json\""),
//            exactly(1))
//        .respond(
//            response()
//                .withStatusCode(200)
//                .withHeaders(
//                    new Header("Content-Type", "application/json; charset=utf-8"),
//                    new Header("Cache-Control", "public, max-age=86400"))
//                .withBody("{\n" +
//                    "    \"id\": 1,\n" +
//                    "    \"title\": \"Testing\",\n" +
//                    "    \"content\": \"A blog about Testing\"\n" +
//                    "}")
//        );
//
//  }
//
//  @AfterClass
//  public static void stopServer() {
//    mockServer.stop();
//  }
}
