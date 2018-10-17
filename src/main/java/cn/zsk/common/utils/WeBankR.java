package cn.zsk.common.utils;


import java.util.HashMap;

/**
 * 返回数据
 * 
 * @author zsk
 *
 * @date 2016年10月27日 下午9:59:27
 */
public class WeBankR extends HashMap<String, Object> {
	private static final long serialVersionUID = 1L;

	public WeBankR() {
		put("isSuccess", "Y");
	}
	
	public static WeBankR error() {
		return status(false, "500", "未知异常，请联系管理员");
	}
	
	public static WeBankR status(boolean isSuccess, String errorCode, String errorDesc) {
		WeBankR r = new WeBankR();
		if (!isSuccess) {
            r.put("isSuccess", "N");
        } else {
            r.put("isSuccess", "Y");
        }
		r.put("errorCode", errorCode);
		r.put("errorDesc", errorDesc);
		return r;
	}
	
	public static WeBankR ok() {
		return new WeBankR();
	}
}
