package loto.Studio.lotoservicegames.service;

import loto.Studio.lotoservicegames.dto.ResponseDto;
import loto.Studio.lotoservicegames.entities.GainProperty;
import loto.Studio.lotoservicegames.entities.GameProperty;
import loto.Studio.lotoservicegames.exceptions.DAOException;

import java.util.List;
import java.util.Locale;

public interface GamePropertyService {
    ResponseDto<List<GameProperty>> getAll(Locale locale) throws DAOException;
    ResponseDto<GameProperty> create (GameProperty dto, Locale locale) throws DAOException;
    ResponseDto<GameProperty> delete(Long id, Locale locale) throws DAOException;
    ResponseDto<GameProperty> findByName(String name, Locale locale);
    ResponseDto<GameProperty> findId(Long id, Locale locale);
}
