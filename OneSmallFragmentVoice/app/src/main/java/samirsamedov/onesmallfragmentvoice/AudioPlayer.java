package samirsamedov.onesmallfragmentvoice;

import android.content.Context;
import android.media.MediaPlayer;

/**
 * Created by Samir on 2.4.2016.
 */
public class AudioPlayer {

    private MediaPlayer mediaPlayer;

    public void play(Context context){
       if(mediaPlayer==null){
           mediaPlayer = MediaPlayer.create(context,R.raw.one_small_audio);// ikinci işlenecek audio dosyası
       }
        mediaPlayer.start();
    }
    public void stop() {
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }
    public void pause(){
        if(mediaPlayer!=null){
            mediaPlayer.pause();
          
        }

    }
}
