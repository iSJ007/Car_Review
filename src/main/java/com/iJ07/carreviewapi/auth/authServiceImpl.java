package com.iJ07.carreviewapi.auth;

import com.iJ07.carreviewapi.exceptions.EtAuthException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.regex.Pattern;

@Service
@Transactional
public class authServiceImpl implements authService {

    @Autowired
    authRepository AuthRepository;
    @Override
    public User validateUser(String email, String password) throws EtAuthException {
        if(email != null) email = email.toLowerCase();
        return AuthRepository.findByEmailAndPassword(email, password);
    }

    @Override
    public User registerUser(String username, String email, String password) throws EtAuthException {
        Pattern pattern = Pattern.compile("^(.+)@(.+)$");
        if(email != null) email = email.toLowerCase();
        if(!pattern.matcher(email).matches())
            throw new EtAuthException("Invalid email format");
        Integer count = AuthRepository.getCountByEmail(email);
        if(count > 0)
            throw new EtAuthException("Email already in use");
        Integer userId = AuthRepository.create(username, email, password);
        return AuthRepository.findById(userId);
    }
}
