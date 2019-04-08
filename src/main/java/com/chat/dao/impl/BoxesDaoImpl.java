package com.chat.dao.impl;

import com.chat.dao.BoxesDao;
import com.chat.entity.BoxesBean;
import com.chat.entity.UsersBean;
import com.chat.service.BoxesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoxesDaoImpl implements BoxesDao {

    private final String SUCCESS="succcess";

    @Autowired
    MongoOperations mongoTemplate;


    @Override
    public String addBoxes(BoxesBean boxesBean) {
        mongoTemplate.save(boxesBean);
        return SUCCESS;
    }

    @Override
    public BoxesBean findById(String id) {
        return  mongoTemplate.findById( new Query(Criteria.where("boxeId").is(id)), BoxesBean.class);
    }

    @Override
    public List<BoxesBean> findList(BoxesBean boxesBean) {
        return null;
    }

    @Override
    public String deleteById(String id) {
        return null;
    }
}
