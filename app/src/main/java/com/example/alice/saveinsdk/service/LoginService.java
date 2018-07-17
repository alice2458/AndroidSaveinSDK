package com.example.alice.saveinsdk.service;

import android.annotation.SuppressLint;
import android.content.Context;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class LoginService {
    public static boolean saveUserInfo(Context context, String username, String password){
        try{
            @SuppressLint("SdCardPath") File file = new File("/sdcard/info.txt");
            FileOutputStream fos = new FileOutputStream(file);
            fos.write((username + "##" + password).getBytes());
            fos.close();
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
    public static Map<String, String> getSaveUserInfo(Context context) throws IOException{
        @SuppressLint("SdCardPath") File file = new File("/sdcard/info.txt");
        FileInputStream fis = new FileInputStream(file);
        BufferedReader br = new BufferedReader(new InputStreamReader(fis));
        String str = br.readLine();
        String[] infos = str.split("##");
        Map<String, String> map = new HashMap<>();
        map.put("username", infos[0]);
        map.put("password", infos[1]);
        return map;
    }
}
