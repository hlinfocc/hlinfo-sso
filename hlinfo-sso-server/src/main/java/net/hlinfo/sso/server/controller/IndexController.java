package net.hlinfo.sso.server.controller;

import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.hlinfo.sso.entity.AdminInfo;
import net.hlinfo.sso.opt.Resp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags="server首页")
@RestController
@RequestMapping("/")
public class IndexController {

	@ApiOperationSupport(author = "service@hlinfo.net")
	@ApiOperation("欢迎页")
	@GetMapping(value = {"/","/index.html"})
	public String index() {
		
		return "Hello Word SSO server^_^";
	}

	@ApiOperationSupport(author = "service@hlinfo.net")
	@ApiOperation("test页")
	@GetMapping(value = {"/test"})
	public Resp<String> test() {
		
		return Resp.OK("Hello Word SSO server test^_^");
	}
}
