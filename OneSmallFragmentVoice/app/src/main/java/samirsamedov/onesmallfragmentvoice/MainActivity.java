package samirsamedov.onesmallfragmentvoice;

import android.content.Context;
import android.os.PersistableBundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;

public class MainActivity extends AbstractFragment {


    @Override
    Fragment createFragment() {
        return new OneSmallStepFragment();
    }
}
