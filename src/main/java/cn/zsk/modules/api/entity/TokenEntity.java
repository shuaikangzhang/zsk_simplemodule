package cn.zsk.modules.api.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;



/**
 * 用户Token
 * 
 * @author zsk
 *
 * @date 2017-03-23 15:22:07
 */
@Data
public class TokenEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//用户ID
	private String userId;
	//token
	private String token;
	//过期时间
	private Date expireTime;
	//更新时间
	private Date updateTime;
}
