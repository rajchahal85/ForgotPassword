package com.agoda.base;

import org.relaxng.datatype.ValidationContext;

public class ForgotPassword {

    public static void forgotPassword(String oldPassword, String newPassowrd) throws Exception {
//        Password requirement
//
//        At least 18 alphanumeric characters and list of special chars !@#$&*
//        At least 1 Upper case, 1 lower case ,least 1 numeric, 1 special character
//        No duplicate repeat characters more than 4
//        No more than 4 special characters
//        50 % of password should not be a number
        Validator.alphaCheck(newPassowrd);
        Validator.conditionsCheck(newPassowrd);
        Validator.verifySystemPassword(oldPassword);
        Validator.similarityChecks(oldPassword, newPassowrd);
    }

}
