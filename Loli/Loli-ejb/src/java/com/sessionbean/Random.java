/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sessionbean;

import java.security.SecureRandom;
import java.util.function.Supplier;
import javax.ejb.Stateful;

/**
 *
 * @author nttha
 */
@Stateful
public class Random implements RandomLocal {

    @Override
    public String randomcode(int length) {
        String CHARACTERS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Supplier<String> randomStringSupplier = () -> new SecureRandom()
                .ints(length, 0, CHARACTERS.length())
                .mapToObj(CHARACTERS::charAt)
                .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
                .toString();
        return randomStringSupplier.get();
    }
}
