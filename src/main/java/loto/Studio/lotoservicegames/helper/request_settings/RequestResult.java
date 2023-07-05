package loto.Studio.lotoservicegames.helper.request_settings;

import lombok.AllArgsConstructor;

import java.util.Date;

@AllArgsConstructor
public class RequestResult<T> {

    private Date timestamp;
    private T data;
    private int code;
    private RequestResultStatus status;
    private String message;

    public RequestResult<T> error(int code, String message, T data) {
        return new RequestResult<T>(new Date(), data, code, RequestResultStatus.ERROR, message);
    }

    public RequestResult<T> success(int code, String message, T data) {
        return new RequestResult<T>(new Date(), data, code, RequestResultStatus.SUCCESS, message);
    }


}
