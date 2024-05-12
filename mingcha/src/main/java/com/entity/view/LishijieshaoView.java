package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.LishijieshaoEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 茗茶历史
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("lishijieshao")
public class LishijieshaoView extends LishijieshaoEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 茶叶类型的值
	*/
	@ColumnInfo(comment="茶叶类型的字典表值",type="varchar(200)")
	private String chayeValue;




	public LishijieshaoView() {

	}

	public LishijieshaoView(LishijieshaoEntity lishijieshaoEntity) {
		try {
			BeanUtils.copyProperties(this, lishijieshaoEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
	/**
	* 获取： 茶叶类型的值
	*/
	public String getChayeValue() {
		return chayeValue;
	}
	/**
	* 设置： 茶叶类型的值
	*/
	public void setChayeValue(String chayeValue) {
		this.chayeValue = chayeValue;
	}




	@Override
	public String toString() {
		return "LishijieshaoView{" +
			", chayeValue=" + chayeValue +
			"} " + super.toString();
	}
}
