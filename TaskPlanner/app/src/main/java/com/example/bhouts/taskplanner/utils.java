package com.example.bhouts.taskplanner;

/**
 * Class for useful static methods that can be used in any module
 * Created by Julia on 7/21/2016.
 */
public class utils {

    // isValidInput
    // pre: none
    // post: returns true if non-null, non-empty, and non-whitespace input
    //       returns false otherwise
    public static boolean isValidInput (String userInput) {
        if ( userInput != null && !userInput.equals("\\s*") ) {
            return true;
        }
        else return false;
    }
}
