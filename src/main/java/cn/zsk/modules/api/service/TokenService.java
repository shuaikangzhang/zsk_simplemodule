package cn.zsk.modules.api.service;


import cn.zsk.common.utils.R;
import cn.zsk.modules.api.entity.TokenEntity;

/**
 * 用户Token
 * 
 * @author zsk
 *
 * @date 2017-03-23 15:22:07
 */
public interface TokenService {

	TokenEntity queryByUserId(String userId);

	TokenEntity queryByToken(String token);
	
	void save(TokenEntity token);
	
	void update(TokenEntity token);

	/**
	 * 生成token
	 * @param userId  用户ID
	 * @return        返回token相关信息
	 */
	R createToken(String userId);

}
