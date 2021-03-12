package dev.blasio99.untoldfestival.server.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
public class Concert extends BaseModel {
    
    private String performer;
	private String genre;
    private String title;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private Long maxNrOfTickets;

	public String getPerformer() {
		return this.performer;
	}

	public void setPerformer(String performer) {
		this.performer = performer;
	}

	public String getGenre() {
		return this.genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public LocalDateTime getStartTime() {
		return this.startTime;
	}

	public void setStartTime(LocalDateTime startTime) {
		this.startTime = startTime;
	}

	public LocalDateTime getEndTime() {
		return this.endTime;
	}

	public void setEndTime(LocalDateTime endTime) {
		this.endTime = endTime;
	}

	public Long getMaxNrOfTickets() {
		return this.maxNrOfTickets;
	}

	public void setMaxNrOfTickets(Long maxNrOfTickets) {
		this.maxNrOfTickets = maxNrOfTickets;
	}


}