package casestudy.controller;

import casestudy.model.contract.Contract;
import casestudy.model.contract.ContractDetail;
import casestudy.model.customer.Customer;
import casestudy.model.employee.Employee;
import casestudy.model.facility.Facility;
import casestudy.service.contract.IAttachFacilityService;
import casestudy.service.contract.IContracDetailService;
import casestudy.service.contract.IContractService;
import casestudy.service.customer.ICustomerService;
import casestudy.service.employee.IEmployeeService;
import casestudy.service.facility.IFacilityService;
import casestudy.service.impl.contract.AttachFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
@RequestMapping("/contract")
public class ContractController {

    @Autowired
    private IContractService contractService;
    @Autowired
    private IContracDetailService contracDetailService;

    @Autowired
    private IAttachFacilityService iAttachFacilityService;
    @Autowired
    private ICustomerService customerService;
    @Autowired
    private IFacilityService facilityService;

    @Autowired
    private IEmployeeService employeeService;

    @Autowired
    private AttachFacilityService attachFacilityService;


    @GetMapping("/list")
    public String goPage(Model model,
                         @PageableDefault(6) Pageable pageable,
                         @RequestParam Optional<String> name) throws Exception {
        for (Sort.Order order : pageable.getSort()) {
            model.addAttribute("sortValue", order.getProperty());
        }
        String keyName = name.orElse("");

        Page<Contract> contractPage = contractService.findPageAll(pageable);

        model.addAttribute("contractPage", contractPage);
        model.addAttribute("name", keyName);
        if (contractPage.isEmpty()) {
            throw new Exception();
        } else {
            return "/contract/list";
        }
    }

    @GetMapping("/create")
    public String create(Model model) {

        List<Customer> customerList = customerService.findListAll();
        List<Facility> facilityList = facilityService.findListAll();
        List<Employee> employeeList = employeeService.findListAll();

        model.addAttribute("customerList", customerList);
        model.addAttribute("facilityList", facilityList);
        model.addAttribute("employeeList", employeeList);

        model.addAttribute("contract", new Contract());

        return "/contract/create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Contract contract) {

        contractService.save(contract);

        return "redirect:/contract/list";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable int id, Model model) {

        List<Customer> customerList = customerService.findListAll();
        List<Facility> facilityList = facilityService.findListAll();
        List<Employee> employeeList = employeeService.findListAll();

        model.addAttribute("customerList", customerList);
        model.addAttribute("facilityList", facilityList);
        model.addAttribute("employeeList", employeeList);
        model.addAttribute("contract", contractService.findById(id));

        return "/contract/edit";
    }

    @PostMapping("/update")
    public String update(Contract contract) {
        contractService.update(contract);
        return "redirect:/contract/list";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam(name = "stringArr") String stringArr) {
        String[] arr = null;
        arr = stringArr.split(",");//1,1,3

        Map<Integer, Integer> map = new TreeMap<Integer, Integer>();
        for (int i = 0; i < arr.length; i++) {
            addElement(map, Integer.parseInt(arr[i]));
        }
        for (Integer key : map.keySet()) {
            if(map.get(key)%2!=0){
                    contractService.remove(key);
            }
        }
        return "redirect:/contract/list";

    }
    public static void addElement(Map<Integer, Integer> map, int element) {
        if (map.containsKey(element)) {
            int count = map.get(element) + 1;
            map.put(element, count);
        } else {
            map.put(element, 1);
        }
    }

//        ĐỨc
//        List<Integer> arrInt = new ArrayList<>();
//        int count = 0;
//        int newa = 0;
//        for (int i = 0; i < arr.length; i++) {
//            for (int j = 0; j < arr.length; j++) {
//                if (arr[i] == arr[j]) {
//                    count = count + 1;
//                     newa = Integer.parseInt(arr[j]);
//                }
//            }
//        }   if (count % 2 != 0) {
//            arrInt.add(newa);
//        }
//        System.out.printf(arrInt.toString());
//        for (int i = 0; i < arrInt.size(); i++) {
//            contractService.remove(arrInt.get(i));
//        }
//
//        return "redirect:/contract/list";
//    }

    @GetMapping("/themMoi/{id}")
    public String create(Model model, @PathVariable int id) {

        ContractDetail contractDetail = new ContractDetail();

        model.addAttribute("attachFacilityList", attachFacilityService.findListAll());
        model.addAttribute("ContractDetail", contractDetail);
        model.addAttribute("contract", contractService.findById(id));


        return "/contract/createContractDetail";
    }

    @PostMapping("/luu")
    public String save(@ModelAttribute ContractDetail contractDetail) {
        contracDetailService.save(contractDetail);
        return "redirect:/contract/list";
    }

    @ExceptionHandler(value = Exception.class)
    public String error() {
        return "/error";
    }

}
