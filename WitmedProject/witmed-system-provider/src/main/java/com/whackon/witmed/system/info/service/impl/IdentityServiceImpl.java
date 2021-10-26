package com.whackon.witmed.system.info.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.whackon.witmed.base.pojo.vo.PageVO;
import com.whackon.witmed.system.info.dao.IdentityDao;
import com.whackon.witmed.system.info.pojo.entity.Identity;
import com.whackon.witmed.system.info.pojo.vo.IdentityVO;
import com.whackon.witmed.system.info.service.IdentityService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * <b>智慧医疗信息平台 - 系统用户身份信息业务层接口实现类</b>
 * @author Arthur
 * @version 1.0.0
 */
@Service("identityService")
@Transactional
public class IdentityServiceImpl implements IdentityService {
	@Autowired
	private IdentityDao dao;

	/**
	 * <b>根据查询对象分页查询</b>
	 * @param queryVO
	 * @param pageVO
	 * @return
	 * @throws Exception
	 */
	@Override
	public PageVO<IdentityVO> getPage(IdentityVO queryVO, PageVO<IdentityVO> pageVO) throws Exception {
		// 将查询的 VO 对象，切换为 entity 对象
		Identity query = new Identity();
		BeanUtils.copyProperties(queryVO, query);
		// 开启分页查询过滤器
		PageHelper.startPage(pageVO.getPageNum(), pageVO.getPageSize());
		// 进行列表查询
		List<Identity> list = dao.findListByQuery(query);
		// 根据所查询获得的列表创建 PageInfo 对象
		PageInfo<Identity> pageInfo = new PageInfo<Identity>(list);
		// 将实体列表切换为视图列表
		List<IdentityVO> voList = new ArrayList<IdentityVO>();
		// 获得实体列表
		List<Identity> entityList = pageInfo.getList();
		if (entityList != null && !entityList.isEmpty()) {
			for (Identity entity : entityList) {
				// 创建对应的 VO 对象
				IdentityVO vo = new IdentityVO();
				BeanUtils.copyProperties(entity, vo);
				// 将数据准本好的 vo 存储到列表中
				voList.add(vo);
			}
		}
		// 将获得的列表设定到 PageVO 中
		pageVO.setList(voList);
		pageVO.setTotalSize(pageInfo.getTotal());
		pageVO.setTotalPage(pageInfo.getPages());
		return pageVO;
	}
}
