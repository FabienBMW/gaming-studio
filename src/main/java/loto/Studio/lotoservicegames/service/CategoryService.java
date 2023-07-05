package loto.Studio.lotoservicegames.service;

import loto.Studio.lotoservicegames.dto.CreateCategoryDto;
import loto.Studio.lotoservicegames.entities.Category;
import loto.Studio.lotoservicegames.helper.request_settings.RequestResult;
import org.springframework.stereotype.Service;

@Service
public interface CategoryService {

    RequestResult<Category> create(CreateCategoryDto dto);
}
