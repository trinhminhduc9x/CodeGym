package casestudy.controller;

import casestudy.model.customer.Customer;
import casestudy.model.customer.CustomerType;
import casestudy.model.facility.Facility;
import casestudy.model.facility.FacilityType;
import casestudy.model.facility.RentType;
import casestudy.service.customer.ICustomerService;
import casestudy.service.customer.ICustomerTypeService;
import casestudy.service.facility.IFacilityService;
import casestudy.service.facility.IFacilityTypeService;
import casestudy.service.facility.IRentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/facility")
public class FacilityController {
    @Autowired
    private IFacilityService facilityService;
    @Autowired
    private IFacilityTypeService facilityTypeService;
    @Autowired
    private IRentTypeService iRentTypeService;


    @GetMapping("/list")
    public String goPage(Model model,
                         @PageableDefault(6) Pageable pageable,
                         @RequestParam Optional<String> name,
                         @RequestParam(required = false, defaultValue = "") String FacilityTypeID )throws Exception {
        for (Sort.Order order : pageable.getSort()) {
            model.addAttribute("sortValue", order.getProperty());
        }
        String keyName = name.orElse("");

        Page<Facility> facilityPage = facilityService.findPageNameFacilityType(pageable,keyName,FacilityTypeID);

        List<FacilityType> facilityTypeList = facilityTypeService.findListAll();

        List<RentType> rentTypeList = iRentTypeService.findListAll();
        model.addAttribute("facilityTypeList", facilityTypeList);
        model.addAttribute("rentTypeList", rentTypeList);
        model.addAttribute("facilityPage", facilityPage);
        model.addAttribute("name", keyName);

        if (facilityPage.isEmpty()) {
            throw new Exception();
        } else {
            return "/facility/list";
        }
    }
    @GetMapping("/create")
    public String create(Model model) {

        List<FacilityType> facilityTypeList =facilityTypeService.findListAll();

        List<RentType> rentTypeList =iRentTypeService.findListAll();

        model.addAttribute("facilityTypeList", facilityTypeList);

        model.addAttribute("rentTypeList", rentTypeList);

        model.addAttribute("facility", new Facility());


        return "/facility/create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Facility facility) {

        facilityService.save(facility);

        return "redirect:/facility/list";
    }
    @GetMapping("/{id}/edit")
    public String edit(@PathVariable int id, Model model) {

        model.addAttribute("facility", facilityService.findById(id));
        model.addAttribute("facilityType", facilityTypeService.findListAll());
        model.addAttribute("rentTypeL", iRentTypeService.findListAll());
        return "/facility/edit";
    }

    @PostMapping("/update")
    public String update(Facility facility) {
        facilityService.update(facility);
        return "redirect:/facility/list";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam(name = "id") Integer id) {
        facilityService.remove(id);
        return "redirect:/facility/list";
    }


    @ExceptionHandler(value = Exception.class)
    public String error() {
        return "/error";
    }

}
