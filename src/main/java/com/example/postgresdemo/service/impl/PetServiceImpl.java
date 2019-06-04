package com.example.postgresdemo.service.impl;

import com.example.postgresdemo.bean.PO.PetPO;
import com.example.postgresdemo.dao.pocdb.PetMapper;
import com.example.postgresdemo.service.IPetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @Auther: liweizhi
 * @Date: 2019/5/24 17:04
 * @Description:
 */
@Service
public class PetServiceImpl implements IPetService {
    @Autowired
    private PetMapper petMapper;

    @Override
    public List<PetPO> getAllPet() {
        return petMapper.getAll();
    }

    @Override
    public List<PetPO> getAllPetByCond(Map<String, Object> cond) {
        return petMapper.getAllByCond(cond);
    }

    @Override
    public int addPets(List<PetPO> pets) {
        return petMapper.addPets(pets);
    }
}
