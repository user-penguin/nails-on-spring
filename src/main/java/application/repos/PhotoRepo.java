package application.repos;

import application.entities.Photo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhotoRepo extends JpaRepository<Photo, Integer> {
    Photo findPhotoByName(String name);
}
