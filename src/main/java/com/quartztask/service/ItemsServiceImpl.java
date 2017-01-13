package com.quartztask.service;

import com.quartztask.dao.BaseDaoImpl;
import com.quartztask.entity.Items;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 商品服务
 */
@Service("itemsService")
public class ItemsServiceImpl extends BaseDaoImpl implements ItemsService{

    @Override
    public Items findItemsById(Integer itemsId) {
        return queryObjectById("items.selectByPrimaryKey",itemsId);
    }
}
