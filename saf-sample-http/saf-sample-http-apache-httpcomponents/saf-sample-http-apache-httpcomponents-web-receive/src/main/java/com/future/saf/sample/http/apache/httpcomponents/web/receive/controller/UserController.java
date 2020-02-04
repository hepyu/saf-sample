package com.future.saf.sample.http.apache.httpcomponents.web.receive.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.future.saf.core.web.WebResult;
import com.future.saf.sample.http.apache.httpcomponents.web.receive.dto.UserDTO;

@RestController
@RequestMapping(value = "/user")
public class UserController {

	@RequestMapping("/getUser")
	public WebResult<UserDTO> getUser(@RequestParam(name = "userId") Long userId) {
		UserDTO userDTO = new UserDTO();
		userDTO.setId(userId);
		userDTO.setName(userId + "");
		return new WebResult<>(WebResult.CODE_SUCCESS, "getUser success.", userDTO);
	}

}
