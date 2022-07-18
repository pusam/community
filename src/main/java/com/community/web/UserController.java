package com.community.web;

import com.community.domain.message.Message;
import com.community.services.UserService;
import com.community.validator.CheckEmailValidator;
import com.community.validator.CheckLoginIDValidator;
import com.community.validator.CheckNickNameValidator;
import com.community.validator.CheckReConfirmPassword;
import com.community.web.dto.UserRequestDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

@Controller
@AllArgsConstructor
public class UserController {
    private final UserService userService;
    private final CheckLoginIDValidator checkLoginIDValidator;
    private final CheckNickNameValidator checkNickNameValidator;
    private final CheckEmailValidator checkEmailValidator;
    private final CheckReConfirmPassword checkReConfirmPassword;

    /* 커스텀 유효성 검증을 위해 추가 */
    @InitBinder
    public void validatorBinder(WebDataBinder binder) {
        binder.addValidators(checkLoginIDValidator);
        binder.addValidators(checkNickNameValidator);
        binder.addValidators(checkEmailValidator);
        binder.addValidators(checkReConfirmPassword);
    }

    @GetMapping("/signup")
    public String singUp(Model model) {
        model.addAttribute("userRequestDto", new UserRequestDto());
        return "user/signup";
    }

    @PostMapping("/signup")
    public String signUp(@Valid UserRequestDto userRequestDto, Errors errors, Model model) throws NoSuchAlgorithmException {
        if (errors.hasErrors()) {
            model.addAttribute("userRequestDto", userRequestDto);
            Map<String, String> validatorResult = userService.validateHandling(errors);
            for (String key : validatorResult.keySet()) {
                model.addAttribute(key, validatorResult.get(key));
            }
            return "user/signup";
        }

        userService.signUp(userRequestDto);
        model.addAttribute("data", new Message("회원가입이 완료되었습니다.", "/"));
        return "user/message";
    }

    @GetMapping("/signin")
    public String signInForm()throws Exception{
        return "user/signin";
    }

    @PostMapping("/signin")
    public String signIn()throws Exception{
        return "redirect:/";
    }


}