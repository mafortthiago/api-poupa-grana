package com.mafort.poupagrana.domain.user;

public record RegisterDTO(String login, String password, UserRole role) {
}
