package co.uco.doo.store.api.infrastructure.entrypoints.dtos;

import lombok.Data;

import java.util.Date;
import java.util.UUID;
@Data
public class HeaderResponse {
    private String id;
    private String applicationName;
    private Date date;
    private int httpCode;
    private String httpDescription;

    public HeaderResponse(int httpCode, String httpDescription) {
        this.id= UUID.randomUUID().toString();
        this.applicationName="task-manager-api";
        date=new Date();
        this.httpCode = httpCode;
        this.httpDescription = httpDescription;
    }

}
