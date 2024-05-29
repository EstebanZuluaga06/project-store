package co.uco.doo.store.api.infrastructure.entrypoints.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ObjectResponse<T> {
    private HeaderResponse header;
    private T data;

}
