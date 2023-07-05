package loto.Studio.lotoservicegames.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MultiplierGainProperty extends GainProperty{

    @Column(name = "multiplier")
    private Double multiplier;
}
