package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {
    @Autowired
    MovieService movieService;


    //1 add movie
    @PostMapping("/add-movie")
    public ResponseEntity addMovie(@RequestBody Movie movie){
        String res = movieService.addMovie(movie);
        return new ResponseEntity<>(res, HttpStatus.CREATED);
    }

    //2 add a director
    @PostMapping("/add-director")
    public ResponseEntity addDirector(@RequestBody Director director){
        String res = movieService.addDirector(director);
        return new ResponseEntity<>(res,HttpStatus.CREATED);
    }

    @PutMapping("/add-movie-director-pair")
    public ResponseEntity addMovieDirectorPair(@RequestParam("movieName") String movieName, @RequestParam("directorName") String directorName){
        String res = movieService.addMovieDirectorPair(movieName,directorName);
        return new ResponseEntity<>(res,HttpStatus.CREATED);

    }
    //4 get movie by movie name
    @GetMapping("/get-movie-by-name/{name}")
    public ResponseEntity getMovieByName(@PathVariable("name") String movieName){
        Movie movie = movieService.getMovieByName(movieName);
        return new ResponseEntity<>(movie,HttpStatus.FOUND);
    }
    //5 get director by director name
    @GetMapping("/get-director-by-name/{name}")
    public ResponseEntity getDirectorByName(@PathVariable("name") String name){
        Director dir = movieService.getDirectorByName(name);
        return new ResponseEntity<>(dir,HttpStatus.FOUND);
    }

    //6 get list of movies for given director name
    @GetMapping("/get-movies-by-director-name/{director}")
    public ResponseEntity getMoviesByDirectorName(@PathVariable("director") String director){
        List<String> list = movieService.getMoviesByDirectorName(director);
        return  new ResponseEntity<>(list,HttpStatus.FOUND);

    }
    //7 get list of all movies added
    @GetMapping("/get-all-movies")
    public ResponseEntity findAllMovies(){
        List<String> list = movieService.findAllMovies();
        return new ResponseEntity<>(list,HttpStatus.FOUND);
    }
    //8 delete director and its movies from record
    @DeleteMapping("/delete-director-by-name")
    public ResponseEntity deleteDirectorByName(@RequestParam("name") String name){
        String res = movieService.deleteDirectorByName(name);
        return new ResponseEntity(res,HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/delete-all-directors")
    public ResponseEntity deleteAllDirectors(){
        String res = movieService.deleteAllDirectors();
        return new ResponseEntity<>(res,HttpStatus.ACCEPTED);
    }



}
