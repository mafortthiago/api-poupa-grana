package com.mafort.poupagrana.domain.item;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.OptBoolean;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

public record ItemRequestDTO(
        @NotBlank String description,
        @NotBlank String type,
        @NotNull Float value,
        @NotNull Date created_at,
        @NotNull String user_id
) {}
