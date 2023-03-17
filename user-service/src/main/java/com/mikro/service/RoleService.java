package com.mikro.service;

import com.mikro.dto.RoleDTO;
import com.mikro.exception.UserServiceException;

import java.util.List;

public interface RoleService {

    List<RoleDTO> listAllRoles();
    RoleDTO findById(Long id) throws UserServiceException;
}
