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
@TableName("resource")
public class ResourceEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Long id;
	/**
	 * 
	 */
	private Integer type;
	/**
	 * 
	 */
	private String name;
	/**
	 * 
	 */
	private Long userId;
	/**
	 * 
	 */
	private Integer isPrivate;
	/**
	 * 
	 */
	private Integer isDelete;
	/**
	 * 
	 */
	private Integer likes;
	/**
	 * 
	 */
	private Integer uses;
	/**
	 * 
	 */
	private String content;

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
