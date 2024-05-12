package com.entity.model;

import com.entity.ChayeEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 茶叶
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class ChayeModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 茶叶名称
     */
    private String chayeName;


    /**
     * 茶叶编号
     */
    private String chayeUuidNumber;


    /**
     * 茶叶照片
     */
    private String chayePhoto;


    /**
     * 产茶地点
     */
    private String chayeAddress;


    /**
     * 赞
     */
    private Integer zanNumber;


    /**
     * 踩
     */
    private Integer caiNumber;


    /**
     * 茶叶类型
     */
    private Integer chayeTypes;


    /**
     * 茶叶库存
     */
    private Integer chayeKucunNumber;


    /**
     * 茶叶原价
     */
    private Double chayeOldMoney;


    /**
     * 现价/斤
     */
    private Double chayeNewMoney;


    /**
     * 所属仓库
     */
    private String chayeCangku;


    /**
     * 茶叶热度
     */
    private Integer chayeClicknum;


    /**
     * 茶叶介绍
     */
    private String chayeContent;


    /**
     * 是否上架
     */
    private Integer shangxiaTypes;


    /**
     * 逻辑删除
     */
    private Integer chayeDelete;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间  show1 show2 photoShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
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
	 * 获取：创建时间  show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间  show1 show2 photoShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
