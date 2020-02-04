package com.future.saf.sample.http.apache.httpcomponents.web.receive.dto;

import java.io.Serializable;

import lombok.*;

@ToString
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO implements Serializable {

	private static final long serialVersionUID = 5535756618301633282L;

	private Long id;

	private String name;

}
