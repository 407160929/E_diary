package com.group.e_diary.generator.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * 
 * 
 * @author xuan
 * @email 407160929@qq.com
 * @date 2023-11-22 19:13:26
 */
@Data
@TableName("diary")
public class DiaryEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Long id;
	/**
	 * 
	 */
	private Long userId;
	/**
	 * 
	 */
	private String name;
	/**
	 * 
	 */
	private String icon;
	/**
	 * 
	 */
	@TableLogic
	private Integer isDelete;
	/**
	 * 
	 */
	private Integer isPrivate;
	/**
	 * 
	 */
	private Integer likes;
	private String description;
	/**
	 * 
	 */
	private Integer uses;
	/**
	 * 
	 */
	@TableField(fill = FieldFill.INSERT)
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date createTime;
	/**
	 * 
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date updateTime;

}
