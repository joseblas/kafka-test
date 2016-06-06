package org.reactive.mvc;

/**
 * Created by dev on 06/05/16.
 */
public class JsonResponse {
    private String status = "";
    private String errorMessage = "";

    public JsonResponse(String status, String errorMessage) {
        this.status = status;
        this.errorMessage = errorMessage;
    }
}
