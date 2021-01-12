package com.example.jigsaw_puzzle.util;

import android.util.Log;

public class PalyingUtil {
public static int[] initial_position_array(){
    int ai[]=new int[9];
    for(int i = 0; i <9; i++)
    {
        ai[i] = i;
        Log.e("TAG",ai[i]+"");
    }

    int weizhi=8;
    int tihuan=0;
    for (int i = 0; i <99; i++) {
        int sj1=(int)(Math.random()*4+1);
        if (sj1==1) {
            int pd=weizhi;
            if (weizhi==2||weizhi==1||weizhi==0) {
                pd=weizhi;
            }else {
                pd=weizhi-3;
            }

            tihuan=ai[weizhi];
            ai[weizhi]=ai[pd];
            ai[pd]=tihuan;
            weizhi=pd;
        }else if (sj1==2) {
            int pd=weizhi;
            if (weizhi==6||weizhi==7||weizhi==8) {
                pd=weizhi;
            }else {
                pd=weizhi+3;
            }

            tihuan=ai[weizhi];
            ai[weizhi]=ai[pd];
            ai[pd]=tihuan;
            weizhi=pd;
        }else if (sj1==3) {
            int pd=weizhi;
            if (weizhi==0||weizhi==3||weizhi==6) {
                pd=weizhi;
            }else {
                pd=weizhi-1;
            }
            tihuan=ai[weizhi];
            ai[weizhi]=ai[pd];
            ai[pd]=tihuan;
            weizhi=pd;
        }else if (sj1==4) {
            int pd=weizhi;
            if (weizhi==2||weizhi==5||weizhi==8) {
                pd=weizhi;
            }else {
                pd=weizhi+1;
            }
            tihuan=ai[weizhi];
            ai[weizhi]=ai[pd];
            ai[pd]=tihuan;
            weizhi=pd;
        }
    }
    return ai;
    }
}
