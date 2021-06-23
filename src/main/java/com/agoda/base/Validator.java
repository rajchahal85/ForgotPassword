package com.agoda.base;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
    private static String SystemPassword = "tesstes3tdsztesAn14!";

    public static void alphaCheck(String newPassowrd) throws Exception {
        String regex = "([A-Za-z0-9@$!%_.*?#&]){18,100}$";
        Pattern p = Pattern.compile(regex);

        Matcher m = p.matcher(newPassowrd);
        if(!m.matches()) {
            throw new Exception("18 alphanumeric characters");
        }
    }

    public static void conditionsCheck(String newPassowrd) throws Exception {
        int upperCaseCount = 0;
        int lowerCaseCount = 0;
        int specialCharCount = 0;
        int numbersCount = 0;

        Map<Character,Integer> hash= new HashMap<Character,Integer>();

        for(int i = 0; i< newPassowrd.length(); i++)
        {
            char ch = newPassowrd.charAt(i);

            if(hash.containsKey(ch))
            {
                hash.put(ch, hash.get(ch)+1);
            }
            else
            {
                hash.put(ch, 1);
            }

            if(Character.isUpperCase(ch))
            {
                upperCaseCount++;
            }
            else if(Character.isLowerCase(ch))
            {
                lowerCaseCount++;
            }
            else if (Character.isDigit(ch))
            {
                numbersCount++;
            }
            else
            {
                specialCharCount++;
            }
        }

        if(upperCaseCount < 1 || lowerCaseCount < 1 || numbersCount < 1 || specialCharCount < 1)
        {
            throw new Exception("At least 1 Upper case, 1 lower case ,least 1 numeric, 1 special character. " +
                                    "UpperCaseCount = " + upperCaseCount +
                                    " LowerCaseCount = " + lowerCaseCount +
                                    " numbersCount = " + numbersCount +
                                    " specialCharsCount = " + specialCharCount);
        }

        if(specialCharCount > 4)
        {
            throw new Exception("Special Characters must not be more than 4 in count." +
                                " specialCharsCount = " + specialCharCount);
        }

        if((numbersCount * 1.0 )/newPassowrd.length() > 0.5)
        {
            throw new Exception("Numbers must not be more than 50% of the password." +
                    " Numbers Count = " + numbersCount +
                    " Total Count = " + newPassowrd.length());
        }

        maxRepeatCharCheck(hash);
    }

    public static void maxRepeatCharCheck(Map<Character,Integer> hash) throws Exception {
        Set<Map.Entry<Character, Integer>> entries = hash.entrySet();

        for (Map.Entry<Character, Integer> entry : entries) {
            if(entry.getValue() > 4)
            {
                throw new Exception("There must not be a character repeated more than 4 times. " + entry.getKey() + " is repeated " + entry.getValue() + " times.");
            }
        }
    }

    public static void verifySystemPassword(String oldPassword) throws Exception {
        if(!oldPassword.equals(SystemPassword))
        {
            throw new Exception("Provided old password must match system password");
        }
    }

    public static void similarityChecks(String oldPassword, String newPassowrd) throws Exception {
        double similarityValue = Utils.getSimilarity(oldPassword, newPassowrd);
        if( similarityValue >= 0.80)
        {
            throw new Exception("New and Old Passwords must not have a match more than 80%. Current Match : " + similarityValue);
        }
        System.out.println(similarityValue);
    }
}
