package com.entity;

import com.annotation.ColumnInfo;
import javax.validation.constraints.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;
import java.io.Serializable;
import java.util.*;
import org.apache.tools.ant.util.DateUtils;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.utils.DateUtil;


/**
 * 茶叶
 *
 * @author 
 * @email
 */
@TableName("chaye")
public class ChayeEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public ChayeEntity() {

	}

	public ChayeEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @ColumnInfo(comment="主键",type="int(11)")
    @TableField(value = "id")

    private Integer id;


    /**
     * 茶叶名称
     */
    @ColumnInfo(comment="茶叶名称",type="varchar(200)")
    @TableField(value = "chaye_name")

    private String chayeName;


    /**
     * 茶叶编号
     */
    @ColumnInfo(comment="茶叶编号",type="varchar(200)")
    @TableField(value = "chaye_uuid_number")

    private String chayeUuidNumber;


    /**
     * 茶叶照片
     */
    @ColumnInfo(comment="茶叶照片",type="varchar(200)")
    @TableField(value = "chaye_photo")

    private String chayePhoto;


    /**
     * 产茶地点
     */
    @ColumnInfo(comment="产茶地点",type="varchar(200)")
    @TableField(value = "chaye_address")

    private String chayeAddress;


    /**
     * 赞
     */
    @ColumnInfo(comment="赞",type="int(11)")
    @TableField(value = "zan_number")

    private Integer zanNumber;


    /**
     * 踩
     */
    @ColumnInfo(comment="踩",type="int(11)")
    @TableField(value = "cai_number")

    private Integer caiNumber;


    /**
     * 茶叶类型
     */
    @ColumnInfo(comment="茶叶类型",type="int(11)")
    @TableField(value = "chaye_types")

    private Integer chayeTypes;


    /**
     * 茶叶库存
     */
    @ColumnInfo(comment="茶叶库存",type="int(11)")
    @TableField(value = "chaye_kucun_number")

    private Integer chayeKucunNumber;


    /**
     * 茶叶原价
     */
    @ColumnInfo(comment="茶叶原价",type="decimal(10,2)")
    @TableField(value = "chaye_old_money")

    private Double chayeOldMoney;


    /**
     * 现价/斤
     */
    @ColumnInfo(comment="现价/斤",type="decimal(10,2)")
    @TableField(value = "chaye_new_money")

    private Double chayeNewMoney;


    /**
     * 所属仓库
     */
    @ColumnInfo(comment="所属仓库",type="varchar(200)")
    @TableField(value = "chaye_cangku")

    private String chayeCangku;


    /**
     * 茶叶热度
     */
    @ColumnInfo(comment="茶叶热度",type="int(11)")
    @TableField(value = "chaye_clicknum")

    private Integer chayeClicknum;


    /**
     * 茶叶介绍
     */
    @ColumnInfo(comment="茶叶介绍",type="longtext")
    @TableField(value = "chaye_content")

    private String chayeContent;


    /**
     * 是否上架
     */
    @ColumnInfo(comment="是否上架",type="int(11)")
    @TableField(value = "shangxia_types")

    private Integer shangxiaTypes;


    /**
     * 逻辑删除
     */
    @ColumnInfo(comment="逻辑删除",type="int(11)")
    @TableField(value = "chaye_delete")

    private Integer chayeDelete;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="录入时间",type="timestamp")
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="创建时间",type="timestamp")
    @TableField(value = "create_time",fill = FieldFill.INSERT)

    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }
    /**
	 * 设置：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：茶叶名称
	 */
    public String getChayeName() {
        return chayeName;
    }
    /**
	 * 设置：茶叶名称
	 */

    public void setChayeName(String chayeName) {
        this.chayeName = chayeName;
    }
    /**
	 * 获取：茶叶编号
	 */
    public String getChayeUuidNumber() {
        return chayeUuidNumber;
    }
    /**
	 * 设置：茶叶编号
	 */

    public void setChayeUuidNumber(String chayeUuidNumber) {
        this.chayeUuidNumber = chayeUuidNumber;
    }
    /**
	 * 获取：茶叶照片
	 */
    public String getChayePhoto() {
        return chayePhoto;
    }
    /**
	 * 设置：茶叶照片
	 */

    public void setChayePhoto(String chayePhoto) {
        this.chayePhoto = chayePhoto;
    }
    /**
	 * 获取：产茶地点
	 */
    public String getChayeAddress() {
        return chayeAddress;
    }
    /**
	 * 设置：产茶地点
	 */

    public void setChayeAddress(String chayeAddress) {
        this.chayeAddress = chayeAddress;
    }
    /**
	 * 获取：赞
	 */
    public Integer getZanNumber() {
        return zanNumber;
    }
    /**
	 * 设置：赞
	 */

    public void setZanNumber(Integer zanNumber) {
        this.zanNumber = zanNumber;
    }
    /**
	 * 获取：踩
	 */
    public Integer getCaiNumber() {
        return caiNumber;
    }
    /**
	 * 设置：踩
	 */

    public void setCaiNumber(Integer caiNumber) {
        this.caiNumber = caiNumber;
    }
    /**
	 * 获取：茶叶类型
	 */
    public Integer getChayeTypes() {
        return chayeTypes;
    }
    /**
	 * 设置：茶叶类型
	 */

    public void setChayeTypes(Integer chayeTypes) {
        this.chayeTypes = chayeTypes;
    }
    /**
	 * 获取：茶叶库存
	 */
    public Integer getChayeKucunNumber() {
        return chayeKucunNumber;
    }
    /**
	 * 设置：茶叶库存
	 */

    public void setChayeKucunNumber(Integer chayeKucunNumber) {
        this.chayeKucunNumber = chayeKucunNumber;
    }
    /**
	 * 获取：茶叶原价
	 */
    public Double getChayeOldMoney() {
        return chayeOldMoney;
    }
    /**
	 * 设置：茶叶原价
	 */

    public void setChayeOldMoney(Double chayeOldMoney) {
        this.chayeOldMoney = chayeOldMoney;
    }
    /**
	 * 获取：现价/斤
	 */
    public Double getChayeNewMoney() {
        return chayeNewMoney;
    }
    /**
	 * 设置：现价/斤
	 */

    public void setChayeNewMoney(Double chayeNewMoney) {
        this.chayeNewMoney = chayeNewMoney;
    }
    /**
	 * 获取：所属仓库
	 */
    public String getChayeCangku() {
        return chayeCangku;
    }
    /**
	 * 设置：所属仓库
	 */

    public void setChayeCangku(String chayeCangku) {
        this.chayeCangku = chayeCangku;
    }
    /**
	 * 获取：茶叶热度
	 */
    public Integer getChayeClicknum() {
        return chayeClicknum;
    }
    /**
	 * 设置：茶叶热度
	 */

    public void setChayeClicknum(Integer chayeClicknum) {
        this.chayeClicknum = chayeClicknum;
    }
    /**
	 * 获取：茶叶介绍
	 */
    public String getChayeContent() {
        return chayeContent;
    }
    /**
	 * 设置：茶叶介绍
	 */

    public void setChayeContent(String chayeContent) {
        this.chayeContent = chayeContent;
    }
    /**
	 * 获取：是否上架
	 */
    public Integer getShangxiaTypes() {
        return shangxiaTypes;
    }
    /**
	 * 设置：是否上架
	 */

    public void setShangxiaTypes(Integer shangxiaTypes) {
        this.shangxiaTypes = shangxiaTypes;
    }
    /**
	 * 获取：逻辑删除
	 */
    public Integer getChayeDelete() {
        return chayeDelete;
    }
    /**
	 * 设置：逻辑删除
	 */

    public void setChayeDelete(Integer chayeDelete) {
        this.chayeDelete = chayeDelete;
    }
    /**
	 * 获取：录入时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 设置：录入时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 设置：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Chaye{" +
            ", id=" + id +
            ", chayeName=" + chayeName +
            ", chayeUuidNumber=" + chayeUuidNumber +
            ", chayePhoto=" + chayePhoto +
            ", chayeAddress=" + chayeAddress +
            ", zanNumber=" + zanNumber +
            ", caiNumber=" + caiNumber +
            ", chayeTypes=" + chayeTypes +
            ", chayeKucunNumber=" + chayeKucunNumber +
            ", chayeOldMoney=" + chayeOldMoney +
            ", chayeNewMoney=" + chayeNewMoney +
            ", chayeCangku=" + chayeCangku +
            ", chayeClicknum=" + chayeClicknum +
            ", chayeContent=" + chayeContent +
            ", shangxiaTypes=" + shangxiaTypes +
            ", chayeDelete=" + chayeDelete +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
