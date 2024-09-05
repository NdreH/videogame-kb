package dev.andrelopes.videogamekb.videogame_kb.model;

/**
 * @author <a href="mailto:<andre.matos.lopes@xpand-it.com>"><Andre Lopes></a>
 * @version $Revision: 666 $
 */

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDate;

@Entity
public class VideoGame {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name, category, genre, platform, developer, publisher, description;
  private int pegiRating;
  private double netRevenue, rating;
  private long copiesSold;

  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
  private LocalDate releaseDate;

  public VideoGame(){

  }

  private VideoGame(Builder builder) {
    this.name = builder.name;
    this.category = builder.category;
    this.genre = builder.genre;
    this.platform = builder.platform;
    this.developer = builder.developer;
    this.publisher = builder.publisher;
    this.description = builder.description;
    this.pegiRating = builder.pegiRating;
    this.netRevenue = builder.netRevenue;
    this.rating = builder.rating;
    this.copiesSold = builder.copiesSold;
    this.releaseDate = builder.releaseDate;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  public String getGenre() {
    return genre;
  }

  public void setGenre(String genre) {
    this.genre = genre;
  }

  public String getPlatform() {
    return platform;
  }

  public void setPlatform(String platform) {
    this.platform = platform;
  }

  public int getPegiRating() {
    return pegiRating;
  }

  public void setPegiRating(int pegiRating) {
    this.pegiRating = pegiRating;
  }

  public double getNetRevenue() {
    return netRevenue;
  }

  public void setNetRevenue(double netRevenue) {
    this.netRevenue = netRevenue;
  }

  public long getCopiesSold() {
    return copiesSold;
  }

  public void setCopiesSold(long copiesSold) {
    this.copiesSold = copiesSold;
  }

  public String getDeveloper() {
    return developer;
  }

  public void setDeveloper(String developer) {
    this.developer = developer;
  }

  public String getPublisher() {
    return publisher;
  }

  public void setPublisher(String publisher) {
    this.publisher = publisher;
  }

  public LocalDate getReleaseDate() {
    return releaseDate;
  }

  public void setReleaseDate(LocalDate releaseDate) {
    this.releaseDate = releaseDate;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public double getRating() {
    return rating;
  }

  public void setRating(double rating) {
    this.rating = rating;
  }

  public void setProperties(VideoGame other) {
    if (other.getName() != null) {
      this.setName(other.getName());
    }
    if (other.getCategory() != null) {
      this.setCategory(other.getCategory());
    }
    if (other.getGenre() != null) {
      this.setGenre(other.getGenre());
    }
    if (other.getPlatform() != null) {
      this.setPlatform(other.getPlatform());
    }
    if (other.getDeveloper() != null) {
      this.setDeveloper(other.getDeveloper());
    }
    if (other.getPublisher() != null) {
      this.setPublisher(other.getPublisher());
    }
    if (other.getDescription() != null) {
      this.setDescription(other.getDescription());
    }
    if (other.getPegiRating() != 0) {
      this.setPegiRating(other.getPegiRating());
    }
    if (other.getNetRevenue() != 0.0) {
      this.setNetRevenue(other.getNetRevenue());
    }
    if (other.getRating() != 0.0) {
      this.setRating(other.getRating());
    }
    if (other.getCopiesSold() != 0L) {
      this.setCopiesSold(other.getCopiesSold());
    }
    if (other.getReleaseDate() != null) {
      this.setReleaseDate(other.getReleaseDate());
    }
  }

  @Override
  public String toString() {
    return "VideoGame{" +
        "name='" + name + '\'' +
        ", category='" + category + '\'' +
        ", genre='" + genre + '\'' +
        ", platform='" + platform + '\'' +
        ", developer='" + developer + '\'' +
        ", publisher='" + publisher + '\'' +
        ", description='" + description + '\'' +
        ", pegiRating=" + pegiRating +
        ", netRevenue=" + netRevenue +
        ", rating=" + rating +
        ", copiesSold=" + copiesSold +
        ", releaseDate=" + releaseDate +
        '}';
  }

  public static class Builder {
    // Required parameters
    private final String name;
    private final String category;
    private final String genre;

    // Optional parameters with default values
    private String platform = "Unknown";
    private String developer = "Unknown";
    private String publisher = "Unknown";
    private String description = "No description";
    private int pegiRating = 0;
    private double netRevenue = 0.0;
    private double rating = 0.0;
    private long copiesSold = 0L;
    private LocalDate releaseDate = LocalDate.now();

    public Builder(String name, String category, String genre) {
      this.name = name;
      this.category = category;
      this.genre = genre;
    }

    public Builder platform(String platform) {
      this.platform = platform;
      return this;
    }

    public Builder developer(String developer) {
      this.developer = developer;
      return this;
    }

    public Builder publisher(String publisher) {
      this.publisher = publisher;
      return this;
    }

    public Builder description(String description) {
      this.description = description;
      return this;
    }

    public Builder pegiRating(int pegiRating) {
      this.pegiRating = pegiRating;
      return this;
    }

    public Builder netRevenue(double netRevenue) {
      this.netRevenue = netRevenue;
      return this;
    }

    public Builder rating(double rating) {
      this.rating = rating;
      return this;
    }

    public Builder copiesSold(long copiesSold) {
      this.copiesSold = copiesSold;
      return this;
    }

    public Builder releaseDate(LocalDate releaseDate) {
      this.releaseDate = releaseDate;
      return this;
    }

    public VideoGame build() {
      return new VideoGame(this);
    }
  }
}
