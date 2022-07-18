package com.jestify.service;

import com.jestify.common.AppConstant;
import com.jestify.entity.Artists;
import com.jestify.entity.Podcasts;
import com.jestify.entity.Users;
import com.jestify.payload.AuthRequest;
import com.jestify.payload.RegisterRequest;
import com.jestify.payload.ResetPasswordRequest;
import com.jestify.repository.ArtistRepository;
import com.jestify.repository.PodcastRepository;
import com.jestify.repository.RoleRepository;
import com.jestify.repository.UserRepository;
import com.jestify.utils.EmailMessageUtil;
import com.jestify.utils.EmailUtils;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import java.util.Calendar;
import java.util.Date;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final EmailUtils emailUtils;
    private final PodcastRepository podcastRepository;
    private final ArtistRepository artistRepository;
    public Users checkLoginCustomer(AuthRequest loginRequest) {
        Users user = userRepository.findByEmailAndRolesCode(loginRequest.getEmail(), AppConstant.CUSTOMER_ROLE)
                .orElse(null);
        if (user == null || !passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())) {
            throw new IllegalArgumentException("Email or password is incorrect");
        }
        if (!user.isActive()) {
            throw new IllegalArgumentException("Please check email to verify account");
        }
        return user;
    }

    public Users checkLoginAdmin(AuthRequest loginRequest) {
        Users user = userRepository.findByEmailAndActiveTrueAndRolesCode(loginRequest.getEmail(), AppConstant.ADMIN_ROLE)
                .orElse(null);
        if (user == null || !passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())) {
            throw new IllegalArgumentException("Username or password is incorrect");
        }
        return user;
    }

    public void register(RegisterRequest payload, HttpServletRequest request) {
        boolean existedEmail = userRepository.findByEmail(payload.getEmail()).isPresent();
        if (existedEmail) {
            throw new IllegalArgumentException("Email already exists");
        }
        String key = RandomStringUtils.randomAlphanumeric(200);
        String verifyLink = AppConstant.FRONTEND_HOST + "/verify-registration/" + key;
        boolean sendMailSuccess = emailUtils.sendMail(payload.getEmail(),
                EmailMessageUtil.VERIFY_REGISTER_SUBJECT,
                EmailMessageUtil.verifyRegister(payload.getFullName(), verifyLink));
        if (!sendMailSuccess) {
            throw new IllegalArgumentException("Send verify registration mail failed. Please try again.");
        }
        userRepository.save(Users.builder()
                .email(payload.getEmail())
                .password(passwordEncoder.encode(payload.getPassword()))
                .fullName(payload.getFullName())
                .active(false)
                .key(key)
                .roles(roleRepository.findByCode(AppConstant.CUSTOMER_ROLE).orElse(null))
                .build());
    }

    @Transactional
    public void verifyRegister(String key) {
        if (StringUtils.isBlank(key)) {
            throw new IllegalStateException();
        }
        Users user = userRepository.findByKey(key).orElseThrow(IllegalStateException::new);
        user.setActive(true);
        user.setKey(null);
        user.setKeyTime(null);
        userRepository.save(user);
        podcastRepository.save(Podcasts.builder()
                .active(true)
                .userId(user.getId())
                .name(user.getFullName()).build());
        artistRepository.save(Artists.builder()
                .verify(true)
                .nickName(user.getFullName())
                .userId(user.getId())
                .build());
    }

    public void forgotPassword(String email) {
        Users user = userRepository.findByEmailAndActiveTrue(email).orElseThrow(() -> new IllegalArgumentException("Email not found"));

        String key = RandomStringUtils.randomAlphanumeric(200);
        String resetLink = AppConstant.FRONTEND_HOST + "/reset-password/" + email + "/" + key;
        boolean sendMailSuccess = emailUtils.sendMail(email,
                EmailMessageUtil.RESET_PASSWORD_SUBJECT,
                EmailMessageUtil.resetPassword(user.getFullName(), resetLink));
        if (!sendMailSuccess) {
            throw new IllegalArgumentException("Send reset password mail failed. Please try again.");
        }

        user.setKey(key);
        user.setKeyTime(new Date());
        userRepository.save(user);
    }

    public void resetPassword(ResetPasswordRequest request) {
        if (!StringUtils.equals(request.getNewPassword(), request.getNewPasswordConfirm())) {
            throw new IllegalArgumentException("Password and Password Confirm must be match");
        }
        Users user = userRepository.findByEmailAndActiveTrue(request.getEmail()).orElseThrow(() -> new IllegalArgumentException("Email not found"));
        user.setKey(null);
        user.setKeyTime(null);
        user.setPassword(passwordEncoder.encode(request.getNewPassword()));
        userRepository.save(user);
    }

    private boolean isExpiredLink(Date keyTime) {
        Calendar calendarKeyTime = Calendar.getInstance();
        calendarKeyTime.setTime(keyTime);
        calendarKeyTime.add(Calendar.HOUR_OF_DAY, AppConstant.EXPIRED_HOURS_LINK);
        Calendar currentTime = Calendar.getInstance();
        return calendarKeyTime.before(currentTime);
    }

    public void verifyForgotPassword(String key) {
        if (StringUtils.isBlank(key)) {
            throw new IllegalStateException();
        }
        Users user = userRepository.findByKey(key).orElseThrow(IllegalStateException::new);
        Date keyTime = user.getKeyTime();
        if (isExpiredLink(keyTime)) {
            throw new IllegalArgumentException("Reset Password Link Expired");
        }
    }

    public Users getByEmail(String email) {
        return userRepository.findByEmailAndActiveTrue(email).orElseThrow(() -> new IllegalStateException("User not found"));
    }
}