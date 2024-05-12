package com.dao;

import com.entity.LishijieshaoEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.LishijieshaoView;

/**
 * 茗茶历史 Dao 接口
 *
 * @author 
 */
public interface LishijieshaoDao extends BaseMapper<LishijieshaoEntity> {

   List<LishijieshaoView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
