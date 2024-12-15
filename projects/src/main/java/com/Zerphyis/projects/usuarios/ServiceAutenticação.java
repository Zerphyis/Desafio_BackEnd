package com.Zerphyis.projects.usuarios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class ServiceAutenticação {
    @Autowired
    private RepositoryUsuario repository;

    public UserDetails loadUserByUsername(String nome ) throws UsernameNotFoundException {
        return repository.findByLogin(nome);
    }
}
