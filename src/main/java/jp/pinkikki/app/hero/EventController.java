package jp.pinkikki.app.hero;

import jp.pinkikki.domain.hero.model.Event;
import jp.pinkikki.domain.hero.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

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
    public List<Event> findByExample(@Validated EventForm eventForm) {
        return eventService.findByTwoEventId(eventForm.getEventId());
    }

    @GetMapping(path = "find/{eventId}")
    public List<Event> findByEventId(@Validated EventForm eventForm) {
        return eventService.findByTwoEventId(eventForm.getEventId());
    }

    @PostMapping(path = "upload")
    public ResponseEntity<byte[]> upload(@RequestParam("file") MultipartFile file) throws IOException {
        return ResponseEntity
                .ok()
                .header(HttpHeaders.CONTENT_DISPOSITION,
                        "attachment; filename=\"" + file.getOriginalFilename() + "\"")
                .body(file.getBytes());
    }

    @PostMapping(path = "upload2")
    public void upload(@RequestParam("file") MultipartFile file, HttpServletResponse response) throws IOException {
        response.setHeader("Content-Disposition",
                "attachment; filename=\"" + file.getOriginalFilename() + "\"");
        FileCopyUtils.copy(file.getInputStream(), response.getOutputStream());
    }
}
