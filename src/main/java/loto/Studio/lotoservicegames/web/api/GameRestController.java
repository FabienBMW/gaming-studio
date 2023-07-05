package loto.Studio.lotoservicegames.web.api;


import loto.Studio.lotoservicegames.dto.ResponseDto;
import loto.Studio.lotoservicegames.entities.Game;
import loto.Studio.lotoservicegames.enums.MessageEnum;
import loto.Studio.lotoservicegames.enums.StatusGameEnum;
import loto.Studio.lotoservicegames.exceptions.DAOException;
import loto.Studio.lotoservicegames.exceptions.FormValidationException;
import loto.Studio.lotoservicegames.service.impl.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@RestController
@RequestMapping(value = "api/game")
public class GameRestController {

    @Autowired
    private GameService gameService;

    @Autowired
    private MessageSource messageSource;

    /**
     * Create
     * @param game
     * @param locale
     * @return ResponseDto<Game>
     */
    @PostMapping
    public ResponseDto<Game> create (
            @RequestBody Game game,
            @RequestHeader(name = "Accept-Language", required = false)Locale locale){
    ResponseDto<Game> response= new ResponseDto<>();
        List<String> messages = new ArrayList<>();
        try{
            Game game1 = new Game();
            game1.getId();
            game1.getName();
            game1.getCategories();
            game1.getStatus();
            gameService.add(game1);
            response.setBody(game1);
        }catch (NullPointerException e) {
            messages.add(messageSource.getMessage(MessageEnum.NULLPOINTER_EXCEPTION, null, locale));
        } catch (DAOException e) {
            messages.add(messageSource.getMessage(MessageEnum.DAO_EXCEPTION, null, locale));
        }
        if(!messages.isEmpty()) response.setStatus(HttpStatus.BAD_REQUEST); else response.setStatus(HttpStatus.OK);
        response.setMessages(messages);
        return response;
    }

    /**
     * findGameById
     * @param idGame
     * @param locale
     * @return ResponseDto<Game>
     */
    @GetMapping("/idGame")
    public ResponseDto <Game> findGameById(
            @PathVariable("idGame") long idGame,
            @RequestHeader(name = "Accept-Language", required = false)Locale locale){
        ResponseDto<Game> response = new ResponseDto<>();
        List<String> messages = new ArrayList<>();
        try {
            response.setBody(gameService.findId(idGame));
        }catch (NullPointerException e) {
            messages.add(messageSource.getMessage(MessageEnum.NULLPOINTER_EXCEPTION, null, locale));
        } catch (DAOException e) {
            messages.add(messageSource.getMessage(MessageEnum.DAO_EXCEPTION, null, locale));
        } catch (FormValidationException e) {
            messages.add(messageSource.getMessage(e.getMessage(), null, locale));
        }
        if(!messages.isEmpty()) response.setStatus(HttpStatus.BAD_REQUEST); else response.setStatus(HttpStatus.OK);
        response.setMessages(messages);
        return response;
    }

    /**
     * findGame
     * @param locale
     * @return ResponseDto<List<Game>>
     */
    @GetMapping
    public ResponseDto<List<Game>> findGame(
            @RequestHeader(name = "Accept-Language", required = false) Locale locale){
        ResponseDto<List<Game>> response = new ResponseDto<>();
        List<String> messages = new ArrayList<>();
        try {
            response.setBody(this.gameService.getAll());
        }catch (NullPointerException e) {
            messages.add(messageSource.getMessage(MessageEnum.NULLPOINTER_EXCEPTION, null, locale));
        } catch (DAOException e) {
            messages.add(messageSource.getMessage(MessageEnum.DAO_EXCEPTION, null, locale));
        }
        if(!messages.isEmpty()) response.setStatus(HttpStatus.BAD_REQUEST); else response.setStatus(HttpStatus.OK);
        response.setMessages(messages);
        return response;
    }

    @PostMapping("/Desactive_Game")
    public ResponseDto<Game> update (
            @RequestBody long idGame,
            @RequestHeader (name = "Accept-Language", required = false) Locale locale){
        ResponseDto<Game> response= new ResponseDto<>();
        List<String> messages = new ArrayList<>();
        try {
            Game game = gameService.findId(idGame);
            game.setStatus(StatusGameEnum.UNENABLED);
            gameService.update(game);

            response.setBody(game);

        }catch (NullPointerException e) {
                messages.add(messageSource.getMessage(MessageEnum.NULLPOINTER_EXCEPTION, null, locale));
            } catch (DAOException e) {
                messages.add(messageSource.getMessage(MessageEnum.DAO_EXCEPTION, null, locale));
            } catch (FormValidationException e) {
                messages.add(messageSource.getMessage(e.getMessage(), null, locale));
            }
            if(!messages.isEmpty()) response.setStatus(HttpStatus.BAD_REQUEST); else response.setStatus(HttpStatus.OK);
            response.setMessages(messages);
            return response;

    }

}
