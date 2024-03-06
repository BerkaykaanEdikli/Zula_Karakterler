package com.berkaykaanedikli.uyg11syf242;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;

import com.berkaykaanedikli.uyg11syf242.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    ArrayList<Image> imageArrayList;
    int aktifSiraNo;

   MediaPlayer player;
    private boolean isPlaying = false;
    private MediaPlayer selamPlayer1;
    private MediaPlayer selamPlayer2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

       player = MediaPlayer.create(MainActivity.this, R.raw.zula);
       player.setLooping(true);
       player.start();

       selamPlayer1 = MediaPlayer.create(this,R.raw.selamunaleykum);

       selamPlayer2 = MediaPlayer.create(this,R.raw.aleykumselam);


        imageArrayList = new ArrayList<>();
        Image cengiz = new Image("Cengiz Abi",1,R.drawable.cengiz);
        Image demir = new Image("Demir Erez",2,R.drawable.demir);
        Image samil = new Image("Şamil Dudayev",3,R.drawable.samil);
        Image esref = new Image("Eşref Dayı",4,R.drawable.esref);

        imageArrayList.add(cengiz);
        imageArrayList.add(demir);
        imageArrayList.add(samil);
        imageArrayList.add(esref);

        binding.imageView.setImageResource(imageArrayList.get(0).foto);
        binding.txtMesaj.setText("Bilgi: "+imageArrayList.get(0).bilgi);
        aktifSiraNo = 0;
    }
    public void sesCal2(View view){
        if(selamPlayer2.isPlaying()){
            selamPlayer2.seekTo(0);
        }
        else {
            selamPlayer2.start();
        }
    }
    public void sesCal1(View view){
        if(selamPlayer1.isPlaying()){
            selamPlayer1.seekTo(0);
        }
        else{
            selamPlayer1.start();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        player.pause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        player.start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        player.stop();
        player.release();

        if (selamPlayer1 != null) {
            selamPlayer1.release();
        }
        if (selamPlayer2 != null) {
            selamPlayer2.release();
        }
    }

    public void geriGit(View view){
        if(aktifSiraNo>0){
            aktifSiraNo--;
            binding.imageView.setImageResource(imageArrayList.get(aktifSiraNo).foto);
            binding.txtMesaj.setText("Bilgi: "+imageArrayList.get(aktifSiraNo).bilgi);
        }
    }
    public void ileriGit(View view){
        if(aktifSiraNo<imageArrayList.size()-1){
            aktifSiraNo++;
            binding.imageView.setImageResource(imageArrayList.get(aktifSiraNo).foto);
            binding.txtMesaj.setText("Bilgi: "+imageArrayList.get(aktifSiraNo).bilgi);
        }
    }
}
