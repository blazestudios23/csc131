package com.controller.spreadsheet;
import java.io.*;

public class CopyFile {
   public static void main(String args[]) throws IOException
   {
      FileInputStream in = null;
      FileOutputStream out = null;

      try {
    	  
    	  String pathAppend="src\\com\\controller\\spreadsheet\\";
    	  
         in = new FileInputStream(System.getProperty("user.dir")+"\\"+pathAppend+"counter.txt");
         out = new FileOutputStream(System.getProperty("user.dir")+"\\"+pathAppend+"counter.txt");
         
         int c;
         while ((c = in.read()) != -1) {
            out.write(c);
         }
      }finally {
         if (in != null) {
            in.close();
         }
         if (out != null) {
            out.close();
         }
      }
   }
}