package com.example.mybatisplustest.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author LiZijing
 * @since 2021-09-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("tb_user")
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "User对象", description = "用户表")
public class User extends Model<User> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "用户名")
    private String username;

    @ApiModelProperty(value = "密码")
    private String password;

    @ApiModelProperty(value = "手机号码")
    private String phone;

    @ApiModelProperty(value = "邮箱")
    private String email;

    @ApiModelProperty(value = "备注")
    private String description;

    @ApiModelProperty(value = "创建时间")
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    @ApiModelProperty(value = "更新时间")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    @ApiModelProperty(value = "0 代表未删除，1 代表已删除")
    @TableField(fill = FieldFill.INSERT)
    @TableLogic(value = "0", delval = "1")
    private Boolean isDeleted;


    @Override
    protected Serializable pkVal() {
        return null;
    }

}
