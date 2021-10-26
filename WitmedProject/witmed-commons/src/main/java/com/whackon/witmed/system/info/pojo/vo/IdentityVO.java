package com.whackon.witmed.system.info.pojo.vo;

import com.whackon.witmed.base.pojo.vo.BaseVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <b>智慧医疗信息平台 - 系统用户身份信息视图</b>
 * @author Arthur
 * @version 1.0.0
 */
@ApiModel("系统用户身份信息")
public class IdentityVO extends BaseVO {
	private static final long serialVersionUID = -3835638265372977369L;
	@ApiModelProperty(name = "主键")
	private String id;                      // 主键
	@ApiModelProperty(name = "身份名称")
	private String name;                    // 身份名称
	@ApiModelProperty(name = "身份编码")
	private String code;                    // 身份编码
	@ApiModelProperty(name = "对应数据表名")
	private String tableName;               // 对应数据表名

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
}
