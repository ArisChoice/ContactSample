package contactschallenge.apputils;

/**
 * Created by harish on 29/10/18.
 */

public class GlobalValues {
    public static final String TIMESTAMP_FORMAT = "yyyyMMdd_HHmmss";

    public interface RequestCodes {
        int TIME_SELECTION = 921;
    }

    public interface TIME_DURATIONS {
        int SMALL = 100;
        int MEDIUS = 300;
        int LARGE = 500;
        int EXTRA_LARGE = 3000;
    }

    public interface KEYS {
        String isLogedIn = "isUserLogedin";
        String USER_ID = "userId";
        String USER_NAME = "userName";
        String IS_EDIT = "isEdit";
    }

    public interface ClickOperations {
        int DETAIL_CLICK = 181;
    }
}
