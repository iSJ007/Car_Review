package com.iJ07.carreviewapi.auth;
import com.iJ07.carreviewapi.auth.User;



import com.iJ07.carreviewapi.exceptions.EtAuthException;

public interface authService {
    User validateUser(String email, String password) throws EtAuthException;

    User registerUser(String username, String email, String password) throws EtAuthException;


}
