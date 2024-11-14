package com.backend.chorus.Services;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.net.URLEncoder;
import com.backend.chorus.Entity.Song;

@Component
public class ITunesSearch {

    public List<Song> searchSong(String searchTerm) {
         try {
            // Create RestTemplate instance
            RestTemplate restTemplate = new RestTemplate();

            // Properly encode the search term
            String encodedSearchTerm = URLEncoder.encode(searchTerm, StandardCharsets.UTF_8.toString());

            // Define the iTunes API URL with the encoded search term
            String url = "https://itunes.apple.com/search?term=" + encodedSearchTerm + "&media=music&entity=song&limit=12&country=in";

            // Make the GET request and get the response as a String
            ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
            
            // Parse the response JSON
            ObjectMapper mapper = new ObjectMapper();
            JsonNode root = mapper.readTree(response.getBody());

            // Extract the "results" array
            JsonNode results = root.path("results");

            // Create a list to store Song objects
            List<Song> songs = new ArrayList<Song>();

            // Loop through the results and extract the required fields
            for (JsonNode result : results) {
                String prevUrl = result.path("previewUrl").asText();
                String songName = result.path("trackName").asText();
                String artistName = result.path("artistName").asText();
                String thumbUrl = result.path("artworkUrl100").asText(); // Thumbnail image
                Long id = Long.parseLong(result.path("trackId").asText());
                String movieName= result.path("collectionName").asText();

                // Create a Song object and add it to the list
                Song objSong=new Song(id,prevUrl,thumbUrl,artistName,songName,movieName);
                songs.add(objSong);
            }

            return songs;

        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

}
