package com.entity.vo;

import com.entity.LishijieshaoEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 茗茶历史
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("lishijieshao")
public class LishijieshaoVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 历史编号
     */

    @TableField(value = "lishijieshao_uuid_number")
    private String lishijieshaoUuidNumber;


    /**
     * 茗茶历史名称
     */

    @TableField(value = "lishijieshao_name")
    private String lishijieshaoName;


    /**
     * 封面
     */

    @TableField(value = "lishijieshao_photo")
    private String lishijieshaoPhoto;


    /**
     * 资料
     */

    @TableField(value = "lishijieshao_file")
    private String lishijieshaoFile;


    /**
     * 茶叶类型
     */

    @TableField(value = "chaye_types")
    private Integer chayeTypes;


    /**
     * 起源地
     */

    @TableField(value = "lishijieshao_qiyuandi")
    private String lishijieshaoQiyuandi;


    /**
     * 起源时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "qiyuan_time")
    private Date qiyuanTime;


    /**
     * 茗茶历史详情
     */

    @TableField(value = "lishijieshao_content")
    private String lishijieshaoContent;


    /**
     * 发布时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间 show1 show2 photoShow
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
	 * 设置：历史编号
	 */
    public String getLishijieshaoUuidNumber() {
        return lishijieshaoUuidNumber;
    }


    /**
	 * 获取：历史编号
	 */

    public void setLishijieshaoUuidNumber(String lishijieshaoUuidNumber) {
        this.lishijieshaoUuidNumber = lishijieshaoUuidNumber;
    }
    /**
	 * 设置：茗茶历史名称
	 */
    public String getLishijieshaoName() {
        return lishijieshaoName;
    }


    /**
	 * 获取：茗茶历史名称
	 */

    public void setLishijieshaoName(String lishijieshaoName) {
        this.lishijieshaoName = lishijieshaoName;
    }
    /**
	 * 设置：封面
	 */
    public String getLishijieshaoPhoto() {
        return lishijieshaoPhoto;
    }


    /**
	 * 获取：封面
	 */

    public void setLishijieshaoPhoto(String lishijieshaoPhoto) {
        this.lishijieshaoPhoto = lishijieshaoPhoto;
    }
    /**
	 * 设置：资料
	 */
    public String getLishijieshaoFile() {
        return lishijieshaoFile;
    }


    /**
	 * 获取：资料
	 */

    public void setLishijieshaoFile(String lishijieshaoFile) {
        this.lishijieshaoFile = lishijieshaoFile;
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
	 * 设置：起源地
	 */
    public String getLishijieshaoQiyuandi() {
        return lishijieshaoQiyuandi;
    }


    /**
	 * 获取：起源地
	 */

    public void setLishijieshaoQiyuandi(String lishijieshaoQiyuandi) {
        this.lishijieshaoQiyuandi = lishijieshaoQiyuandi;
    }
    /**
	 * 设置：起源时间
	 */
    public Date getQiyuanTime() {
        return qiyuanTime;
    }


    /**
	 * 获取：起源时间
	 */

    public void setQiyuanTime(Date qiyuanTime) {
        this.qiyuanTime = qiyuanTime;
    }
    /**
	 * 设置：茗茶历史详情
	 */
    public String getLishijieshaoContent() {
        return lishijieshaoContent;
    }


    /**
	 * 获取：茗茶历史详情
	 */

    public void setLishijieshaoContent(String lishijieshaoContent) {
        this.lishijieshaoContent = lishijieshaoContent;
    }
    /**
	 * 设置：发布时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：发布时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：创建时间 show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间 show1 show2 photoShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
