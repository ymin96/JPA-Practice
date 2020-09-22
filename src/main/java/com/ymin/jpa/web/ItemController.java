package com.ymin.jpa.web;

import com.ymin.jpa.domain.item.Book;
import com.ymin.jpa.domain.item.Item;
import com.ymin.jpa.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class ItemController {

    @Autowired
    ItemService itemService;

    @RequestMapping(value = "/items/new", method = RequestMethod.GET)
    public String createForm(){
        return "items/createItemForm";
    }

    @RequestMapping(value = "/items/new", method = RequestMethod.POST)
    public String create(Book item){
        itemService.saveItem(item);
        return "redirect:/items";
    }

    @RequestMapping(value = "/items", method = RequestMethod.GET)
    public String list(Model model){
        List<Item> items = itemService.findItems();
        model.addAttribute("items", items);
        return "items/itemList";
    }


}
