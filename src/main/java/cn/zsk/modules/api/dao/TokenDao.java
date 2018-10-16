package cn.zsk.modules.api.dao;

import cn.zsk.modules.api.entity.TokenEntity;
import cn.zsk.modules.base.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户Token
 * 
 * @author zsk
 *
 * @date 2017-03-23 15:22:07
 */
@Mapper
public interface TokenDao extends BaseDao<TokenEntity> {
    
    TokenEntity queryByUserId(String userId);

    TokenEntity queryByToken(String token);
	
}
