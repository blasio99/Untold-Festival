package dev.blasio99.untoldfestival.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Ticket extends BaseModel {
    
    private Double price;
    @ManyToOne
    private Concert concert;
    private Long seats;

	public Double getPrice() {
		return this.price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Concert getConcert() {
		return this.concert;
	}

	public void setConcert(Concert concert) {
		this.concert = concert;
	}

	public Long getSeats() {
		return this.seats;
	}

	public void setSeats(Long seats) {
		this.seats = seats;
	}
}