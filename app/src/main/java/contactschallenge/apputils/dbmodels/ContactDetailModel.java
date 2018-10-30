package contactschallenge.apputils.dbmodels;

import io.realm.RealmObject;
import io.realm.annotations.RealmClass;

/**
 * Created by harish on 30/10/18.
 */
@RealmClass
public class ContactDetailModel extends RealmObject implements Cloneable {
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPicture() {
        return userPicture;
    }

    public void setUserPicture(String userPicture) {
        this.userPicture = userPicture;
    }

    public String getUserPhoneNumber() {
        return userPhoneNumber;
    }

    public void setUserPhoneNumber(String userPhoneNumber) {
        this.userPhoneNumber = userPhoneNumber;
    }

    public String getUserCountryCode() {
        return userCountryCode;
    }

    public void setUserCountryCode(String userCountryCode) {
        this.userCountryCode = userCountryCode;
    }

    public String getUserAdderss() {
        return userAdderss;
    }

    public void setUserAdderss(String userAdderss) {
        this.userAdderss = userAdderss;
    }

    String userName;
    String userEmail;
    String userPicture;
    String userPhoneNumber;
    String userCountryCode;
    String userAdderss;

}
