package com.mafort.poupagrana.repositories;

import com.mafort.poupagrana.domain.item.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Long> {


    @Query("SELECT i FROM Item i WHERE i.user_id = ?1 ORDER BY i.created_at DESC")
    List<Item> findByUser_id(String user_id);

}
