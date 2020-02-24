package com.future.saf.sample.dubbo.apollo.remote.dto;

import java.io.Serializable;
import lombok.*;

@ToString
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class TestSameMethodNameDTO implements Serializable {

	private static final long serialVersionUID = 6219081280341280697L;

	private long sleepTimestamp;
}
