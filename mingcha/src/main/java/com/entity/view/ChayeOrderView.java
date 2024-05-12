package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.ChayeOrderEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 茶叶订单
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("chaye_order")
public class ChayeOrderView extends ChayeOrderEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 订单类型的值
	*/
	@ColumnInfo(comment="订单类型的字典表值",type="varchar(200)")
	private String chayeOrderValue;
	/**
	* 支付类型的值
	*/
	@ColumnInfo(comment="支付类型的字典表值",type="varchar(200)")
	private String chayeOrderPaymentValue;

	//级联表 收货地址
					 
		/**
		* 收货地址 的 创建用户
		*/
		@ColumnInfo(comment="创建用户",type="int(20)")
		private Integer addressYonghuId;
		/**
		* 收货人
		*/

		@ColumnInfo(comment="收货人",type="varchar(200)")
		private String addressName;
		/**
		* 电话
		*/

		@ColumnInfo(comment="电话",type="varchar(200)")
		private String addressPhone;
		/**
		* 地址
		*/

		@ColumnInfo(comment="地址",type="varchar(200)")
		private String addressDizhi;
		/**
		* 是否默认地址
		*/
		@ColumnInfo(comment="是否默认地址",type="int(11)")
		private Integer isdefaultTypes;
			/**
			* 是否默认地址的值
			*/
			@ColumnInfo(comment="是否默认地址的字典表值",type="varchar(200)")
			private String isdefaultValue;
	//级联表 茶叶
		/**
		* 茶叶名称
		*/

		@ColumnInfo(comment="茶叶名称",type="varchar(200)")
		private String chayeName;
		/**
		* 茶叶编号
		*/

		@ColumnInfo(comment="茶叶编号",type="varchar(200)")
		private String chayeUuidNumber;
		/**
		* 茶叶照片
		*/

		@ColumnInfo(comment="茶叶照片",type="varchar(200)")
		private String chayePhoto;
		/**
		* 产茶地点
		*/

		@ColumnInfo(comment="产茶地点",type="varchar(200)")
		private String chayeAddress;
		/**
		* 赞
		*/

		@ColumnInfo(comment="赞",type="int(11)")
		private Integer zanNumber;
		/**
		* 踩
		*/

		@ColumnInfo(comment="踩",type="int(11)")
		private Integer caiNumber;
		/**
		* 茶叶类型
		*/
		@ColumnInfo(comment="茶叶类型",type="int(11)")
		private Integer chayeTypes;
			/**
			* 茶叶类型的值
			*/
			@ColumnInfo(comment="茶叶类型的字典表值",type="varchar(200)")
			private String chayeValue;
		/**
		* 茶叶库存
		*/

		@ColumnInfo(comment="茶叶库存",type="int(11)")
		private Integer chayeKucunNumber;
		/**
		* 茶叶原价
		*/
		@ColumnInfo(comment="茶叶原价",type="decimal(10,2)")
		private Double chayeOldMoney;
		/**
		* 现价/斤
		*/
		@ColumnInfo(comment="现价/斤",type="decimal(10,2)")
		private Double chayeNewMoney;
		/**
		* 所属仓库
		*/

		@ColumnInfo(comment="所属仓库",type="varchar(200)")
		private String chayeCangku;
		/**
		* 茶叶热度
		*/

		@ColumnInfo(comment="茶叶热度",type="int(11)")
		private Integer chayeClicknum;
		/**
		* 茶叶介绍
		*/

		@ColumnInfo(comment="茶叶介绍",type="longtext")
		private String chayeContent;
		/**
		* 是否上架
		*/
		@ColumnInfo(comment="是否上架",type="int(11)")
		private Integer shangxiaTypes;
			/**
			* 是否上架的值
			*/
			@ColumnInfo(comment="是否上架的字典表值",type="varchar(200)")
			private String shangxiaValue;
		/**
		* 逻辑删除
		*/

		@ColumnInfo(comment="逻辑删除",type="int(11)")
		private Integer chayeDelete;
	//级联表 用户
		/**
		* 用户姓名
		*/

		@ColumnInfo(comment="用户姓名",type="varchar(200)")
		private String yonghuName;
		/**
		* 用户手机号
		*/

		@ColumnInfo(comment="用户手机号",type="varchar(200)")
		private String yonghuPhone;
		/**
		* 用户身份证号
		*/

		@ColumnInfo(comment="用户身份证号",type="varchar(200)")
		private String yonghuIdNumber;
		/**
		* 用户头像
		*/

		@ColumnInfo(comment="用户头像",type="varchar(200)")
		private String yonghuPhoto;
		/**
		* 用户邮箱
		*/

		@ColumnInfo(comment="用户邮箱",type="varchar(200)")
		private String yonghuEmail;
		/**
		* 余额
		*/
		@ColumnInfo(comment="余额",type="decimal(10,2)")
		private Double newMoney;
		/**
		* 账户状态
		*/
		@ColumnInfo(comment="账户状态",type="int(11)")
		private Integer jinyongTypes;
			/**
			* 账户状态的值
			*/
			@ColumnInfo(comment="账户状态的字典表值",type="varchar(200)")
			private String jinyongValue;



	public ChayeOrderView() {

	}

	public ChayeOrderView(ChayeOrderEntity chayeOrderEntity) {
		try {
			BeanUtils.copyProperties(this, chayeOrderEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
	/**
	* 获取： 订单类型的值
	*/
	public String getChayeOrderValue() {
		return chayeOrderValue;
	}
	/**
	* 设置： 订单类型的值
	*/
	public void setChayeOrderValue(String chayeOrderValue) {
		this.chayeOrderValue = chayeOrderValue;
	}
	//当前表的
	/**
	* 获取： 支付类型的值
	*/
	public String getChayeOrderPaymentValue() {
		return chayeOrderPaymentValue;
	}
	/**
	* 设置： 支付类型的值
	*/
	public void setChayeOrderPaymentValue(String chayeOrderPaymentValue) {
		this.chayeOrderPaymentValue = chayeOrderPaymentValue;
	}


	//级联表的get和set 收货地址
		/**
		* 获取：收货地址 的 创建用户
		*/
		public Integer getAddressYonghuId() {
			return addressYonghuId;
		}
		/**
		* 设置：收货地址 的 创建用户
		*/
		public void setAddressYonghuId(Integer addressYonghuId) {
			this.addressYonghuId = addressYonghuId;
		}

		/**
		* 获取： 收货人
		*/
		public String getAddressName() {
			return addressName;
		}
		/**
		* 设置： 收货人
		*/
		public void setAddressName(String addressName) {
			this.addressName = addressName;
		}

		/**
		* 获取： 电话
		*/
		public String getAddressPhone() {
			return addressPhone;
		}
		/**
		* 设置： 电话
		*/
		public void setAddressPhone(String addressPhone) {
			this.addressPhone = addressPhone;
		}

		/**
		* 获取： 地址
		*/
		public String getAddressDizhi() {
			return addressDizhi;
		}
		/**
		* 设置： 地址
		*/
		public void setAddressDizhi(String addressDizhi) {
			this.addressDizhi = addressDizhi;
		}
		/**
		* 获取： 是否默认地址
		*/
		public Integer getIsdefaultTypes() {
			return isdefaultTypes;
		}
		/**
		* 设置： 是否默认地址
		*/
		public void setIsdefaultTypes(Integer isdefaultTypes) {
			this.isdefaultTypes = isdefaultTypes;
		}


			/**
			* 获取： 是否默认地址的值
			*/
			public String getIsdefaultValue() {
				return isdefaultValue;
			}
			/**
			* 设置： 是否默认地址的值
			*/
			public void setIsdefaultValue(String isdefaultValue) {
				this.isdefaultValue = isdefaultValue;
			}
	//级联表的get和set 茶叶

		/**
		* 获取： 茶叶名称
		*/
		public String getChayeName() {
			return chayeName;
		}
		/**
		* 设置： 茶叶名称
		*/
		public void setChayeName(String chayeName) {
			this.chayeName = chayeName;
		}

		/**
		* 获取： 茶叶编号
		*/
		public String getChayeUuidNumber() {
			return chayeUuidNumber;
		}
		/**
		* 设置： 茶叶编号
		*/
		public void setChayeUuidNumber(String chayeUuidNumber) {
			this.chayeUuidNumber = chayeUuidNumber;
		}

		/**
		* 获取： 茶叶照片
		*/
		public String getChayePhoto() {
			return chayePhoto;
		}
		/**
		* 设置： 茶叶照片
		*/
		public void setChayePhoto(String chayePhoto) {
			this.chayePhoto = chayePhoto;
		}

		/**
		* 获取： 产茶地点
		*/
		public String getChayeAddress() {
			return chayeAddress;
		}
		/**
		* 设置： 产茶地点
		*/
		public void setChayeAddress(String chayeAddress) {
			this.chayeAddress = chayeAddress;
		}

		/**
		* 获取： 赞
		*/
		public Integer getZanNumber() {
			return zanNumber;
		}
		/**
		* 设置： 赞
		*/
		public void setZanNumber(Integer zanNumber) {
			this.zanNumber = zanNumber;
		}

		/**
		* 获取： 踩
		*/
		public Integer getCaiNumber() {
			return caiNumber;
		}
		/**
		* 设置： 踩
		*/
		public void setCaiNumber(Integer caiNumber) {
			this.caiNumber = caiNumber;
		}
		/**
		* 获取： 茶叶类型
		*/
		public Integer getChayeTypes() {
			return chayeTypes;
		}
		/**
		* 设置： 茶叶类型
		*/
		public void setChayeTypes(Integer chayeTypes) {
			this.chayeTypes = chayeTypes;
		}


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

		/**
		* 获取： 茶叶库存
		*/
		public Integer getChayeKucunNumber() {
			return chayeKucunNumber;
		}
		/**
		* 设置： 茶叶库存
		*/
		public void setChayeKucunNumber(Integer chayeKucunNumber) {
			this.chayeKucunNumber = chayeKucunNumber;
		}

		/**
		* 获取： 茶叶原价
		*/
		public Double getChayeOldMoney() {
			return chayeOldMoney;
		}
		/**
		* 设置： 茶叶原价
		*/
		public void setChayeOldMoney(Double chayeOldMoney) {
			this.chayeOldMoney = chayeOldMoney;
		}

		/**
		* 获取： 现价/斤
		*/
		public Double getChayeNewMoney() {
			return chayeNewMoney;
		}
		/**
		* 设置： 现价/斤
		*/
		public void setChayeNewMoney(Double chayeNewMoney) {
			this.chayeNewMoney = chayeNewMoney;
		}

		/**
		* 获取： 所属仓库
		*/
		public String getChayeCangku() {
			return chayeCangku;
		}
		/**
		* 设置： 所属仓库
		*/
		public void setChayeCangku(String chayeCangku) {
			this.chayeCangku = chayeCangku;
		}

		/**
		* 获取： 茶叶热度
		*/
		public Integer getChayeClicknum() {
			return chayeClicknum;
		}
		/**
		* 设置： 茶叶热度
		*/
		public void setChayeClicknum(Integer chayeClicknum) {
			this.chayeClicknum = chayeClicknum;
		}

		/**
		* 获取： 茶叶介绍
		*/
		public String getChayeContent() {
			return chayeContent;
		}
		/**
		* 设置： 茶叶介绍
		*/
		public void setChayeContent(String chayeContent) {
			this.chayeContent = chayeContent;
		}
		/**
		* 获取： 是否上架
		*/
		public Integer getShangxiaTypes() {
			return shangxiaTypes;
		}
		/**
		* 设置： 是否上架
		*/
		public void setShangxiaTypes(Integer shangxiaTypes) {
			this.shangxiaTypes = shangxiaTypes;
		}


			/**
			* 获取： 是否上架的值
			*/
			public String getShangxiaValue() {
				return shangxiaValue;
			}
			/**
			* 设置： 是否上架的值
			*/
			public void setShangxiaValue(String shangxiaValue) {
				this.shangxiaValue = shangxiaValue;
			}

		/**
		* 获取： 逻辑删除
		*/
		public Integer getChayeDelete() {
			return chayeDelete;
		}
		/**
		* 设置： 逻辑删除
		*/
		public void setChayeDelete(Integer chayeDelete) {
			this.chayeDelete = chayeDelete;
		}
	//级联表的get和set 用户

		/**
		* 获取： 用户姓名
		*/
		public String getYonghuName() {
			return yonghuName;
		}
		/**
		* 设置： 用户姓名
		*/
		public void setYonghuName(String yonghuName) {
			this.yonghuName = yonghuName;
		}

		/**
		* 获取： 用户手机号
		*/
		public String getYonghuPhone() {
			return yonghuPhone;
		}
		/**
		* 设置： 用户手机号
		*/
		public void setYonghuPhone(String yonghuPhone) {
			this.yonghuPhone = yonghuPhone;
		}

		/**
		* 获取： 用户身份证号
		*/
		public String getYonghuIdNumber() {
			return yonghuIdNumber;
		}
		/**
		* 设置： 用户身份证号
		*/
		public void setYonghuIdNumber(String yonghuIdNumber) {
			this.yonghuIdNumber = yonghuIdNumber;
		}

		/**
		* 获取： 用户头像
		*/
		public String getYonghuPhoto() {
			return yonghuPhoto;
		}
		/**
		* 设置： 用户头像
		*/
		public void setYonghuPhoto(String yonghuPhoto) {
			this.yonghuPhoto = yonghuPhoto;
		}

		/**
		* 获取： 用户邮箱
		*/
		public String getYonghuEmail() {
			return yonghuEmail;
		}
		/**
		* 设置： 用户邮箱
		*/
		public void setYonghuEmail(String yonghuEmail) {
			this.yonghuEmail = yonghuEmail;
		}

		/**
		* 获取： 余额
		*/
		public Double getNewMoney() {
			return newMoney;
		}
		/**
		* 设置： 余额
		*/
		public void setNewMoney(Double newMoney) {
			this.newMoney = newMoney;
		}
		/**
		* 获取： 账户状态
		*/
		public Integer getJinyongTypes() {
			return jinyongTypes;
		}
		/**
		* 设置： 账户状态
		*/
		public void setJinyongTypes(Integer jinyongTypes) {
			this.jinyongTypes = jinyongTypes;
		}


			/**
			* 获取： 账户状态的值
			*/
			public String getJinyongValue() {
				return jinyongValue;
			}
			/**
			* 设置： 账户状态的值
			*/
			public void setJinyongValue(String jinyongValue) {
				this.jinyongValue = jinyongValue;
			}


	@Override
	public String toString() {
		return "ChayeOrderView{" +
			", chayeOrderValue=" + chayeOrderValue +
			", chayeOrderPaymentValue=" + chayeOrderPaymentValue +
			", addressName=" + addressName +
			", addressPhone=" + addressPhone +
			", addressDizhi=" + addressDizhi +
			", chayeName=" + chayeName +
			", chayeUuidNumber=" + chayeUuidNumber +
			", chayePhoto=" + chayePhoto +
			", chayeAddress=" + chayeAddress +
			", zanNumber=" + zanNumber +
			", caiNumber=" + caiNumber +
			", chayeKucunNumber=" + chayeKucunNumber +
			", chayeOldMoney=" + chayeOldMoney +
			", chayeNewMoney=" + chayeNewMoney +
			", chayeCangku=" + chayeCangku +
			", chayeClicknum=" + chayeClicknum +
			", chayeContent=" + chayeContent +
			", chayeDelete=" + chayeDelete +
			", yonghuName=" + yonghuName +
			", yonghuPhone=" + yonghuPhone +
			", yonghuIdNumber=" + yonghuIdNumber +
			", yonghuPhoto=" + yonghuPhoto +
			", yonghuEmail=" + yonghuEmail +
			", newMoney=" + newMoney +
			"} " + super.toString();
	}
}
