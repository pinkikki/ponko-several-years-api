package jp.pinkikki.app.hero;

import jp.pinkikki.domain.hero.model.Event;
import jp.pinkikki.domain.hero.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Map;

//@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("hero")
public class EventController {

    @Autowired
    EventService eventService;

    @ModelAttribute
    public EventForm setupForm() {
        return new EventForm();
    }

    //@CrossOrigin(origins = "http://localhost:8080")
    @GetMapping(path = "findall")
    public List<Event> findAll() {
        return eventService.findAll();
    }

    @GetMapping(path = "find")
    public List<Event> findByExample(@Validated EventForm eventForm)
    {
        return eventService.findByTwoEventId(eventForm.getEventId());
    }

    @GetMapping(path = "find/{eventId}")
    public List<Event> findByEventId(@Validated EventForm eventForm)
    {
        return eventService.findByTwoEventId(eventForm.getEventId());
    }
}
