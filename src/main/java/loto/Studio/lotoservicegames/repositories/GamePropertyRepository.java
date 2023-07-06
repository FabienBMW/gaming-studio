package loto.Studio.lotoservicegames.repositories;

import loto.Studio.lotoservicegames.entities.GameProperty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GamePropertyRepository extends JpaRepository<GameProperty, Long> {
}
