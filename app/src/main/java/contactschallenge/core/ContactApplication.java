package contactschallenge.core;

import android.app.Application;
import android.content.Context;

import contactschallenge.di.DaggerDiComponent;
import contactschallenge.di.DiComponent;
import contactschallenge.di.DiModule;
import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by harish on 29/10/18.
 */

public class ContactApplication extends Application {
    private static ContactApplication instance;
    private DiComponent myComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        myComponent = DaggerDiComponent.builder().diModule(new DiModule()).build();
        setRelamConfig();
    }
    private void setRelamConfig() {
        RealmConfiguration config = new RealmConfiguration.Builder(this)
                .deleteRealmIfMigrationNeeded()
                .build();
        Realm.setDefaultConfiguration(config);

    }
    public static DiComponent getMyComponent(Context applicationContext) {
        return ((ContactApplication) applicationContext.getApplicationContext()).myComponent;
    }

    public static Context getInstance() {
        return instance;
    }

}
