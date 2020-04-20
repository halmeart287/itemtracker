package hh0.itemtracker.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import hh0.itemtracker.domain.Item;
import hh0.itemtracker.domain.ItemRepository;
import hh0.itemtracker.domain.TrackerRepository;

// Kontrolleri-luokka 'Item' -luokkaoliolle.

@Controller
public class ItemController {

	@Autowired
	private ItemRepository itemRepository;
	
	@Autowired
	private TrackerRepository trackerRepository;
	
	
	// Lista 'Item' -luokan olioista.
	@RequestMapping(value = "/items", method = RequestMethod.GET)
	public String getItems(Model model) {
		List<Item> items = (List<Item>) itemRepository.findAll();
		model.addAttribute("items", items);
		return "items";
	}
	
	// 'Item' -olion lisäyslomake.
	@RequestMapping(value = "/additem", method = RequestMethod.GET)
	public String getItemForm(Model model) {
		model.addAttribute("item", new Item());
		model.addAttribute("trackvalues", trackerRepository.findAll());
		return "additem";
	}
	
	// 'Item' -olion tallennuspyyntö.
	@RequestMapping(value = "/saveitem", method = RequestMethod.POST)
	public String saveItem(Item item) {
		itemRepository.save(item);
		return "redirect:items";
	}
	
}
