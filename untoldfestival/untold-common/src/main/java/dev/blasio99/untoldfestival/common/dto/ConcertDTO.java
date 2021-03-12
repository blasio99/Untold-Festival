package dev.blasio99.untoldfestival.common.dto;

public class ConcertDTO extends BaseDTO{
    
    private String performer;
	private String genre;
    private String title;
    private String startDate;
    private String endDate;
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

	public String getStartDate() {
		return this.startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return this.endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public Long getMaxNrOfTickets() {
		return this.maxNrOfTickets;
	}

	public void setMaxNrOfTickets(Long maxNrOfTickets) {
		this.maxNrOfTickets = maxNrOfTickets;
	}

    

}