package com.quartztask.controller;

import com.quartztask.entity.Items;
import com.quartztask.service.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ItemsController {

    @Autowired
    private ItemsService itemsService;
    @RequestMapping("/test")
    public void test(){
        Items items = itemsService.findItemsById(1);
        System.out.println(items.getName());
    }
}
