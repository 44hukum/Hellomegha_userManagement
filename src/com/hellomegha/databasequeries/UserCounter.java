/*
 * COunt the users 
 */
package com.hellomegha.databasequeries;

import java.sql.Connection;

/**
 *
 * @author wanu
 */
public interface UserCounter {
    public int countUser();
    public int countAdmin();
     public int countBlockedUser();
}
