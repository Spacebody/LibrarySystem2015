/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

/**
 *
 * @author Spike
 */
public class publicmethod {
    Calendar date;
    File file;
    FileReader reader;
    FileWriter writer;
    ArrayList array;
    Scanner input=new Scanner(System.in);

public static void print(String s){
    System.out.print(s);
}
        public static String reading(File file){
         String result = "";
         try{
             try (BufferedReader br = new BufferedReader(new FileReader(file)) //构造一个BufferedReader类来读取文件
             ) {
                 String s;
                 while((s = br.readLine())!=null){//使用readLine方法，一次读一行
                     result = result + "\n" +s;
                 }
             }
         }catch(Exception e){
         }
         return result;
}
}