package jp.pinkikki.domain.hero.service;

import jp.pinkikki.domain.hero.mapper.EventMapper;
import jp.pinkikki.domain.hero.model.Event;
import jp.pinkikki.domain.hero.model.EventExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class EventService {

    final EventMapper eventMapper;

    public EventService(EventMapper eventMapper) {
        this.eventMapper = eventMapper;
    }

    public List<Event> findAll() {
        return eventMapper.selectByExample(null);
    }

    public List<Event> findByExample(int eventId, String objectName) {
        EventExample eventExample = new EventExample();
        eventExample
                .createCriteria()
                .andEventIdEqualTo(eventId)
                .andObjectNameEqualTo(objectName);

        return eventMapper.selectByExample(eventExample);
    }

    public List<Event> findByTwoEventId(int eventId) {
        EventExample eventExample = new EventExample();
        eventExample
                .createCriteria()
                .andEventIdEqualTo(eventId);
//        eventExample
//                .or()
//                .andEventIdEqualTo(2);

        return eventMapper.selectByExample(eventExample);
    }
}
