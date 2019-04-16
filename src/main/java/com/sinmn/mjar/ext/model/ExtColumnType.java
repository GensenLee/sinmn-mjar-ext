package com.sinmn.mjar.ext.model;

import java.util.ArrayList;
import java.util.List;

import com.sinmn.core.model.annotation.Column;
import com.sinmn.core.model.annotation.Table;
import com.sinmn.core.utils.vo.BaseBean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Table(table="ext_column_type",create=true,comment="字段扩展类型")
@Data
@EqualsAndHashCode(callSuper=false)
@ApiModel(value = "字段扩展类型",description="字段扩展类型")
public class ExtColumnType extends BaseBean{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/** 流水号 */
	public static final String ID = "id";
	/** 扩增类型名字 */
	public static final String NAME = "name";
	/** 扩增类型code值 */
	public static final String CODE = "code";
	/** 备注 */
	public static final String REMARK = "remark";

	@SuppressWarnings("serial")
	public static List<ExtColumnType> init(){
		return new ArrayList<ExtColumnType>(){{
		}};
	}
	
        /** 流水号 */
	@Column(name = "id",jdbcType="bigint(20)",priKey=true,autoIncrement=true, comment="流水号")
	@ApiModelProperty("流水号")
	private Long id;
    
        /** 扩增类型名字 */
	@Column(name = "name",jdbcType="varchar(50)",notNull=true,def="''",comment="扩增类型名字")
	@ApiModelProperty("扩增类型名字")
	private String name;
    
        /** 扩增类型code值 */
	@Column(name = "code",jdbcType="varchar(50)",notNull=true,def="''",comment="扩增类型code值")
	@ApiModelProperty("扩增类型code值")
	private String code;
    
        /** 备注 */
	@Column(name = "remark",jdbcType="varchar(100)",notNull=true,def="",comment="备注")
	@ApiModelProperty("备注")
	private String remark;
    
}
