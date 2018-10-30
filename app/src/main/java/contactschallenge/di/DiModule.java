package contactschallenge.di;


import javax.inject.Named;
import javax.inject.Singleton;

import contactschallenge.apputils.CommonUtils;
import contactschallenge.apputils.PreferenceManager;
import contactschallenge.net.RestConfig;
import contactschallenge.net.RestService;
import dagger.Provides;


/**
 * Created by Harish on 9/11/16.
 */
@dagger.Module
public class DiModule {


    @Provides
    @Singleton
    public CommonUtils getUtil() {
        return new CommonUtils();
    }

    @Provides
    @Singleton
    public PreferenceManager getSharedStorage() {
        return new PreferenceManager();
    }


   /* @Provides
    @Singleton
    public MyInstanceIDListenerService getFireBaseTokenRefresh() {
        return new MyInstanceIDListenerService();
    }*/

    @Provides
    @Singleton
    @Named(DaggerValues.AUTH)
    RestService provideAuthRestService() {
        return new RestConfig().RestConfigWithAuth().create(RestService.class);
    }

    //provides unauthorised rest service
    @Provides
    @Singleton
    @Named(DaggerValues.NON_AUTH)
    RestService provideNonAuthRestService() {
        return new RestConfig().RestConfigWithOutAuth().create(RestService.class);
    }


}