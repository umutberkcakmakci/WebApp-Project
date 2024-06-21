package webapp.utils;

import jakarta.servlet.http.HttpServletResponse;
import org.json.JSONObject;

public enum ErrorCode {
    OK(-200, HttpServletResponse.SC_OK,"OK."),
    WRONG_FORMAT(-300, HttpServletResponse.SC_BAD_REQUEST,"Wrong id format."),
    EMPTY_INPUT_FIELDS(-301, HttpServletResponse.SC_BAD_REQUEST, "One or more input fields are empty."),
    EMAIL_MISSING(-302, HttpServletResponse.SC_BAD_REQUEST, "Email missing"),
    PASSWORD_MISSING(-303, HttpServletResponse.SC_BAD_REQUEST, "Password missing"),
    WRONG_CREDENTIALS(-304, HttpServletResponse.SC_BAD_REQUEST, "Submitted credentials are wrong"),
    MAIL_ALREADY_USED(-305, HttpServletResponse.SC_CONFLICT, "Mail already used"),
    WRONG_REST_FORMAT(-306, HttpServletResponse.SC_BAD_REQUEST, "Wrong rest request format."),
    USER_NOT_FOUND(-307, HttpServletResponse.SC_NOT_FOUND, "User not found."),
    BADLY_FORMATTED_JSON(-308,  HttpServletResponse.SC_BAD_REQUEST, "The input json is in the wrong format."),
    PERSON_NOT_FOUND(-309, HttpServletResponse.SC_NOT_FOUND, "Person not found."),
    INVALID_INPUT_PARAMETERS(-310, HttpServletResponse.SC_BAD_REQUEST, "Invalid input parameters."),
    ENTRY_ALREADY_EXISTS(-311, HttpServletResponse.SC_BAD_REQUEST, "Database entry already exists."),
    DATABASE_ERROR(-312, HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Database error."),
    PARSE_ERROR(-313, HttpServletResponse.SC_BAD_REQUEST, "Parse error."),
    OPERATION_UNKNOWN(-400, HttpServletResponse.SC_BAD_REQUEST, "Operation unknown."),
    NOT_FOUND(-404, HttpServletResponse.SC_NOT_FOUND, "Request not found."),
    METHOD_NOT_ALLOWED(-405, HttpServletResponse.SC_METHOD_NOT_ALLOWED, "The method is not allowed"),
    INTERNAL_ERROR(-500, HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Internal Error");

    private final int errorCode;
    private final int httpCode;
    private final String errorMessage;

    ErrorCode(int errorCode, int httpCode, String errorMessage) {
        this.errorCode = errorCode;
        this.httpCode = httpCode;
        this.errorMessage = errorMessage;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public int getHTTPCode() {
        return httpCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
    public JSONObject toJSON() {
        JSONObject data = new JSONObject();
        data.put("code", errorCode);
        data.put("message", errorMessage);
        JSONObject info = new JSONObject();
        info.put("error", data);
        return info;
    }
}