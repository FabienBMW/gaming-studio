package loto.Studio.lotoservicegames.web.api;

import loto.Studio.lotoservicegames.dto.CreateCategoryDto;
import loto.Studio.lotoservicegames.entities.Category;
import loto.Studio.lotoservicegames.helper.request_settings.RequestResult;
import loto.Studio.lotoservicegames.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api/category")
public class CategoryRestController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping
    public RequestResult<Category> createCategory(@RequestBody CreateCategoryDto dto) {
        return categoryService.create(dto);
    }
}
