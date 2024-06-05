package Entities;

public class Song {

    private String spotifyId;
    private String name;
    private String artists;
    private int dailyRank;
    private int dailyMovement;
    private int weeklyMovement;
    private String country;
    private String snapshotDate;
    private float tempo;


    // Constructor
    public Song(String spotifyId, String name, String artists, int dailyRank, int dailyMovement, int weeklyMovement,
                String country, String snapshotDate, float tempo) {
        this.spotifyId = spotifyId;
        this.name = name;
        this.artists = artists;
        this.dailyRank = dailyRank;
        this.dailyMovement = dailyMovement;
        this.weeklyMovement = weeklyMovement;
        this.country = country;
        this.snapshotDate = snapshotDate;
        this.tempo = tempo;
    }

    // Getters and Setters


    public String getSpotifyId() {
        return spotifyId;
    }

    public String getName() {
        return name;
    }

    public String getArtists() {
        return artists;
    }

    public int getDailyRank() {
        return dailyRank;
    }

    public int getDailyMovement() {
        return dailyMovement;
    }

    public int getWeeklyMovement() {
        return weeklyMovement;
    }

    public String getCountry() {
        return country;
    }

    public String getSnapshotDate() {
        return snapshotDate;
    }

    public float getTempo() {
        return tempo;
    }
}
