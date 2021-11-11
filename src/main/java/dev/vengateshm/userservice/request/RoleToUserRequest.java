package dev.vengateshm.userservice.request;

import lombok.Data;

@Data
public class RoleToUserRequest {
    private String username;
    private String roleName;
}