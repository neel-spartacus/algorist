package geeks.practise;

import com.test.*;
import com.test.Math;
import com.test.example.*;


public class TestL {

    public static void main (String args[]){
            String message = "Hello world!";
            String newMessage = message.substring(6, 12)
                    + message.substring(12, 6);
            System.out.println(newMessage);
        }
    }
