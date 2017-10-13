package com.lxjr.sudadai.constants;

/**
 * 基本静态常量
 *
 * @author 董凡东
 */
public class BaseConstant {

	//************************* session中存放的变量名 *********************************
	/**
	 * 用户id
	 */
	public static final String USER_ID = "userId";

	public static final String REASON = "reason";

	public static final String USER_INFO = "user_info";

	/**
	 * 管理员id
	 */
	public static final String MANAGER_ID = "managerId";

	/**
	 * 验证码
	 */
	public static final String VALIDATE_CODE = "vcode";

	/**
	 * 手机验证码
	 */
	public static final String TICKET = "ticket";

	// ******** 没有权限的struts2返回结果，需要在struts.xml中配置  ******************
	/**
	 * 没有登录
	 */
	public static final String UNLOGIN = "unLogin";

	/**
	 * 异常信息
	 **/
	public static final String ERROR_MAG = "服务器维护中,请稍后重试";

	/**
	 * 默认用户首次去向
	 **/
	public static final Long DEDAULT_FIRST_TARGET = -1L;

	/**
	 * 用户信息已存在
	 **/
	public static final String USER_INFO_REPEAT = "用户信息已提交,请勿重复提交";

	/**
	 * 成功标志
	 **/
	public static final String SUCCESS = "success";

	/**
	 * 异常日志log key
	 **/
	public static final String LOG_ERR_MSG = "lxjr_errMsg";

	/**
	 * 验证码异常信息
	 **/
	public static final String VCODE_ERR_MSG = "验证码错误,请重试";

	/**
	 * 获取session异常
	 **/
	public static final String SESSION_ERR_MSG = "系统发生错误，请刷新后重试，谢谢！";

}
