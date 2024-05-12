package com.entity.vo;

import com.entity.ChayeEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 茶叶
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("chaye")
public class ChayeVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 茶叶名称
     */

    @TableField(value = "chaye_name")
    private String chayeName;


    /**
     * 茶叶编号
     */

    @TableField(value = "chaye_uuid_number")
    private String chayeUuidNumber;


    /**
     * 茶叶照片
     */

    @TableField(value = "chaye_photo")
    private String chayePhoto;


    /**
     * 产茶地点
     */

    @TableField(value = "chaye_address")
    private String chayeAddress;


    /**
     * 赞
     */

    @TableField(value = "zan_number")
    private Integer zanNumber;


    /**
     * 踩
     */

    @TableField(value = "cai_number")
    private Integer caiNumber;


    /**
     * 茶叶类型
     */

    @TableField(value = "chaye_types")
    private Integer chayeTypes;


    /**
     * 茶叶库存
     */

    @TableField(value = "chaye_kucun_number")
    private Integer chayeKucunNumber;


    /**
     * 茶叶原价
     */

    @TableField(value = "chaye_old_money")
    private Double chayeOldMoney;


    /**
     * 现价/斤
     */

    @TableField(value = "chaye_new_money")
    private Double chayeNewMoney;


    /**
     * 所属仓库
     */

    @TableField(value = "chaye_cangku")
    private String chayeCangku;


    /**
     * 茶叶热度
     */

    @TableField(value = "chaye_clicknum")
    private Integer chayeClicknum;


    /**
     * 茶叶介绍
     */

    @TableField(value = "chaye_content")
    private String chayeContent;


    /**
     * 是否上架
     */

    @TableField(value = "shangxia_types")
    private Integer shangxiaTypes;


    /**
     * 逻辑删除
     */

    @TableField(value = "chaye_delete")
    private Integer chayeDelete;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间  show1 show2 photoShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：茶叶名称
	 */
    public String getChayeName() {
        return chayeName;
    }


    /**
	 * 获取：茶叶名称
	 */

    public void setChayeName(String chayeName) {
        this.chayeName = chayeName;
    }
    /**
	 * 设置：茶叶编号
	 */
    public String getChayeUuidNumber() {
        return chayeUuidNumber;
    }


    /**
	 * 获取：茶叶编号
	 */

    public void setChayeUuidNumber(String chayeUuidNumber) {
        this.chayeUuidNumber = chayeUuidNumber;
    }
    /**
	 * 设置：茶叶照片
	 */
    public String getChayePhoto() {
        return chayePhoto;
    }


    /**
	 * 获取：茶叶照片
	 */

    public void setChayePhoto(String chayePhoto) {
        this.chayePhoto = chayePhoto;
    }
    /**
	 * 设置：产茶地点
	 */
    public String getChayeAddress() {
        return chayeAddress;
    }


    /**
	 * 获取：产茶地点
	 */

    public void setChayeAddress(String chayeAddress) {
        this.chayeAddress = chayeAddress;
    }
    /**
	 * 设置：赞
	 */
    public Integer getZanNumber() {
        return zanNumber;
    }


    /**
	 * 获取：赞
	 */

    public void setZanNumber(Integer zanNumber) {
        this.zanNumber = zanNumber;
    }
    /**
	 * 设置：踩
	 */
    public Integer getCaiNumber() {
        return caiNumber;
    }


    /**
	 * 获取：踩
	 */

    public void setCaiNumber(Integer caiNumber) {
        this.caiNumber = caiNumber;
    }
    /**
	 * 设置：茶叶类型
	 */
    public Integer getChayeTypes() {
        return chayeTypes;
    }


    /**
	 * 获取：茶叶类型
	 */

    public void setChayeTypes(Integer chayeTypes) {
        this.chayeTypes = chayeTypes;
    }
    /**
	 * 设置：茶叶库存
	 */
    public Integer getChayeKucunNumber() {
        return chayeKucunNumber;
    }


    /**
	 * 获取：茶叶库存
	 */

    public void setChayeKucunNumber(Integer chayeKucunNumber) {
        this.chayeKucunNumber = chayeKucunNumber;
    }
    /**
	 * 设置：茶叶原价
	 */
    public Double getChayeOldMoney() {
        return chayeOldMoney;
    }


    /**
	 * 获取：茶叶原价
	 */

    public void setChayeOldMoney(Double chayeOldMoney) {
        this.chayeOldMoney = chayeOldMoney;
    }
    /**
	 * 设置：现价/斤
	 */
    public Double getChayeNewMoney() {
        return chayeNewMoney;
    }


    /**
	 * 获取：现价/斤
	 */

    public void setChayeNewMoney(Double chayeNewMoney) {
        this.chayeNewMoney = chayeNewMoney;
    }
    /**
	 * 设置：所属仓库
	 */
    public String getChayeCangku() {
        return chayeCangku;
    }


    /**
	 * 获取：所属仓库
	 */

    public void setChayeCangku(String chayeCangku) {
        this.chayeCangku = chayeCangku;
    }
    /**
	 * 设置：茶叶热度
	 */
    public Integer getChayeClicknum() {
        return chayeClicknum;
    }


    /**
	 * 获取：茶叶热度
	 */

    public void setChayeClicknum(Integer chayeClicknum) {
        this.chayeClicknum = chayeClicknum;
    }
    /**
	 * 设置：茶叶介绍
	 */
    public String getChayeContent() {
        return chayeContent;
    }


    /**
	 * 获取：茶叶介绍
	 */

    public void setChayeContent(String chayeContent) {
        this.chayeContent = chayeContent;
    }
    /**
	 * 设置：是否上架
	 */
    public Integer getShangxiaTypes() {
        return shangxiaTypes;
    }


    /**
	 * 获取：是否上架
	 */

    public void setShangxiaTypes(Integer shangxiaTypes) {
        this.shangxiaTypes = shangxiaTypes;
    }
    /**
	 * 设置：逻辑删除
	 */
    public Integer getChayeDelete() {
        return chayeDelete;
    }


    /**
	 * 获取：逻辑删除
	 */

    public void setChayeDelete(Integer chayeDelete) {
        this.chayeDelete = chayeDelete;
    }
    /**
	 * 设置：录入时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：录入时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：创建时间  show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间  show1 show2 photoShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
