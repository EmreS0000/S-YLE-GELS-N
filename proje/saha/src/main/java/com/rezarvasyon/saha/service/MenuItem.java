package com.rezarvasyon.saha.service;

import com.rezarvasyon.saha.dto.MenuItemRequest;
import com.rezarvasyon.saha.entity.MenuItem;
import com.rezarvasyon.saha.entity.Restoran;
import com.rezarvasyon.saha.repository.MenuItemRepository;
import com.rezarvasyon.saha.repository.RestoranRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuItemService {
    @Autowired
    private MenuItemRepository menuItemRepository;
    @Autowired
    private RestoranRepository restoranRepository;

    public MenuItem createMenuItem(MenuItemRequest request){
        Restoran restoran=restoranRepository.findById(request.getRestoranId())
                .orElseThrow(()->new RuntimeException("Restoran bulunamadi"));
        MenuItem menuItem=new MenuItem();
        menuItem.setName(request.getName());
        menuItem.setDescription(request.getDescription());
        menuItem.setPrice(request.getPrice());

        menuItem.setRestoran(restoran);
        return menuItemRepository.save(menuItem);
    }
    public List<MenuItem> getMenuItemsByRestoran(Restoran restoran) {
        return menuItemRepository.findByRestoran(restoran);
    }

    public void deleteMenuItem(Long id) {
        menuItemRepository.deleteById(id);
    }
}