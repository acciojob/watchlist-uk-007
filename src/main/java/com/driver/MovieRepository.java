package com.driver;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.sql.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class MovieRepository {
    Map<String,Movie> movieMap = new HashMap<>();
    Map<String,Director> directorMap = new HashMap<>();
    Map<String, List<String>> pairMap = new HashMap<>();  //directorname-moviename

    public String addMovie(Movie movie){
        String name = movie.getName();
        if(!movieMap.containsKey(name)){
            movieMap.put(name,movie);
        }
        return "Movie added successfully";
    }
    public String addDirector(Director director){
        String name = director.getName();
        if(!directorMap.containsKey(name)){
            directorMap.put(name,director);
        }
        return "Director added successfully";
    }
    //3 Pair an existing movie and director
    public String addMovieDirectorPair(String movieName, String directorName){
        if(!movieMap.containsKey(movieName) || !directorMap.containsKey(directorName)){
            return "Movie or Director not found in our database";
        }
        if(pairMap.containsKey(directorName)){
            pairMap.get(directorName).add(movieName);
        }else{
            List<String> ans = new ArrayList<>();
            ans.add(movieName);
            pairMap.put(directorName,ans);
        }
        return "Movie-Director Pair added successfully";

    }
    public Movie getMovieByName(String movieName){
        if(!movieMap.containsKey(movieName)){
            return null;
        }
        return movieMap.get(movieName);

    }
    public Director getDirectorByName(String name){
        if(!directorMap.containsKey(name)){
            return null;
        }
        return directorMap.get(name);
    }
    public List<String> getMoviesByDirectorName(String director){
        if(!pairMap.containsKey(director)){
            return null;
        }
        return pairMap.get(director);
    }
    public List<String> findAllMovies(){
        List<String> ans = new ArrayList<>();
        for(String movie : movieMap.keySet()){
            ans.add(movie);
        }
        return ans;
    }
    public String deleteDirectorByName(String name){
        List<String> movies = pairMap.get(name);
        for(int i=0; i<movies.size(); i++){
            if(movieMap.containsKey(movies.get(i))){
                movieMap.remove(movies.get(i));
            }

        }
        pairMap.remove(name);
        if(directorMap.containsKey(name)){
            directorMap.remove(name);
        }
        return "Director and its movies removed successfully";


    }
    public String deleteAllDirectors(){
        for(String dir: pairMap.keySet()) {
            List<String> lis = pairMap.get(dir);
            for (String name : lis) {
                if (movieMap.containsKey(name)) {
                    movieMap.remove(name);
                }
            }
            directorMap.remove(dir);
        }
        for(String d: directorMap.keySet()){
            directorMap.remove(d);
        }
        return "All directors and all of their movies removed successfully";



    }


}
