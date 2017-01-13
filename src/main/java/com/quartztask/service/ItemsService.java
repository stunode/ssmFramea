package com.quartztask.service;

import com.quartztask.entity.Items;

import java.util.List;
/**
 *function：ItemsService
 * 商品管理服务
*/
public interface ItemsService {
    //商品查询列表
    Items findItemsById(Integer itemsId)  ;
}
