package com.mafort.poupagrana.domain.item;


import java.util.Date;

public record ItemResponseDTO(Long id, String description, String type, Float value, Date created_at, String user_id ){
    public ItemResponseDTO(Item item){
        this(item.getId(), item.getDescription(), item.getType(), item.getValue(), item.getCreated_at(), item.getUser_id());
    }
}
