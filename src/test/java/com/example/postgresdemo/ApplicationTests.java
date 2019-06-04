package com.example.postgresdemo;

import com.example.postgresdemo.bean.PO.PetPO;
import com.example.postgresdemo.service.IPetService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class ApplicationTests {

    @Autowired
    private IPetService petService;

    @Test
    public void getPets() {
        List<PetPO> ret = petService.getAllPet();
        log.info("getAll ret : {}", ret);
    }

    @Test
    public void getPetsByCond() {
        Map<String, Object> cond = new HashMap<>(16);
        cond.put("name", "dahuang");
        cond.put("age", 3);
        List<PetPO> ret = petService.getAllPetByCond(cond);
        log.info("getPetsByCond cond:{} \n ret : {}", cond, ret);
    }

    @Test
    public void insertPet() {
        List<PetPO> list = new ArrayList<PetPO>() {{
            for (int i = 0; i < 100; i++) {
                add(new PetPO("dahei", i, "black"));
                add(new PetPO("laobai", i, "white"));
                if (i != 3) {
                    add(new PetPO("dahuang", i, "yellow"));
                }
            }
        }};
        int ret = petService.addPets(list);
        System.out.println(ret);
    }

}
