package casestudy.controller;

import casestudy.dto.ISumDto;
import casestudy.model.contract.ContractDetail;
import casestudy.service.contract.IContracDetailService;
import casestudy.service.contract.IContractService;
import casestudy.service.impl.contract.AttachFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin("*")
@RestController
@RequestMapping("/contractdetaildto")
public class ContractDetailDtoController {
    @Autowired
    private IContracDetailService contracDetailService;
    @Autowired
    private IContractService contractService;

    @Autowired
    private AttachFacilityService attachFacilityService;

    @GetMapping("/view/{id}")
    public ResponseEntity<List<ContractDetail>> viewContractDetail(@PathVariable int id) {
        List<ContractDetail> contractDetailList =contracDetailService.findListcontractId(id);
        if (contractDetailList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(contractDetailList, HttpStatus.OK);
    }
    @GetMapping("/viewContractDetail")
    public ResponseEntity<List<ContractDetail>> viewContractDetailIII() {
        List<ContractDetail> contractDetailList =contracDetailService.findListAll();
        if (contractDetailList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(contractDetailList, HttpStatus.OK);
    }

    @GetMapping("/hello/{id}")
    public ResponseEntity<List<ISumDto>> viewHello(@PathVariable int id) {

        List<ISumDto> contractDetailList =contracDetailService.findListByCustomerId(id);


        if (contractDetailList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(contractDetailList, HttpStatus.OK);
    }


}
