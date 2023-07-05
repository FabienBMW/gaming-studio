package loto.Studio.lotoservicegames.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.ToString;

@Entity
@ToString
public class FreeGameGainProperty extends GainProperty{

    @Column(name = "number")
    private int number;
}
