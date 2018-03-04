package jp.pinkikki.app.hero;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class EventForm implements Serializable {

    @NotNull
    @Max(100)
    private Integer eventId;

}
