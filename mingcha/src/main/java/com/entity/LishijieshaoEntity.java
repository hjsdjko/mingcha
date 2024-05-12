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
 * 茗茶历史
 *
 * @author 
 * @email
 */
@TableName("lishijieshao")
public class LishijieshaoEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public LishijieshaoEntity() {

	}

	public LishijieshaoEntity(T t) {
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
     * 历史编号
     */
    @ColumnInfo(comment="历史编号",type="varchar(200)")
    @TableField(value = "lishijieshao_uuid_number")

    private String lishijieshaoUuidNumber;


    /**
     * 茗茶历史名称
     */
    @ColumnInfo(comment="茗茶历史名称",type="varchar(200)")
    @TableField(value = "lishijieshao_name")

    private String lishijieshaoName;


    /**
     * 封面
     */
    @ColumnInfo(comment="封面",type="varchar(200)")
    @TableField(value = "lishijieshao_photo")

    private String lishijieshaoPhoto;


    /**
     * 资料
     */
    @ColumnInfo(comment="资料",type="varchar(200)")
    @TableField(value = "lishijieshao_file")

    private String lishijieshaoFile;


    /**
     * 茶叶类型
     */
    @ColumnInfo(comment="茶叶类型",type="int(11)")
    @TableField(value = "chaye_types")

    private Integer chayeTypes;


    /**
     * 起源地
     */
    @ColumnInfo(comment="起源地",type="varchar(200)")
    @TableField(value = "lishijieshao_qiyuandi")

    private String lishijieshaoQiyuandi;


    /**
     * 起源时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="起源时间",type="timestamp")
    @TableField(value = "qiyuan_time")

    private Date qiyuanTime;


    /**
     * 茗茶历史详情
     */
    @ColumnInfo(comment="茗茶历史详情",type="longtext")
    @TableField(value = "lishijieshao_content")

    private String lishijieshaoContent;


    /**
     * 发布时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="发布时间",type="timestamp")
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
	 * 获取：历史编号
	 */
    public String getLishijieshaoUuidNumber() {
        return lishijieshaoUuidNumber;
    }
    /**
	 * 设置：历史编号
	 */

    public void setLishijieshaoUuidNumber(String lishijieshaoUuidNumber) {
        this.lishijieshaoUuidNumber = lishijieshaoUuidNumber;
    }
    /**
	 * 获取：茗茶历史名称
	 */
    public String getLishijieshaoName() {
        return lishijieshaoName;
    }
    /**
	 * 设置：茗茶历史名称
	 */

    public void setLishijieshaoName(String lishijieshaoName) {
        this.lishijieshaoName = lishijieshaoName;
    }
    /**
	 * 获取：封面
	 */
    public String getLishijieshaoPhoto() {
        return lishijieshaoPhoto;
    }
    /**
	 * 设置：封面
	 */

    public void setLishijieshaoPhoto(String lishijieshaoPhoto) {
        this.lishijieshaoPhoto = lishijieshaoPhoto;
    }
    /**
	 * 获取：资料
	 */
    public String getLishijieshaoFile() {
        return lishijieshaoFile;
    }
    /**
	 * 设置：资料
	 */

    public void setLishijieshaoFile(String lishijieshaoFile) {
        this.lishijieshaoFile = lishijieshaoFile;
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
	 * 获取：起源地
	 */
    public String getLishijieshaoQiyuandi() {
        return lishijieshaoQiyuandi;
    }
    /**
	 * 设置：起源地
	 */

    public void setLishijieshaoQiyuandi(String lishijieshaoQiyuandi) {
        this.lishijieshaoQiyuandi = lishijieshaoQiyuandi;
    }
    /**
	 * 获取：起源时间
	 */
    public Date getQiyuanTime() {
        return qiyuanTime;
    }
    /**
	 * 设置：起源时间
	 */

    public void setQiyuanTime(Date qiyuanTime) {
        this.qiyuanTime = qiyuanTime;
    }
    /**
	 * 获取：茗茶历史详情
	 */
    public String getLishijieshaoContent() {
        return lishijieshaoContent;
    }
    /**
	 * 设置：茗茶历史详情
	 */

    public void setLishijieshaoContent(String lishijieshaoContent) {
        this.lishijieshaoContent = lishijieshaoContent;
    }
    /**
	 * 获取：发布时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 设置：发布时间
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
        return "Lishijieshao{" +
            ", id=" + id +
            ", lishijieshaoUuidNumber=" + lishijieshaoUuidNumber +
            ", lishijieshaoName=" + lishijieshaoName +
            ", lishijieshaoPhoto=" + lishijieshaoPhoto +
            ", lishijieshaoFile=" + lishijieshaoFile +
            ", chayeTypes=" + chayeTypes +
            ", lishijieshaoQiyuandi=" + lishijieshaoQiyuandi +
            ", qiyuanTime=" + DateUtil.convertString(qiyuanTime,"yyyy-MM-dd") +
            ", lishijieshaoContent=" + lishijieshaoContent +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
