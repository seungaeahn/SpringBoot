package com.kh.springdb.model;

import lombok.Getter;


@Getter
public enum UserRole {
/*
 	변수 : 변할 수 있는 수
 	상수 : 언제나 한결같은 수 (final)
 	public static final
 	private static final
 	private final
 	
 	enum : final 상수 집합을 나타낼 때 사용하는 값
 */
	//admin
	//나열해야하는 상수들은 , 사용해서 나열하고
	//나열을 종료할때는 최종적으로 ;를 사용한다.
	ADMIN("ROLE_ADMIN"), USER("ROLE_USER");
	
	//현재 유저가 ADMIN인지 USER인지 로그인하기 전까지 파악되지 않기 때문에
	//value라는 값으로 추후에 로그인 할 경우 value에다가 ADMIN 또는 USER를 넣어준다.
	
	private String value;
	//유저가 어떤 유저인지 값을 받아오기 위해 value를 추가
	UserRole(String value) {
		this.value=value;
	}
	
	public String getValue() {
        return value;
    }

}
