package com.mikro.service.impl;

import com.mikro.dto.RoleDTO;
import com.mikro.entity.Role;
import com.mikro.exception.UserServiceException;
import com.mikro.repository.RoleRepository;
import com.mikro.service.RoleService;
import com.mikro.util.MapperUtil;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoleServiceImpl implements RoleService {


    private RoleRepository roleRepository;
    private MapperUtil mapperUtil;

    public RoleServiceImpl(RoleRepository roleRepository, MapperUtil mapperUtil) {
        this.roleRepository = roleRepository;
        this.mapperUtil = mapperUtil;
    }

    @Override
    public List<RoleDTO> listAllRoles() {
        List<Role> list = roleRepository.findAll();
        return list.stream().map(obj -> mapperUtil.convert(obj,new RoleDTO())).collect(Collectors.toList());
    }

    @Override
    public RoleDTO findById(Long id) throws UserServiceException {
        Role role = roleRepository.findById(id).orElseThrow(() -> new UserServiceException("Role does not exists"));
        return mapperUtil.convert(role,new RoleDTO());
    }
}
