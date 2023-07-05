package loto.Studio.lotoservicegames.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "game_property")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class GameProperty extends Auditable<String>{

    @Id
    @Column(name = "gain_property_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;
}
