package util;

import com.google.gson.stream.JsonReader;

import java.io.*;


public final class Util {

    /**
     * The writeJsonToFile method writes JSON to file
     */
    public static boolean writeJsonToFile(String filename, String json) {
        try(FileWriter fw = new FileWriter(filename)){
            fw.write(json);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * The readJsonToFile method reads JSON from file
     */
    public static JsonReader readJsonFromFile(String filename) {
        try{
            if(new File(filename).exists()) {
                return new JsonReader(new FileReader(filename));
            } else {
                return null;
            }
        }
        catch(IOException e){
            e.printStackTrace();
            return null;
        }
    }
}
