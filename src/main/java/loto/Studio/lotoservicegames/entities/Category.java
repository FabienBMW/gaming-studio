package loto.Studio.lotoservicegames.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Category extends Auditable<String> {

    @Id
    @Column(name = "category_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", unique = true)
    private String name;

    @Lob
    @Column(name = "description")
    private String description;

    @Fetch(value = FetchMode.SELECT)
    @ManyToMany(fetch = FetchType.LAZY)
    private List<GainProperty> gainProperties;

    @Fetch(value = FetchMode.SELECT)
    @ManyToMany(fetch = FetchType.LAZY)
    private List<GameProperty> gameProperties;
}
