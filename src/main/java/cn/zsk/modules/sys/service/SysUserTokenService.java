package cn.zsk.modules.sys.service;

import cn.zsk.modules.sys.entity.SysUserTokenEntity;
import cn.zsk.common.utils.R;

/**
 * 用户Token
 * 
 * @author zsk
 *
 * @date 2017-03-23 15:22:07
 */
public interface SysUserTokenService {

	SysUserTokenEntity queryByUserId(Long userId);

	SysUserTokenEntity queryByToken(String token);
	
	void save(SysUserTokenEntity token);
	
	void update(SysUserTokenEntity token);

	/**
	 * 生成token
	 * @param userId  用户ID
	 */
	R createToken(long userId);

}
