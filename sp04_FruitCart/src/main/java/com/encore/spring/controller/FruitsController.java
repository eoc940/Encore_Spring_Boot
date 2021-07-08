package com.encore.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.encore.spring.domain.Item;
import com.encore.spring.model.ItemCatalog;

@Controller
public class FruitsController {

	@Autowired
	private ItemCatalog itemCatalog;
	
	@RequestMapping("index.do")
	public ModelAndView index() throws Exception{
		List<Item> list = itemCatalog.getItemList();
		return new ModelAndView("WEB-INF/views/itemList.jsp", "list", list);
	}
	
	@RequestMapping("itemView.do")
	public ModelAndView itemView(@RequestParam("itemNumber") int itemNumber) throws Exception{
		
		Item item = itemCatalog.getItem(itemNumber);
		return new ModelAndView("WEB-INF/views/itemView.jsp", "item", item);
	}
	
}
