package dev.blasio99.untoldfestival.common.dto;

public class TicketDTO extends BaseDTO {
    
    private Double price;
    private Long concertId;
    private Long seats;

	public Double getPrice() {
		return this.price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Long getConcertId() {
		return this.concertId;
	}

	public void setConcertId(Long concertId) {
		this.concertId = concertId;
	}

	public Long getSeats() {
		return this.seats;
	}

	public void setSeats(Long seats) {
		this.seats = seats;
	}

    

}