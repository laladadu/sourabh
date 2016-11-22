package com.aartek.prestigepoint.serviceImpl;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;




import org.springframework.stereotype.Service;









import com.aartek.prestigepoint.model.LoginDto;
import com.aartek.prestigepoint.repository.LoginRepository;
import com.aartek.prestigepoint.repositoryImpl.LoginRepositoryImpl;
import com.aartek.prestigepoint.service.LoginService;
import com.aartek.prestigepoint.vo.LoginVO;


@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private LoginRepository loginRepository;
	public LoginDto convert_vo_to_dto(LoginVO vo)
	{
		LoginDto dto=new LoginDto();
		try {
			BeanUtils.copyProperties(dto, vo);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dto;
	}
	
	public LoginVO convert_dto_to_vo(LoginDto dto)
	{
		LoginVO vo=new LoginVO();
		try {
			BeanUtils.copyProperties(vo, dto);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return vo;
	}
	public LoginVO validate(LoginVO loginvo) {
		System.out.println(loginvo);
		LoginDto dto=convert_vo_to_dto(loginvo);
		System.out.println(dto);
		List<LoginDto> list=	loginRepository.checkLogin(dto);
		System.out.println(list);
		System.out.println(convert_dto_to_vo(list.get(0)).getEmail_id());
		if (list != null && !list.isEmpty()) {
			return convert_dto_to_vo(list.get(0));
		} else {
			return null;
		}
	}

}
