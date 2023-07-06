package loto.Studio.lotoservicegames.service;

import loto.Studio.lotoservicegames.dto.CreateCategoryDto;
import loto.Studio.lotoservicegames.dto.ResponseDto;
import loto.Studio.lotoservicegames.entities.Category;
import loto.Studio.lotoservicegames.entities.GainProperty;
import loto.Studio.lotoservicegames.exceptions.DAOException;

import java.util.List;
import java.util.Locale;

public interface GainPropertyService {
    ResponseDto<List<GainProperty>> getAll(Locale locale) throws DAOException;
    ResponseDto<GainProperty> create (GainProperty dto, Locale locale) throws DAOException;
    ResponseDto<GainProperty> delete(Long id, Locale locale) throws DAOException;
    ResponseDto<GainProperty> findByName(String name, Locale locale);
    ResponseDto<GainProperty> findId(Long id, Locale locale);
}
