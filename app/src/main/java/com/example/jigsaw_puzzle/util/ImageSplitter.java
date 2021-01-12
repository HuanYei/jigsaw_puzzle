package com.example.jigsaw_puzzle.util;

import android.graphics.Bitmap;


import com.example.jigsaw_puzzle.pojo.ImagePiece;

import java.util.ArrayList;
import java.util.List;

public class ImageSplitter {
    /**
     14      * 图片切割
     15      * @param bitmap 导入图片
     16      * @param x x轴切割
     17      * @param y y轴切割
     18      * @return
     19      */
     public static List<ImagePiece> split(Bitmap bitmap, int x, int y) {
         List<ImagePiece> pieces = new ArrayList<>();
        int width = bitmap.getWidth();
         int height = bitmap.getHeight();
         int pieceWidth = width / x;
         int pieceHeight = height / y;
         for (int i = 0; i < y; i++) {
              for (int j = 0; j < x; j++) {
                 ImagePiece image = new ImagePiece();
                 image.index = j + i * x;
                 int xValue = j * pieceWidth;
                 int yValue = i * pieceHeight;
                 image.bitmap = Bitmap.createBitmap(bitmap, xValue, yValue,
                         pieceWidth, pieceHeight);
                 pieces.add(image);
             }
         }
         return pieces;
     }
     //比较图片
    public static boolean compare2Image(Bitmap bmp1,Bitmap bmp2)
    {
        int iteration = 0;
        int width = bmp1.getWidth();
        int height = bmp1.getHeight();
        if(width != bmp2.getWidth()) return false;
        if(height != bmp2.getHeight()) return false;
        if(width < height)
        {
            iteration = width;
        }
        else
        {
            iteration = height;
        }
        for(int i = 0; i < iteration; ++i)
        {
            if(bmp1.getPixel(i, i) != bmp2.getPixel(i,i)) return false;
        }
        return true;
    }
}
