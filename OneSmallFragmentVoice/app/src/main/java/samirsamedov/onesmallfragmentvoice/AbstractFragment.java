package samirsamedov.onesmallfragmentvoice;

import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;

/**
 * Created by Samir on 2.4.2016.
 */
public abstract class AbstractFragment extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_fragment);

        android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment fragment = fragmentManager.findFragmentById(R.id.singleFragment);

        if (fragment == null) {
            fragment = createFragment();

            // fragment başlatma komutumuz
            fragmentManager.beginTransaction().add(R.id.singleFragment, fragment).commit();
        }
    }
    abstract Fragment createFragment();


}
