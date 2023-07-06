package loto.Studio.lotoservicegames.service.impl;

import loto.Studio.lotoservicegames.dto.ResponseDto;
import loto.Studio.lotoservicegames.entities.GainProperty;
import loto.Studio.lotoservicegames.exceptions.DAOException;
import loto.Studio.lotoservicegames.service.GainPropertyService;

import java.util.List;
import java.util.Locale;

public class GainPropertyServiceImpl implements GainPropertyService {
    @Override
    public ResponseDto<List<GainProperty>> getAll(Locale locale) throws DAOException {
        return null;
    }

    @Override
    public ResponseDto<GainProperty> create(GainProperty dto, Locale locale) throws DAOException {
        return null;
    }

    @Override
    public ResponseDto<GainProperty> delete(Long id, Locale locale) throws DAOException {
        return null;
    }

    @Override
    public ResponseDto<GainProperty> findByName(String name, Locale locale) {
        return null;
    }

    @Override
    public ResponseDto<GainProperty> findId(Long id, Locale locale) {
        return null;
    }
}
