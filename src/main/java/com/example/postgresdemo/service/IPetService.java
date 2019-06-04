package com.example.postgresdemo.service;

import com.example.postgresdemo.bean.PO.PetPO;

import java.util.List;
import java.util.Map;

/**
 * @Auther: liweizhi
 * @Date: 2019/5/24 17:04
 * @Description:
 */
public interface IPetService {

    List<PetPO> getAllPet();
    List<PetPO> getAllPetByCond(Map<String, Object> cond);

    int addPets(List<PetPO> pets);
}
