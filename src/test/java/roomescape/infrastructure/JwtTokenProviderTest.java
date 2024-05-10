package roomescape.infrastructure;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import roomescape.domain.user.User;
import roomescape.exception.AuthorizationException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class JwtTokenProviderTest {

    @Test
    @DisplayName("올바른 jwt 토큰으로 인증 조회를 성공한다.")
    void checkJwtToken_Success() {
        // given
        JwtTokenProvider jwtTokenProvider = new JwtTokenProvider("secret", 3600000L);
        String token = jwtTokenProvider.createToken(new User(1L, "naknak", "abc@google.com", "abc"));

        // when
        User user = jwtTokenProvider.getUser(token);

        // then
        assertThat(user)
                .usingRecursiveComparison()
                .isEqualTo(new User(1L, "naknak"));
    }

    @Test
    @DisplayName("올바르지 않은 jwt 토큰으로 인증 조회를 할 시 예외가 발생한다.")
    void checkJwtToken_Failure() {
        // given
        JwtTokenProvider jwtTokenProvider1 = new JwtTokenProvider("secret", 3600000L);
        JwtTokenProvider jwtTokenProvider2 = new JwtTokenProvider("otherSecret", 3600000L);
        String token = jwtTokenProvider1.createToken(new User(1L, "naknak", "abc@google.com", "abc"));

        // when & then
        assertThatThrownBy(() -> jwtTokenProvider2.getUser(token))
                .isInstanceOf(AuthorizationException.class)
                .hasMessage("인증 정보를 확인할 수 없습니다.");
    }

    @Test
    @DisplayName("만료된 jwt 토큰으로 인증 조회를 할 시 예외가 발생한다.")
    void checkJwtTokenExpire_Failure() {
        // given
        JwtTokenProvider jwtTokenProvider = new JwtTokenProvider("secret", -3600000L);
        String token1 = jwtTokenProvider.createToken(new User(1L, "naknak", "abc@google.com", "abc"));
        
        // when & then
        assertThatThrownBy(() -> jwtTokenProvider.getUser(token1))
                .isInstanceOf(AuthorizationException.class)
                .hasMessage("인증이 만료되었습니다.");
    }
}
