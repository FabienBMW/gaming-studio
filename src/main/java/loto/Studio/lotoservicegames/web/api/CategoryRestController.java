package loto.Studio.lotoservicegames.web.api;

import loto.Studio.lotoservicegames.dto.CreateCategoryDto;
import loto.Studio.lotoservicegames.dto.ResponseDto;
import loto.Studio.lotoservicegames.entities.Category;
import loto.Studio.lotoservicegames.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Locale;

@RestController
@RequestMapping(value = "api/category")
public class CategoryRestController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping
    public ResponseDto<Category> create (
            @RequestBody CreateCategoryDto dto,
            @RequestHeader(name = "Accept-Language", required = false) Locale locale){
        return categoryService.create(dto, locale);
    }

    @GetMapping
    public ResponseDto<List<Category>> getAll (
            @RequestHeader(name = "Accept-Language", required = false) Locale locale){
        return categoryService.getAll(locale);
    }

    @GetMapping("/{id}")
    public ResponseDto<Category> FindById (
            @PathVariable("id") Long id,
            @RequestHeader(name = "Accept-Language", required = false) Locale locale) {
        return categoryService.findId(id, locale);
    }

    @DeleteMapping("/{id}")
    public ResponseDto<Category> delete (
            @PathVariable("id") Long id,
            @RequestHeader(name = "Accept-Language", required = false) Locale locale) {
        return categoryService.delete(id, locale);
    }
}
