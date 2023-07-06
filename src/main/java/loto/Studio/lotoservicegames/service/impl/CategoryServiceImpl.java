package loto.Studio.lotoservicegames.service.impl;

import loto.Studio.lotoservicegames.config.exception.ApiException;
import loto.Studio.lotoservicegames.config.exception.ValueAlreadyExistsException;
import loto.Studio.lotoservicegames.dto.CreateCategoryDto;
import loto.Studio.lotoservicegames.dto.ResponseDto;
import loto.Studio.lotoservicegames.entities.Category;
import loto.Studio.lotoservicegames.exceptions.DAOException;
import loto.Studio.lotoservicegames.exceptions.FormValidationException;
import loto.Studio.lotoservicegames.helper.request_settings.RequestResult;
import loto.Studio.lotoservicegames.repositories.CategoryRepository;
import loto.Studio.lotoservicegames.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

@Component
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository repository;


    @Override
    public ResponseDto<List<Category>> getAll(Locale locale) throws DAOException {
        ResponseDto<List<Category>> response = new ResponseDto<>();
        List<String> messages = new ArrayList<>();
        try{
            List<Category> categoryList = repository.findAll();
            response.setBody(categoryList);
        }catch (DAOException e){
            messages.add(e.getMessage());
            throw new DAOException(e);
        }
        if(!messages.isEmpty()) response.setStatus(HttpStatus.BAD_REQUEST); else response.setStatus(HttpStatus.OK);
        response.setMessages(messages);
        return response;
    }

    @Override
    public ResponseDto<Category> create(CreateCategoryDto dto, Locale locale) throws DAOException {
        ResponseDto<Category> response = new ResponseDto<>();
        List<String> messages = new ArrayList<>();
        if (repository.findByName(dto.getName()).isPresent()){
            messages.add("VALUE ALREADY EXISTS IN DATABASE");
            throw new ValueAlreadyExistsException();
        }else{
            Category categoryToSave = new Category();
            categoryToSave = Category.builder()
                    .name(dto.getName())
                    .description(dto.getDescription())
                    .gameProperties(dto.getGameProperties())
                    .gainProperties(dto.getGainProperties())
                    .build();
            Category category = repository.save(categoryToSave);
            if (category.getId() == null){
                messages.add("Value was not registered successfully");
                throw new DAOException("Value was not registered successfully", HttpStatus.INTERNAL_SERVER_ERROR );
            }else {
                response.setBody(category);
                if(!messages.isEmpty()) response.setStatus(HttpStatus.BAD_REQUEST); else response.setStatus(HttpStatus.OK);
                response.setMessages(messages);
                return response;
            }
        }
    }

    @Override
    public ResponseDto<Category> delete(Long id, Locale locale) throws DAOException {
        ResponseDto<Category> response = new ResponseDto<>();
        List<String> messages = new ArrayList<>();
        try{
            Optional<Category> category = repository.findById(id);
            if (category.isPresent()){
                repository.delete(category.get());
                response.setBody(category.get());
            }else {
                messages.add("Value was not registered in Database");
                return null;
            }
        }catch (DAOException e){
            messages.add(e.getMessage());
            throw new DAOException(e);
        }
        if(!messages.isEmpty()) response.setStatus(HttpStatus.BAD_REQUEST); else response.setStatus(HttpStatus.OK);
        response.setMessages(messages);
        return response;
    }

    @Override
    public ResponseDto<Category> findByName(String name, Locale locale) {
        ResponseDto<Category> response = new ResponseDto<>();
        List<String> messages = new ArrayList<>();
        try{
            Optional<Category> category = repository.findByName(name);
            if (category.isPresent()){
                response.setBody(category.get());
            }else {
                //Value was not registered in Database
                response.setBody(null);
            }
        }catch (DAOException e){
            messages.add(e.getMessage());
            throw new DAOException(e);
        }
        if(!messages.isEmpty()) response.setStatus(HttpStatus.BAD_REQUEST); else response.setStatus(HttpStatus.OK);
        response.setMessages(messages);
        return response;
    }

    @Override
    public ResponseDto<Category> findId(Long id, Locale locale)  {
        ResponseDto<Category> response = new ResponseDto<>();
        List<String> messages = new ArrayList<>();
        try{
            Optional<Category> category = repository.findById(id);
            if (category.isPresent()){
                response.setBody(category.get());
            }else {
                //Value was not registered in Database
                response.setBody(null);
            }
        }catch (DAOException e){
            messages.add(e.getMessage());
            throw new DAOException(e);
        }
        if(!messages.isEmpty()) response.setStatus(HttpStatus.BAD_REQUEST); else response.setStatus(HttpStatus.OK);
        response.setMessages(messages);
        return response;
    }


}
