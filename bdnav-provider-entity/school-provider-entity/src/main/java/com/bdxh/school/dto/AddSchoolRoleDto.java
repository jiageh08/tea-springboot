package com.bdxh.school.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Data
public class AddSchoolRoleDto implements Serializable {

    private static final long serialVersionUID = 9202976682572419808L;

    /**
     * 角色
     */
    @NotEmpty(message ="角色不能为空")
    @ApiModelProperty("角色")
    private String role;

    @ApiModelProperty("学校id")
    private Long schoolId;

    @ApiModelProperty("学校编码")
    private String schoolCode;

    /**
     * 角色名称
     */
    @NotEmpty(message ="角色名称不能为空")
    @ApiModelProperty("角色名称")
    private String roleName;

    /**
     * 操作人
     */
    @ApiModelProperty("操作人")
    private Long operator;

    @ApiModelProperty("操作人名称")
    private String operatorName;
    /**
     * 备注
     */
    @ApiModelProperty("备注")
     private String remark;

}
