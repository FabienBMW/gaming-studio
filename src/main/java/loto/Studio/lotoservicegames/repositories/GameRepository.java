package loto.Studio.lotoservicegames.repositories;

import loto.Studio.lotoservicegames.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(exported = false)
public interface GameRepository extends JpaRepository <Game, Long> {
}
