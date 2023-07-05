package loto.Studio.lotoservicegames.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import loto.Studio.lotoservicegames.entities.GainProperty;
import loto.Studio.lotoservicegames.entities.GameProperty;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCategoryDto {

    private String name;
    private String description;
    private List<GainProperty> gainProperties;
    private List<GameProperty> gameProperties;
}
