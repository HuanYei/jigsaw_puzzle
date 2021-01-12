package com.example.jigsaw_puzzle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;

import com.example.jigsaw_puzzle.util.ImageUtil;
import com.example.jigsaw_puzzle.util.PowerUtil;

import java.util.List;

public class HOME_Activity extends AppCompatActivity implements View.OnClickListener {
    private String TAG="HOME_Activity";
    //定义暂时存储
    private SharedPreferences sp;
    private SharedPreferences.Editor ed;
    //图片数量
    private int imgs_sum;
    //所有图片路径
    private List<String> img_list_path;
    //定义控件
    private Button paly_game;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        //第一次启动
        first_time_start();
        //获取权限
        PowerUtil.getRead_Write(this);

        //测试
        test();
        Log.e(TAG,imgs_sum+"");
    }

    @Override
    protected void onStart() {
        super.onStart();
        paly_game=findViewById(R.id.paly_game);
        paly_game.setOnClickListener(this);
        imgs_sum= ImageUtil.getImgsum();
        img_list_path= ImageUtil.getImgnameList();

        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP) {
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                    != PackageManager.PERMISSION_GRANTED) {
                    finish();
            }
        }
    }

    @Override
    protected void onStop() {
        super.onStop();

    }

    private void test() {

    }
    private void first_time_start() {

        sp=getSharedPreferences("first",MODE_PRIVATE);
        ed=sp.edit();
        if (sp.getBoolean("first",true)){
            Log.e(TAG," jj");
            ImageUtil.cunfang(this);
        }
        ed.putBoolean("first",false);
        ed.commit();
    }



    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.paly_game:
                Intent intent=new Intent(HOME_Activity.this,Palying_Activity.class);
                intent.putExtra("path_img",img_list_path.get(0));
                startActivity(intent);
                break;
        }
    }
}