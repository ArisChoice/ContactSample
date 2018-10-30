package contactschallenge.net;

/**
 * Created by harish on 29/8/18.
 */

public interface NetworkConstatnts {

    interface ResponseCode {
        int success = 201;
        int sessionExpred = 203;
    }

    interface URL {
        //        String BASE_URL = ""; //LIVE
        String BASE_URL = "http://barber.xicom.info/";//DEMO
    }

    interface KEYS {
        String secretKey = "J3H7F9J6FG";
        String deviceType = "DeviceType";
        String uniqueDeviceId = "UniqueDeviceId";
        // String deviceId = "DeviceID";
        String TimeStamp = "TimeStamp";
        String sessionToken = "SessionToken";
        String deviceToken = "DeviceToken";
        String userId = "userId";
        String sessionId = "SessionId";
        String ClientHash = "ClientHash";


    }

    interface API {
        String ABOUT_US = URL.BASE_URL + "Page/AboutUs";

        String loginUser = "api/account/Login";
    }

    interface Params {
        String firstName = "firstName";
        String email = "Email";
        String lastName = "lastName";
        String password = "Password";

    }

    interface RequestCode {
        int API_LOGIN = 1;
        int API_REGISTER = 2;
        int API_FORGET_PASSWORD = 3;

    }
}
