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

    @Autowired
    EventMapper eventMapper;

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

    public List<Event> findByTwoEventId() {
        EventExample eventExample = new EventExample();
        eventExample
                .createCriteria()
                .andEventIdEqualTo(1);
        eventExample
                .or()
                .andEventIdEqualTo(2);

        return eventMapper.selectByExample(eventExample);
    }
}
