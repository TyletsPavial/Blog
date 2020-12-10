package com.blog.service.role;

import com.blog.model.Role;
import com.blog.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleRepository roleRepository;
    @Override
    public Role getById(int id) {
        return roleRepository.findById(id);
    }
}
