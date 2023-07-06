package loto.Studio.lotoservicegames.repositories;

import loto.Studio.lotoservicegames.entities.GainProperty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GainPropertyRepository extends JpaRepository<GainProperty, Long> {
}
