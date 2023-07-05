package loto.Studio.lotoservicegames.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.ArrayList;

@EqualsAndHashCode(callSuper = true)
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Category extends Auditable<String> {

    @Id
    @Column(name = "category_id")
    private long id;

    @Column(name = "name", unique = true)
    private String name;

    @Lob
    @Column(name = "description")
    private String description;

    @Fetch(value = FetchMode.SELECT)
    @ManyToMany(fetch = FetchType.LAZY)
    private ArrayList<GainProperty> gainProperties;

    @Fetch(value = FetchMode.SELECT)
    @ManyToMany(fetch = FetchType.LAZY)
    private ArrayList<GameProperty> gameProperties;
}
