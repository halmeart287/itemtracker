package hh0.itemtracker.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import hh0.itemtracker.domain.Tracker;
import hh0.itemtracker.domain.TrackerRepository;


// Kontrolleri 'Tracking' -luokkaoliolle.
@Controller
public class TrackerController {

	@Autowired
	private TrackerRepository trackerRepository;
	
	@RequestMapping(value = "/trackvalues", method = RequestMethod.GET)
	public String getTrackValues(Model model) {
		List<Tracker> trackvalues = (List<Tracker>) trackerRepository.findAll();
		model.addAttribute("trackvalues", trackvalues);
		return "trackvalues";
	}
}
