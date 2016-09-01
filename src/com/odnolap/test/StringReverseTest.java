package com.odnolap.test;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * Created by Odnolap on 11.03.2015.
 */
public class StringReverseTest
{
    /**
     * final static string that should be modified.
     */
    public static final String testString = "abcde";

    public static void main(String[] args) {
        try{
            System.out.println("Initial static final string:  "+testString);
            Field[] fields = testString.getClass().getDeclaredFields();
            System.out.println(testString.getClass());
            Field value = null;
            for(int i=0; i<fields.length; i++){
                Field field = fields[i];
                System.out.println(field.getName() + " - " + field.getType().toString() + " - " + field.getClass());
                if (field.getType().equals(char[].class)){
                    value = field;
                    //break;
                }
            }
            System.out.println("----");
            if (value == null){
                System.err.println("value wasn't found!");
                return;
            }
            value.setAccessible(true);  // 1.
            char[] charValue = (char[])value.get(testString);
            for(int i=0; i<charValue.length/2; i++ ){
                char tmp=charValue[i];
                charValue[i] = charValue[charValue.length-1-i];
                charValue[charValue.length-1-i] = tmp;
            }
            value.set(testString, charValue);
            System.out.print("Reversed static final string: ");
            System.out.println(testString);
        }catch (Throwable th){
            System.err.println("Exception: "+th);
            th.printStackTrace();
        }
    }
}
