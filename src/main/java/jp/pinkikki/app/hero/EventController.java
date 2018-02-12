package jp.pinkikki.app.hero;

import jp.pinkikki.domain.hero.model.Event;
import jp.pinkikki.domain.hero.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("hero")
public class EventController {

    @Autowired
    EventService eventService;

    //@CrossOrigin(origins = "http://localhost:8080")
    @GetMapping(path = "findall")
    public List<Event> findAll() {
        return eventService.findAll();
    }

    @GetMapping(path = "find")
    public List<Event> findByExample()
    {
//        return eventService.findByExample(2, "kakaka");
        return eventService.findByTwoEventId();
    }


}
