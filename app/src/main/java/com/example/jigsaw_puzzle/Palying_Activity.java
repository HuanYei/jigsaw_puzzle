package com.example.jigsaw_puzzle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import com.example.jigsaw_puzzle.pojo.ShuJuZDY;
import com.example.jigsaw_puzzle.util.PalyingUtil;

public class Palying_Activity extends AppCompatActivity {
    private String TAG="Palying_Activity";
    private ImageView pt1,pt2,pt3,pt4,pt5,pt6,pt7,pt8,pt9;
    private Intent intent;
    int[] initial_position_array = new int[9];
    int[] final_position_array=new int[9];
    Bitmap initial_bitmap_array[]=new Bitmap[9];
    Bitmap final_bitmap_array[]=new Bitmap[9];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_palying);
        intent=getIntent();
    }

    @Override
    protected void onStart() {
        super.onStart();
        pt1=findViewById(R.id.pt1);pt2=findViewById(R.id.pt2);pt3=findViewById(R.id.pt3);
        pt4=findViewById(R.id.pt4);pt5=findViewById(R.id.pt5);pt6=findViewById(R.id.pt6);
        pt7=findViewById(R.id.pt7);pt8=findViewById(R.id.pt8);pt9=findViewById(R.id.pt9);
        //初始化位置数组
        initial_position_array= PalyingUtil.initial_position_array();
        img_list_create();

    }

    private void img_list_create() {
        String path=intent.getStringExtra("path_img");
//        Uri uri=Uri.parse(path);
        Bitmap bitmap=BitmapFactory.decodeFile(path);
        ShuJuZDY shuJu=new ShuJuZDY(bitmap,pt1.getWidth(),pt1.getHeight());
        initial_bitmap_array=shuJu.pt(initial_position_array,this);
        runY();
    }
    public void runY(){
        pt1.setImageBitmap(initial_bitmap_array[0]);
        pt2.setImageBitmap(initial_bitmap_array[1]);
        pt3.setImageBitmap(initial_bitmap_array[2]);
        pt4.setImageBitmap(initial_bitmap_array[3]);
        pt5.setImageBitmap(initial_bitmap_array[4]);
        pt6.setImageBitmap(initial_bitmap_array[5]);
        pt7.setImageBitmap(initial_bitmap_array[6]);
        pt8.setImageBitmap(initial_bitmap_array[7]);
        pt9.setImageBitmap(initial_bitmap_array[8]);
        for (int i=0;i<9;i++)
        Log.e(TAG,initial_position_array[i]+"");
    }

    @Override
    protected void onStop() {
        super.onStop();
        finish();
    }
}