package com.entity.model;

import com.entity.LishijieshaoEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 茗茶历史
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class LishijieshaoModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 历史编号
     */
    private String lishijieshaoUuidNumber;


    /**
     * 茗茶历史名称
     */
    private String lishijieshaoName;


    /**
     * 封面
     */
    private String lishijieshaoPhoto;


    /**
     * 资料
     */
    private String lishijieshaoFile;


    /**
     * 茶叶类型
     */
    private Integer chayeTypes;


    /**
     * 起源地
     */
    private String lishijieshaoQiyuandi;


    /**
     * 起源时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date qiyuanTime;


    /**
     * 茗茶历史详情
     */
    private String lishijieshaoContent;


    /**
     * 发布时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间 show1 show2 photoShow
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
	 * 获取：创建时间 show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间 show1 show2 photoShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
