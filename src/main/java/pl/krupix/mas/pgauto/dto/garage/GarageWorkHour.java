package pl.krupix.mas.pgauto.dto.garage;

import lombok.Data;

/**
 * Created by krupix on 02.02.2017.
 */
public class GarageWorkHour {

    private Days day;

    private Integer openHour;

    private Integer closeHour;

    public Days getDay() {
        return day;
    }

    public void setDay(Days day) {
        this.day = day;
    }

    public Integer getOpenHour() {
        return openHour;
    }

    public void setOpenHour(Integer openHour) {
        this.openHour = openHour;
    }

    public Integer getCloseHour() {
        return closeHour;
    }

    public void setCloseHour(Integer closeHour) {
        this.closeHour = closeHour;
    }
}
