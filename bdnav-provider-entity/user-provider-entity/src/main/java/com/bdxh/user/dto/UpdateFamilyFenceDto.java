package com.bdxh.user.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @description:
 * @author: binzh
 * @create: 2019-04-11 09:59
 **/
@Data
public class UpdateFamilyFenceDto  implements Serializable {
    private static final long serialVersionUID = -3640130486836469791L;

    /**
     * 围栏ID
     */
    @NotNull(message ="围栏ID不能为空")
    @ApiModelProperty("围栏ID")
    private Long id;

    /**
     * 学校id
     */
    @ApiModelProperty("学校id[不传递，后台自己获取]")
    private Long schoolId;

    /**
     * 学校编码
     */
    @ApiModelProperty("学校编码[不传递，后台自己获取]")
    private String schoolCode;

    /**
     * 家长号
     */
    @ApiModelProperty("家长号[不传递，后台自己获取]")
    private String cardNumber;

    /**
     * 家长id
     */
    @ApiModelProperty("家长id[不传递，后台自己获取]")
    private Long familyId;

    /**
     * 学生id
     */
    @ApiModelProperty("学生id")
    private Long studentId;

    /**
     * 学生姓名
     */
    @ApiModelProperty("学生姓名")
    private String studentName;

    /**
     * 学生学号
     */
    @ApiModelProperty("学生学号")
    private String studentNumber;

    /**
     * 围栏id 百度返回
     */
    @ApiModelProperty("围栏id 百度返回")
    private Integer fenceId;

    /**
     * 围栏名称
     */
    @ApiModelProperty("围栏名称")
    private String fenceName;

    /**
     * 经度
     */
    @ApiModelProperty("经度")
    private BigDecimal longitude;

    /**
     * 维度
     */
    @ApiModelProperty("维度")
    private BigDecimal latitude;

    /**
     * 半径
     */
    @ApiModelProperty("半径")
    private BigDecimal radius;

    /**
     * 坐标类型
     */
    @ApiModelProperty("坐标类型")
    private String coordType;

    /**
     * 围栏去噪参数
     */
    @ApiModelProperty("围栏去噪参数")
    private Integer denoise;

    /**
     * 状态 1 启用 2 禁用
     */
    @ApiModelProperty("状态 1 启用 2 禁用")
    private Byte status;

    /**
     * 创建时间
     */
    @ApiModelProperty("创建时间")
    private Date createDate;

    /**
     * 修改时间
     */
    @ApiModelProperty("修改时间")
    private Date updateDate;

    /**
     * 备注
     */
    @ApiModelProperty("备注")
    private String remark;
}