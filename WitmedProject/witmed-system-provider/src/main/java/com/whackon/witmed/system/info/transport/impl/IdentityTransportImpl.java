package com.whackon.witmed.system.info.transport.impl;

import com.whackon.witmed.base.pojo.vo.PageVO;
import com.whackon.witmed.base.pojo.vo.QueryPageVO;
import com.whackon.witmed.system.info.pojo.vo.IdentityVO;
import com.whackon.witmed.system.info.service.IdentityService;
import com.whackon.witmed.system.info.transport.IdentityTransport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <b>智慧医疗信息平台 - 系统用户身份信息传输层接口实现类</b>
 * @author Arthur
 * @version 1.0.0
 */
@RestController("identityTransport")
@RequestMapping("/system/info/identity/trans")
public class IdentityTransportImpl implements IdentityTransport {
	@Autowired
	private IdentityService service;

	/**
	 * <b>根据查询对象分页查询</b>
	 * @param queryPageVO
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/page")
	public PageVO<IdentityVO> getPage(@RequestBody QueryPageVO<IdentityVO> queryPageVO) throws Exception {
		// 分别将 QueryPageVO 中的数据进行获取
		IdentityVO queryVO = queryPageVO.getQueryVO();
		PageVO<IdentityVO> pageVO = queryPageVO.getPageVO();
		return service.getPage(queryVO, pageVO);
	}
}
