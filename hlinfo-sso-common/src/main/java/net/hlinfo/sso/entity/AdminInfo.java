package net.hlinfo.sso.entity;


import javax.servlet.http.HttpServletRequest;

import org.nutz.dao.entity.annotation.ColDefine;
import org.nutz.dao.entity.annotation.ColType;
import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Comment;
import org.nutz.dao.entity.annotation.Default;
import org.nutz.dao.entity.annotation.Index;
import org.nutz.dao.entity.annotation.Table;
import org.nutz.dao.entity.annotation.TableIndexes;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import net.hlinfo.opt.Func;

@Table("admin_info")
@ApiModel("管理员信息")
@Comment("管理员信息")
@TableIndexes({
	@Index(fields = {"account"}, unique = true)
})
public class AdminInfo extends BaseEntity{
	private static final long serialVersionUID = 1L;
	/**
	* 登录帐号
	*/
	@Column("account")
	@ColDefine(type=ColType.TEXT)
	@Comment(value="登录帐号")
	@ApiModelProperty(value="登录帐号")
	private String account;
	
	@Column("real_name")
	@ColDefine(type=ColType.TEXT)
	@Comment(value="姓名")
	@ApiModelProperty(value="姓名")
	private String realName;
	
	@Column("password")
	@ColDefine(notNull=false, type=ColType.TEXT)
	@Comment(value="密码")
	@ApiModelProperty(value="密码(前端需sm3加密)")
	@JsonProperty(access = Access.WRITE_ONLY) //密码不发送到前端，但是前端可以传过来
	private String password;
	
	@Column("status")
	@ColDefine(notNull=false,type=ColType.INT, width=3,customType = "integer")
	@Comment(value="状态 0 启用 1禁用")
	@ApiModelProperty(value="状态 0 启用 1禁用")
	@Default("0")
	private int status;
	
	@Column("userlevel")
	@ColDefine(notNull=false,type=ColType.INT, width=3,customType = "integer")
	@Comment(value="用户等级:0超级管理员,1普通管理员,2部门管理员")
	@ApiModelProperty(value="用户等级:0超级管理员,1普通管理员,2部门管理员")
	@Default("1")
	private int userlevel;
	
	@Column("dept")
	@ColDefine(type=ColType.TEXT)
	@Comment(value="所在部门")
	@ApiModelProperty(value="所在部门")
//	@ExcelProperty("所在部门")
	private String dept;
	
	@Column("dept_id")
	@ColDefine(type=ColType.TEXT)
	@Comment(value="所在部门ID")
	@ApiModelProperty(value="所在部门ID")
//	@ExcelIgnore
	private String deptId;
		
	@Column("last_login_time")
	@ColDefine(type=ColType.VARCHAR, width=25)
	@Comment(value="上一次登陆时间")
	@ApiModelProperty(value="上一次登陆时间")
	private String lastLoginTime;
	
	@Column("last_login_ip")
	@ColDefine(type=ColType.VARCHAR, width=128)
	@Comment(value="上一次登陆ip")
	@ApiModelProperty(value="上一次登陆ip")
	private String lastLoginIp;
	
	@Column("that_login_time")
	@ColDefine(type=ColType.VARCHAR, width=25)
	@Comment(value="这一次登陆时间")
	@ApiModelProperty(value="这一次登陆时间")
	private String thatLoginTime;
	
	@Column("that_login_ip")
	@ColDefine(type=ColType.VARCHAR, width=128)
	@Comment(value="这一次登陆ip")
	@ApiModelProperty(value="这一次登陆ip")
	private String thatLoginIp;

	public void updateLoginInfo(HttpServletRequest request) {
		this.setLastLoginIp(this.getThatLoginIp());
		this.setLastLoginTime(this.getThatLoginTime());
		this.setThatLoginIp(Func.getIpAddr(request));
		this.setThatLoginTime(Func.Times.now());
	}
	
	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public String getDeptId() {
		return deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getUserlevel() {
		return userlevel;
	}

	public void setUserlevel(int userlevel) {
		this.userlevel = userlevel;
	}

	public String getLastLoginTime() {
		return lastLoginTime;
	}

	public void setLastLoginTime(String lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	public String getLastLoginIp() {
		return lastLoginIp;
	}

	public void setLastLoginIp(String lastLoginIp) {
		this.lastLoginIp = lastLoginIp;
	}

	public String getThatLoginTime() {
		return thatLoginTime;
	}

	public void setThatLoginTime(String thatLoginTime) {
		this.thatLoginTime = thatLoginTime;
	}

	public String getThatLoginIp() {
		return thatLoginIp;
	}

	public void setThatLoginIp(String thatLoginIp) {
		this.thatLoginIp = thatLoginIp;
	}

}
