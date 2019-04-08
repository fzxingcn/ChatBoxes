package com.chat.service;

import com.chat.entity.BoxesBean;

import java.util.List;

/**
 *
 */
public interface BoxesService {

    /**
     * 增加一个聊天室
     * @param boxesBean
     * @return
     */
    String addBoxes(BoxesBean boxesBean);

    /**
     * 根据自定义id查询指定聊天室信息
     * @param id
     * @return
     */
    BoxesBean findById(String id);

    /**
     * 根据条件查询所有的聊天室信息
     * @param boxesBean
     * @return
     */
    List<BoxesBean> findList(BoxesBean boxesBean);

    /**
     * 根据id删除指定的聊天室
     * @param id
     * @return
     */
    String deleteById(String id);

}
