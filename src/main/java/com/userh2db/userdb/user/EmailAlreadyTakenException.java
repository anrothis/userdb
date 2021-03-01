package com.userh2db.userdb.user;

public class EmailAlreadyTakenException extends RuntimeException
{    
    /**
     *
     */
    private static final long serialVersionUID = 6125653928289017764L;

    EmailAlreadyTakenException(String email)
    {
        super("The Email " + email + " is already taken");
    }
}
