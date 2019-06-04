package com.example.postgresdemo.controller;

import com.example.postgresdemo.bean.PO.PetPO;
import com.example.postgresdemo.service.IPetService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther: liweizhi
 * @Date: 2019/4/28 11:28
 * @Description:
 */
@RestController
@RequestMapping("pet")
@Slf4j
public class PetController {
    @Autowired
    private IPetService petService;

    @GetMapping("getAll")
    public List<PetPO> getAll001() {
        List<PetPO> ret = petService.getAllPet();
        log.info("getAll ret : {}", ret);
        return ret;
    }

    @GetMapping("get/{name}/{age}")
    public List<PetPO> getByNameAge(@PathVariable("name") String name, @PathVariable("age") int age) {
        Map<String, Object> cond = new HashMap<>(16);
        cond.put("name", name);
        cond.put("age", age);
        List<PetPO> ret = petService.getAllPetByCond(cond);
        log.info("getByNameAge cond:{} \n ret : {}", cond, ret);
        return ret;
    }


}
