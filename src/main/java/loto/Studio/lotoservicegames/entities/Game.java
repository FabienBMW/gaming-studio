package loto.Studio.lotoservicegames.entities;

import loto.Studio.lotoservicegames.enums.StatusGameEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;


@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "GAME_INTERFACE")
public class Game implements Serializable {
   public static final long serializableUID = 1l;

    @Id
    @Column(nullable = false, name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, name = "NAME")
    private String name;

    @Column(nullable = false, name = "CATHEGORIES")
    private String categories;

    @Column(nullable = true, name = "STATUS")
    @Enumerated(EnumType.STRING)
    private StatusGameEnum status;







}
