package loto.Studio.lotoservicegames.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.ArrayList;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "gain_property")
@ToString
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class GainProperty {

    @Id
    @Column(name = "gain_property_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;
}
