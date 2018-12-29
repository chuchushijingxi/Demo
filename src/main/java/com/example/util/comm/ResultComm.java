package com.example.util.comm;


import com.example.pojo.Result;

/**
 * @program: myself
 * @description: 参数返回封装工具类
 * @author: zlf
 * @create: 2018-12-14 17:53
 **/
public class ResultComm {

	/**
	 * 设置参数返回
	 *
	 * @param data
	 */
	public static Result success(Object data) {
		Result result = new Result();
		result.setCode(200);
		result.setMsg("成功");
		result.setData(data);
		return result;
	}

	public static Result success(String msg, Object data) {
		Result result = new Result();
		result.setCode(200);
		result.setMsg(msg);
		result.setData(data);
		return result;
	}

	/**
	 * 自定义错误信息
	 *
	 * @param code
	 * @param msg
	 * @return
	 */
	public static Result error(int code, String msg) {
		Result result = new Result();
		result.setCode(code);
		result.setMsg(msg);
		return result;
	}

	/**
	 * 自定义错误信息
	 *
	 * @param msg
	 * @return
	 */
	public static Result error(String msg) {
		Result result = new Result();
		result.setCode(444);
		result.setMsg(msg);
		return result;
	}

	/**
	 * 自定义错误信息
	 *
	 * @return
	 */
	public static Result error() {
		Result result = new Result();
		result.setCode(444);
		result.setMsg("失败");
		return result;
	}

	/**
	 * 提供给部分不需要出参的接口
	 *
	 * @return
	 */
	public static Result success() {
		return success(null);
	}
}
