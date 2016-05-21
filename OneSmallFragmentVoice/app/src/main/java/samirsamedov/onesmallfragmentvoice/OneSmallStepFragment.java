package samirsamedov.onesmallfragmentvoice;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by Samir on 2.4.2016.
 */
public class OneSmallStepFragment extends Fragment {
    private AudioPlayer audioPlayer;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        audioPlayer = new AudioPlayer();
    }

    // EKRAN GORUNTUSUU BUNUNLA CAGISACAGIZ
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_one_small_step, container, false);

        Button btnStart = (Button) view.findViewById(R.id.btnStart); // burdaki view yukardaki tanımlı view
        {
            btnStart.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    audioPlayer.play(getActivity());
                }
            });
        }

        Button btnStop = (Button) view.findViewById(R.id.btnStop);
        {
            btnStop.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    audioPlayer.stop();
                }
            });
        }
        Button btnPause = (Button) view.findViewById(R.id.btnPause);
        btnPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                audioPlayer.pause();
            }
        });
        return view;
    }
}
