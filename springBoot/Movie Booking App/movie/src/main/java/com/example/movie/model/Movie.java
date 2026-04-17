package com.example.movie.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name="movie")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int movieId;
    String movieName;
    double price;
    int seats;
    
    public Movie() {
    }

    public Movie(String movieName, double price, int seats) {
        this.movieName = movieName;
        this.price = price;
        this.seats = seats;
    }

    public Movie(int movieId, String movieName, double price, int seats) {
        this.movieId = movieId;
        this.movieName = movieName;
        this.price = price;
        this.seats = seats;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    @Override
    public String toString() {
        return "Movie [movieId=" + movieId + ", movieName=" + movieName + ", price=" + price + ", seats=" + seats + "]";
    }

    
    

   

}
