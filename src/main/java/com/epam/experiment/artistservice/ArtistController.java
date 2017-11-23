package com.epam.experiment.artistservice;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import lombok.Data;

@RestController
public class ArtistController {

    List<Artist> artistMap = Arrays.asList(
            new Artist("ledzeppelin", "Led Zeppelin", "Hard rock"),
            new Artist("beatles", "The Beatles", "Rock/pop"),
            new Artist("gnr", "Guns n Roses", "Hard rock"));


    @RequestMapping("/artist/{id}")
    public Artist getArtist(@PathVariable String id, @RequestParam(defaultValue = "1000") int latency) throws InterruptedException {
        Thread.sleep(latency);
        return artistMap.stream()
                .filter(artist -> artist.getId().equals(id))
                .findFirst().orElse(null);
    }
}

@Data
@AllArgsConstructor
class Artist {
    private String id;
    private String name;
    private String genre;
}
