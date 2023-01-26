## DatabaseProject
##### 데이터베이스를 이용한 단어 맞추기 게임
---


### 💡 프로젝트 목표

- 객체지향 설계 및 구현 연습
- 네트워크 프로그래밍 구현 연습
- DB & Java 연동 연습
- CRUD에 대한 이해와 연습
- SQL 익숙해지기
- 효율적인 예외 처리 및 테스트 

---

### 📃 기능

- 회원 가입
- 로그인
  - 정보 수정 
  - 정보 삭제
  - 내 정보 보기
  - 게임 시작
  - 랭킹 보기
- ID 찾기
- PW 찾기
- 관리자 모드
  - 모든 회원 정보 보기
  - 회원 수정
  - 회원 삭제
  - 단어 관리
   - 단어 전체 보기
   - 단어 추가
   - 단어 삭제
  - 회원 찾기

---

### 📊 DB Table
```sql
<테이블>
CREATE TABLE GAMEUSER (
ID VARCHAR(20) PRIMARY KEY,
PASSWORD VARCHAR(30) NOT NULL,
NAME VARCHAR(30) NOT NULL,
EMAIL VARCHAR(20) NOT NULL,
SCORE INT NOT NULL,
);

CREATE TABLE WORD (
QUESTION VARCHAR(20) PRIMARY KEY,
ANSWER VARCHAR(30) NOT NULL,
SCORE INT NOT NULL,
);
```


### 📑 리뷰 및 개선방향

---

- SQL 익숙해지기
- 효율적인 전체 구조 및 흐름에 대하여
- 더 객체지향적으로 설계에 대하여
- 효율적인 예외 처리 및 테스트 

