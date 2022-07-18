package com.community.validator;

import com.community.domain.user.UserRepository;
import com.community.web.dto.UserRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

@RequiredArgsConstructor
@Component
public class CheckLoginIDValidator extends AbstractValidator<UserRequestDto> {
    private final UserRepository userRepository;

    @Override
    protected void doValidate(UserRequestDto dto, Errors errors) {
        if (userRepository.existsByLoginID(dto.toEntity().getLoginID())) {
            errors.rejectValue("loginID", "아이디 중복 오류", "이미 사용중인 아이디 입니다.");
        }
    }
}