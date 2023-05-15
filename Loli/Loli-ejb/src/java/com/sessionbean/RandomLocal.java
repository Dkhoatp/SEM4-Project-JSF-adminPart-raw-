/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sessionbean;

import javax.ejb.Local;

@Local
public interface RandomLocal {
    String randomcode(int length);
}
