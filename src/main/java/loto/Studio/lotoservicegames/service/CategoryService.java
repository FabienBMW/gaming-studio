package loto.Studio.lotoservicegames.service;

import loto.Studio.lotoservicegames.dto.CreateCategoryDto;
import loto.Studio.lotoservicegames.dto.ResponseDto;
import loto.Studio.lotoservicegames.entities.Category;
import loto.Studio.lotoservicegames.exceptions.DAOException;
import loto.Studio.lotoservicegames.exceptions.FormValidationException;
import loto.Studio.lotoservicegames.helper.request_settings.RequestResult;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;

@Service
public interface CategoryService {

    ResponseDto<List<Category>> getAll(Locale locale) throws DAOException;
    ResponseDto<Category> create (CreateCategoryDto dto, Locale locale) throws DAOException;
    ResponseDto<Category> delete(Long id, Locale locale) throws DAOException;
    ResponseDto<Category> findByName(String name, Locale locale);
    ResponseDto<Category> findId(Long id, Locale locale);
}
