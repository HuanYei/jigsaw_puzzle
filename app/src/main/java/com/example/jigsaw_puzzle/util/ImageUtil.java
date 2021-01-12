package com.example.jigsaw_puzzle.util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Environment;
import android.util.Log;

import com.example.jigsaw_puzzle.R;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class ImageUtil {
    static   List<String> imagePathList = new ArrayList<>();
    static File file=new File(Environment.getExternalStorageDirectory().toString()+"/Jigsaw_puzzle_Image");

    //文件处理
    static void Image_file(){
        //如果没有则创建图片路径
        if (!file.exists()){
            file.mkdir();
        }
        //获取file中所有的文件
        File[] files = file.listFiles();
        for (int i = 0; i < files.length; i++) {
            File filel = files[i];
            if (checkIsImageFile(filel.getPath())) {
                imagePathList.add(filel.getPath());
            }
        }
    }
    // 返回得到的图片数量
    public static   int getImgsum(){
        imagePathList.clear();
        Image_file();
        return imagePathList.size();
    }
    // 返回得到的图片数量
    public static   List<String> getImgnameList(){
        imagePathList.clear();
        Image_file();
        return imagePathList;
    }
    // 清空数据
    public static void LsistClear(){
        Image_file();
        imagePathList.clear();
    }
    /**
     * 检查扩展名，得到图片格式的文件
     * @param fName  文件名
     * @return
     */
    @SuppressLint("DefaultLocale")
    private static boolean checkIsImageFile(String fName) {
        boolean isImageFile = false;
        // 获取扩展名
        String FileEnd = fName.substring(fName.indexOf(".") + 1,
                fName.length()).toLowerCase();
        if (FileEnd.equals("jpg") || FileEnd.equals("png") || FileEnd.equals("gif")
                || FileEnd.equals("jpeg")|| FileEnd.equals("bmp") ) {
            isImageFile = true;
        } else {
            isImageFile = false;
        }
        return isImageFile;
    }
    //写入文件
    public static void cunfang(Context context){
        Resources res = context.getResources();
        BitmapDrawable d = (BitmapDrawable) res.getDrawable(R.drawable.bj);
        Bitmap img = d.getBitmap();
        String fn = "image_test.png";
        String path = Environment.getExternalStorageDirectory().toString()+"/Jigsaw_puzzle_Image/" + fn;
        try{
            OutputStream os = new FileOutputStream(path);
            img.compress(Bitmap.CompressFormat.PNG, 100, os);
            os.close();
        }catch(Exception e){
            Log.e("TAG", "", e);
        }
    }
}
