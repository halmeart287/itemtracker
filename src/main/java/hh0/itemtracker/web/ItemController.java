package hh0.itemtracker.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import hh0.itemtracker.domain.Item;
import hh0.itemtracker.domain.ItemRepository;
import hh0.itemtracker.domain.TrackerRepository;
import hh0.itemtracker.domain.User;

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
	public String getItemForm(Model model, User user) {
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

	// 'Item' -olion poisto.
	@PreAuthorize("hasAuthority('ARTTU')") // Security. Admin-ominaisuus.
	@RequestMapping(value = "/deleteitem/{itemId}", method = RequestMethod.GET)
	public String deleteItem(@PathVariable("itemId") Long itemId) {
		itemRepository.deleteById(itemId);
		return "redirect:../items";
	}

	// 'Item' -olion muokkaus.
	@RequestMapping(value = "/edititem/{itemId}", method = RequestMethod.GET)
	public String editItem(@PathVariable("itemId") Long itemId, Model model) {
		model.addAttribute("item", itemRepository.findById(itemId));
		model.addAttribute("trackvalues", trackerRepository.findAll());
		return "edititem";
	}

	// Login
	@RequestMapping(value = "/login")
	public String login() {
		return "login";
	}

	// To Do: Logout

	// ToDo: 'Item' -olion poistaminen tracking-listalta napin painalluksella ilman
	// erillistä muokkausikkunaa.

	/*
	 * @RequestMapping(value = "/removetrack", method = RequestMethod.POST) public
	 * String removeTrack(@PathVariable("itemId") Long itemId, Model model) {
	 * model.addAttribute("item", itemRepository.findById(itemId)); return "items";
	 * }
	 */

}
