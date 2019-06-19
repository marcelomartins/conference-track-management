package app.domain;

import java.time.LocalTime;

/**
 * Talk Object
 *
 * @author Marcelo Martins on 23/03/2017
 */
public class Talk {

    private String name;
    private Integer duration;
    private LocalTime time;

    public Talk(String name, Integer duration) {
        this.name = name;
        this.duration = duration;
    }

    public Talk(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Integer getDuration() {
       return duration;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public LocalTime getTime() {
        return this.time;
    }


}
