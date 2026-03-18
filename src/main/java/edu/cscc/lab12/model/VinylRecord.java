package edu.cscc.lab12.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.Range;

@Entity
public class VinylRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty(message = "Please enter a title.")
    @Size(max = 50, message = "Please enter a title that is no more than 50 characters in length.")
    private String title;

    @NotEmpty(message = "Please enter an artist.")
    @Size(max = 40, message = "Please enter an artist that is no more than 40 characters in length.")
    private String artist;

    @NotEmpty(message = "Please enter a label.")
    @Size(max = 40, message = "Please enter a label that is no more than 40 characters in length.")
    private String label;

    // MUST be yearReleased (not year)
    @Min(value = 1930, message = "Please enter a year released that is on or after 1930.")
    private int yearReleased;

    @Range(min = 1, max = 20, message = "Please enter a number of tracks that is between 1 and 20.")
    private int numberOfTracks;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "Please select a size.")
    private RecordSize size;

    private boolean damaged;

    public VinylRecord() {}

    public Long getId() {
        return id;
    }

    // Title
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    // Artist
    public String getArtist() {
        return artist;
    }
    public void setArtist(String artist) {
        this.artist = artist;
    }

    // Label
    public String getLabel() {
        return label;
    }
    public void setLabel(String label) {
        this.label = label;
    }

    // Year Released
    public int getYearReleased() {
        return yearReleased;
    }
    public void setYearReleased(int yearReleased) {
        this.yearReleased = yearReleased;
    }

    // Tracks
    public int getNumberOfTracks() {
        return numberOfTracks;
    }
    public void setNumberOfTracks(int numberOfTracks) {
        this.numberOfTracks = numberOfTracks;
    }

    // Size
    public RecordSize getSize() {
        return size;
    }
    public void setSize(RecordSize size) {
        this.size = size;
    }

    // Damaged
    public boolean isDamaged() {
        return damaged;
    }
    public void setDamaged(boolean damaged) {
        this.damaged = damaged;
    }
}
