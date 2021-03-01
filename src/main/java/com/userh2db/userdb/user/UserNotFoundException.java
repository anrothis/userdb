package com.userh2db.userdb.user;

public class UserNotFoundException extends RuntimeException {
    
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    UserNotFoundException(Long id)
    {
        super("Could not find User " + id);
    }
    
    UserNotFoundException(String name)
    {
        super("Could not find User " + name);
    }
}
