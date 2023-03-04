package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {
   @Autowired
   MovieRepository movieRepository;

   public String addMovie(Movie movie){
       return movieRepository.addMovie(movie);
   }

   public String addDirector(Director director){

       return movieRepository.addDirector(director);
   }

   public String addMovieDirectorPair(String movieName, String directorName){
       return movieRepository.addMovieDirectorPair(movieName,directorName);
   }

   public Movie getMovieByName(String MovieName){
       return movieRepository.getMovieByName(MovieName);
   }

   public Director getDirectorByName(String name){
       return movieRepository.getDirectorByName(name);
   }
   public List<String> getMoviesByDirectorName(String Director){
       return movieRepository.getMoviesByDirectorName(Director);
   }
   public List<String> findAllMovies(){
       return movieRepository.findAllMovies();
   }
   public String deleteDirectorByName(String name){
       return movieRepository.deleteDirectorByName(name);
   }
   public String deleteAllDirectors(){
       return movieRepository.deleteAllDirectors();
   }
}
