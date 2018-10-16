package cn.zsk.modules.sys.dao;

import cn.zsk.modules.base.dao.BaseDao;
import cn.zsk.modules.sys.entity.SysLogEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 系统日志
 * 
 * @author zsk
 *
 * @date 2017-03-08 10:40:56
 */
@Mapper
public interface SysLogDao extends BaseDao<SysLogEntity> {
	
}
