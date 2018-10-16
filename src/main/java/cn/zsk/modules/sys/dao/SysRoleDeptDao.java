package cn.zsk.modules.sys.dao;

import cn.zsk.modules.sys.entity.SysRoleDeptEntity;
import cn.zsk.modules.base.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 角色与部门对应关系
 * 
 * @author zsk
 *
 * @date 2017年6月21日 23:33:46
 */
@Mapper
public interface SysRoleDeptDao extends BaseDao<SysRoleDeptEntity> {
	
	/**
	 * 根据角色ID，获取部门ID列表
	 */
	List<Long> queryDeptIdList(Long roleId);
}
