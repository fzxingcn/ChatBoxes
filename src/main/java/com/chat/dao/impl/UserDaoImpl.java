package com.chat.dao.impl;

import com.chat.dao.UsersDao;
import com.chat.entity.UsersBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import java.util.List;


@Component("userService")
public class UserDaoImpl implements UsersDao {
    @Autowired
    MongoOperations mongoTemplate;

    @Override
    public void saveUser(UsersBean users) {
        mongoTemplate.save(users);
    }

    @Override
    public UsersBean findUserByName(String id,String value) {
        return mongoTemplate.findOne(
                new Query(Criteria.where(id).is(value)), UsersBean.class);
    }

    @Override
    public void removeUser(String key,String value) {
        mongoTemplate.remove(new Query(Criteria.where(key).is(value)),
                UsersBean.class);
    }

    @Override
    public void updateUser(String name, String key, String value) {
        mongoTemplate.updateFirst(new Query(Criteria.where("name").is(name)),
                Update.update(key, value), UsersBean.class);

    }

    @Override
    public List<UsersBean> listUser(String key,String value) {
        return mongoTemplate.findAll(UsersBean.class);

    }
}