package com.iJ07.carreviewapi.auth;

import com.iJ07.carreviewapi.exceptions.EtAuthException;

public interface authRepository {

    Integer create(String username, String email, String password) throws EtAuthException;

    User findByEmailAndPassword(String email, String password) throws EtAuthException;

    Integer getCountByEmail(String email);

    User findById(Integer user_id);

}
