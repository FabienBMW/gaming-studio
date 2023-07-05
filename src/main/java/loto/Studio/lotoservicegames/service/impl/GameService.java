package loto.Studio.lotoservicegames.service.impl;


import loto.Studio.lotoservicegames.entities.Game;
import loto.Studio.lotoservicegames.enums.MessageEnum;
import loto.Studio.lotoservicegames.exceptions.DAOException;
import loto.Studio.lotoservicegames.exceptions.FormValidationException;
import loto.Studio.lotoservicegames.repositories.GameRepository;
import loto.Studio.lotoservicegames.service.GameIService;
import jakarta.persistence.NoResultException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class GameService implements GameIService {
    @Autowired
    private GameRepository repository;

    @Override
    public List<Game> getAll() throws DAOException {
        try {
            return repository.findAll();
        }catch (NoResultException e) {
            return new ArrayList<Game>();
        }catch (DAOException e) {
            throw new DAOException(e.getMessage());
        }
    }

    @Override
    public void add(Game entity) throws DAOException {
        try {
            repository.save(entity);
        }catch (DAOException e) {
            throw new DAOException(e.getMessage());
        }
    }

    @Override
    public void update(Game entity) throws DAOException {
            if( find(entity.getId()) !=null) {
                try {
                    repository.save(entity);
                }catch (DAOException e) {
                    throw new DAOException(e.getMessage());
                }
            }else {
                throw new DAOException(MessageEnum.ERROR_NOT_FOUND_OBJET) ;
            }
    }

    @Override
    public void delete(Long id) throws DAOException {
        if( find(id) !=null) {
            Game ctr = find(id);
            try {
                repository.delete(ctr);
            }catch (DAOException e) {
                throw new DAOException(e.getMessage());
            }
        }else {
            throw new DAOException(MessageEnum.ERROR_NOT_FOUND_OBJET);
        }
    }

    @Override
    public Game find(Long id) throws DAOException {
        if(id ==null) {
            throw new DAOException(MessageEnum.ERROR_NOT_FOUND_OBJET);
        }else {
            try {
                Optional<Game> game = repository.findById(id);
                return game.get();
            } catch (DAOException e) {
                throw new DAOException(e.getMessage());
            }catch (NoSuchElementException e) {
                return null;
            }
        }
    }

    @Override
    public void saveAll(Iterable<Game> iterable) throws DAOException {
        try {
            repository.saveAll(iterable);
        } catch (DAOException e) {
            throw new DAOException(e.getMessage());
        }
    }

    @Override
    public Game findId(Long id) throws FormValidationException {
        if (id != null) {
            if(find(id) != null) {
                return find(id);
            } else {
                throw new FormValidationException(MessageEnum.ERROR_NOT_FOUND_OBJET);
            }
        } else {
            throw new FormValidationException(MessageEnum.DAO_EXCEPTION);
        }
    }
}
