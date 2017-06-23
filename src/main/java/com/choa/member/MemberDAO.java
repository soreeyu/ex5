package com.choa.member;

public interface MemberDAO {
	
	//join
	public int memberJoin(MemberDTO memberDTO) throws Exception;

	//login
	public MemberDTO memberLogin(MemberDTO memberDTO)throws Exception;
	
	//page
	public MemberDTO memberPage(MemberDTO memberDTO) throws Exception;
}
