package net.hlinfo.sso.web.controller;

import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.hlinfo.mybatis.service.MybatisService;
import net.hlinfo.sso.entity.AdminInfo;
import net.hlinfo.sso.opt.Resp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags="首页")
@RestController
@RequestMapping("/")
public class IndexController {

	@Autowired
	private MybatisService mybatisService;

	@ApiOperationSupport(author = "service@hlinfo.net")
	@ApiOperation("欢迎页")
	@GetMapping(value = {"/","/index.html"})
	public String index() {
		
		return "Hello Word Web^_^";
	}

	@ApiOperationSupport(author = "service@hlinfo.net")
	@ApiOperation("测试MyBatis")
	@GetMapping("/ok")
	public Resp<List<AdminInfo>> getAreacode() {
		List<AdminInfo> list = mybatisService.queryList("find_admin_info_list", AdminInfo.class);
		return Resp.LIST_O(list);
	}

}
