package loto.Studio.lotoservicegames.service.impl;

import loto.Studio.lotoservicegames.config.exception.ApiException;
import loto.Studio.lotoservicegames.config.exception.ValueAlreadyExistsException;
import loto.Studio.lotoservicegames.dto.CreateCategoryDto;
import loto.Studio.lotoservicegames.entities.Category;
import loto.Studio.lotoservicegames.helper.request_settings.RequestResult;
import loto.Studio.lotoservicegames.repositories.CategoryRepository;
import loto.Studio.lotoservicegames.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository repository;

    @Override
    public RequestResult<Category> create(CreateCategoryDto dto) {
        if (repository.findByName(dto.getName()).isPresent())
            throw new ValueAlreadyExistsException();
        return null;
    }
}
