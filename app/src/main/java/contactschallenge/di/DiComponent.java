package contactschallenge.di;


import javax.inject.Singleton;

import contactschallenge.core.BaseActivity;
import contactschallenge.core.BaseFragment;
import contactschallenge.net.firebase.MyFirebaseInstanceIDService;
import dagger.Component;

/**
 * Created by Harish on 9/11/16.
 */


@Singleton
@Component(modules = {DiModule.class})

public interface DiComponent {
    void inject(BaseActivity baseActivity);

    void inject(MyFirebaseInstanceIDService myFirebaseInstanceIDService);

    void inject(BaseFragment baseFragment);

    // to update the fields in your activities


}