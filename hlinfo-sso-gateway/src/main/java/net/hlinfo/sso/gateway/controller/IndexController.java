package net.hlinfo.sso.gateway.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


import io.swagger.annotations.Api;

@Api(tags = "主页模块")
@RestController
public class IndexController {
	
	@GetMapping(value= {"/", "/index", "/index.html"})
	public String index(){
		return "hallo welcome RsGateway";
	}
}

