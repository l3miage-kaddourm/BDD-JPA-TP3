package fr.uga.l3miage.tp3.exo1.components;

import fr.uga.l3miage.tp3.exo1.enums.GenreMusical;
import fr.uga.l3miage.tp3.exo1.models.AlbumEntity;
import fr.uga.l3miage.tp3.exo1.models.ArtistEntity;
import fr.uga.l3miage.tp3.exo1.repositories.ArtistRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
@RequiredArgsConstructor
public class ArtistComponent {

    private final ArtistRepository artistRepository;

    // READ

    private ArtistEntity getArtist(String name){
        return artistRepository
                .findById(name)
                .orElseThrow();
    }

    // CREATE

    public ArtistEntity createArtist(ArtistEntity artistEntity) {
        return artistRepository.save(artistEntity);
    }

    // UPDATE

    private ArtistEntity updateArtisteBiography(String name,String newBiography) {
        ArtistEntity artistEntity = artistRepository
                .findById(name)
                .orElseThrow();
        artistEntity.setBiography(newBiography);
        return artistRepository.save(artistEntity);
    }

    // DELETE
    public void deleteArtist(String name){
        artistRepository.deleteById(name);
    }


    //

    public ArtistEntity findArtistEntityByAlbumEntities(Set<AlbumEntity> albumEntities) {
        return artistRepository.findArtistEntityByAlbumEntities(albumEntities);
    }
}