package innowisegroup.springwebapp.controller;

import innowisegroup.springwebapp.model.Flat;
import innowisegroup.springwebapp.service.RealEstateService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/realty")
@RequiredArgsConstructor
public class RealEstateMvcController {

    private final RealEstateService realEstateService;

    @GetMapping
    public String getAll(Model model) {
        model.addAttribute("realty", realEstateService.getAllRealty());
        return "realty-table";
    }

    @GetMapping(value = "/add/flat")
    public String getAddPage(Model model) {
        model.addAttribute("flat", new Flat());
        return "realty-add";
    }

    @PostMapping(value = "add/flat")
    public String addFlat(@ModelAttribute Flat flat) {
        realEstateService.save(flat);
        return "redirect:/";
    }
}
