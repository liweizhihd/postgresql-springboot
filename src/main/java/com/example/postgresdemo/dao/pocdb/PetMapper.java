package com.example.postgresdemo.dao.pocdb;

import com.example.postgresdemo.bean.PO.PetPO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @Auther: liweizhi
 * @Date: 2019/5/24 17:03
 * @Description:
 */
@Mapper
@Repository
public interface PetMapper {
    List<PetPO> getAll();
    List<PetPO> getAllByCond(Map<String, Object> cond);

    int addPets(List<PetPO> pets);
}
