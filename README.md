## 요구사항 명세

- [x] localhost:8080/admin 요청 시 index.html 페이지가 응답한다.
- [x] /admin/reservation 요청 시 reservation-legacy.html 응답한다.
- [x] /reservations 요청 시 예약 목록을 응답한다.
- [x] 예약 페이지 요청 시 예약 목록을 조회하여 보여준다.
- [x] 예약을 추가한다.
- [x] 예약을 삭제한다.

- [x] 사용자는 로그인 할 수 있다.
    - [x] email/pw 를 입력하면 해당되는 사용자를 조회한다.
    - [x] 존재하지 않는 email/pw 를 입력하면 로그인 할 수 없다.
    - [ ] email 의 형식은 "xxx@xxx.xxx" 형식이어야 한다.

- [x] 로그인 성공 시 jwt 토큰을 발급 받는다.
- [x] 로그인 성공 시 발급 받은 jwt 토큰을 쿠키를 통해 응답한다.

- [x] 사용자 인증 정보를 조회한다.
    - [x] 쿠키에 담긴 jwt 토큰을 통해 올바른 토큰인지 검증한다.
    - [x] jwt 토큰을 통해 사용자를 조회한다.

- [x] 시간 생성 시 시작 시간에 유효하지 않은 값이 입력되었을 때
    - [x] 시작 시간은 빈칸일 수 없다.
    - [x] HH:MM 형식이어야 한다.

- [x] 예약 생성 시 예약자명, 날짜, 시간에 유효하지 않은 값이 입력 되었을 때
    - [x] 예약자명은 빈칸일 수 없다.
    - [x] 날짜는 빈칸일 수 없다.
    - [x] 날짜는 YYYY-MM-DD 형식이어야 한다.
    - [x] 시간에 대한 아이디는 정수여야 한다.

- [x] 특정 시간에 대한 예약이 존재할 때, 그 시간을 삭제할 수 없다.
- [x] 존재하는 시간에 대해서만 예약할 수 있다.

- [x] 지나간 날짜와 시간에 대한 예약 생성은 불가능하다.
- [x] 중복 예약은 불가능하다. (ex. 이미 4월 1일 10시에 예약이 되어있다면, 4월 1일 10시에 대한 예약을 생성할 수 없다)
- [x] 시간은 중복될 수 없다.

- [x] 존재하지 않는 사용자에 대한 예약 생성은 불가능하다.

- [x] 모든 테마는 시작 시간이 동일하다.
- [x] 테마 이름은 빈칸일 수 없다.
- [x] 관리자가 테마를 관리할 수 있다.
- [x] 이미 예약 중인 테마는 삭제할 수 없다.
- [x] 존재하는 테마에 대해서만 예약할 수 있다.
- [x] 관리자가 방탈출 예약 시, 테마 정보를 포함할 수 있다.

- [ ] 로그인 하지 않으면 예약이 불가능하다.
- [x] 사용자가 날짜를 선택하면 테마를 조회할 수 있다.
- [x] 사용자가 테마를 선택하면 예약 가능한 시간을 조회할 수 있다.
- [x] 사용자가 예약할 수 있다.
    - [ ] 로그인한 사용자로 예약한다.
- [x] 인기 테마 조회 기능을 추가합니다.
    - [x] 최근 일주일을 기준으로 해당 기간 내에 방문하는 예약이 많은 테마 10개를 조회한다.

## 추가 기능 구현

- [ ] 비밀번호 규칙
- [ ] 비밀번호 저장 시 암호화
- [ ] 연속 5회 로그인 실패 시 10분동안 로그인이 불가능
- [ ] 사용자 이름 중복 불가
- [ ] 외래키 제약 조건
