package dev.blasio99.untoldfestival.server.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;


@Entity
public class Concert extends BaseModel {
    
    private String performer;
	private String genre;
    private String title;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
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

	public LocalDateTime getStartDate() {
		return this.startDate;
	}

	public void setStartDate(LocalDateTime startDate) {
		this.startDate = startDate;
	}

	public LocalDateTime getEndDate() {
		return this.endDate;
	}

	public void setEndDate(LocalDateTime endDate) {
		this.endDate = endDate;
	}

	public Long getMaxNrOfTickets() {
		return this.maxNrOfTickets;
	}

	public void setMaxNrOfTickets(Long maxNrOfTickets) {
		this.maxNrOfTickets = maxNrOfTickets;
	}


}