package com.mysql.dbeditor.util;

public class BookDescriptionCutter {
    public static String cutDescription(String className, String description){
        int characterLimit = 0;
        if(className.equals("MainController"))              characterLimit = 150;
        else if(className.equals("FavouriteController"))    characterLimit = 70;
        if(description.length() > characterLimit){
            description = description.substring(0, characterLimit) + "...";
        }
        return description;
    }
}
