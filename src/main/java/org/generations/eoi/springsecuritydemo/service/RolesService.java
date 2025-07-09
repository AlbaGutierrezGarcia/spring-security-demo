package org.generations.eoi.springsecuritydemo.service;

import org.generations.eoi.springsecuritydemo.entity.Roles;
import org.generations.eoi.springsecuritydemo.repository.RolesRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RolesService{

    private final RolesRepository rolesRepository;

    public RolesService(RolesRepository rolesRepository) {
        this.rolesRepository = rolesRepository;
    }

    public List<Roles> getRoles(){
        return rolesRepository.findAll();
    }

    public Optional<Roles> getRoleById(Long id){
        return rolesRepository.findById(id);
    }

    public void save(Roles roles) {
        rolesRepository.save(roles);
    }

    public void deletebyId(Long id) {
        rolesRepository.deleteById(id);
    }
}
