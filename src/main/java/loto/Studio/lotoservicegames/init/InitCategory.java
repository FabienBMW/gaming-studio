package loto.Studio.lotoservicegames.init;

import lombok.AllArgsConstructor;
import loto.Studio.lotoservicegames.dto.CreateCategoryDto;
import loto.Studio.lotoservicegames.entities.Category;
import loto.Studio.lotoservicegames.enums.CathegoryEnum;
import loto.Studio.lotoservicegames.service.CategoryService;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
@AllArgsConstructor
public class InitCategory implements ApplicationRunner {
    private CategoryService categoryService;
    @Override
    public void run(ApplicationArguments args) throws Exception {

        Locale locale = Locale.UK;
        Category pick3 = categoryService.findByName(CathegoryEnum.CATHEGORIE_PICK3, locale).getBody();
        Category scratch = categoryService.findByName(CathegoryEnum.CATHEGORIE_SCRATCH_CARD, locale).getBody();
        Category _5_90 = categoryService.findByName(CathegoryEnum.CATHEGORIE_5_90, locale).getBody();

        if (pick3 == null) categoryService.create(new CreateCategoryDto(CathegoryEnum.CATHEGORIE_PICK3, "jeu de type Pick 3",null,null), locale);
        if (scratch == null) categoryService.create(new CreateCategoryDto(CathegoryEnum.CATHEGORIE_SCRATCH_CARD, "jeu de type Scratch card",null,null), locale);
        if (_5_90 == null) categoryService.create(new CreateCategoryDto(CathegoryEnum.CATHEGORIE_5_90, "jeu de type 5/90",null,null), locale);

    }
}
