package com.leave.tracker.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "auth-client", url = "${Authorization.URL}")
public interface AuthClient {

	 @GetMapping(value = "/validate")
     public boolean getsValidity(@RequestHeader(name = "Authorization", required = true) String token);
	
}
