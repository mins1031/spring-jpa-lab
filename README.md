# 스프링과 JPA 개인 실험 프로젝트

## 선착순 쿠폰발급 프로젝트
간단한 선착순 쿠폰 발급 프로젝트로 동시성 제어 관련 여러가지 시도 해보기

### 요구사항 
1. 선착순 100명에게 30% 쿠폰 발급 이벤트 구현
2. 인당 1개만 발급 (=같은 userId로 발급 불가)
3. 쿠폰소진되면 요청 실패응답

### 발전방향
1. 단일서버에서 구현.
2. 이중 or 다중서버에서 구현.

### 주요 관심사
* 경합상황 제어를 여러가지 관점에서 고민해보고 여러 방식으로 구현해보는것

### 구현 빌드업
1. 큰 제어 없이 단일서버에서 동작
  * 경합상황으로 100개 이상 발급되어 버림
  * 이때 해결 방법은 여러가지임
    1. 코드 내부 동시성 처리
      * DB에서 쿠폰 갯수값을 관리하며 동시성제어를 해줘도 되지만 DB 통신 및 DB에 장애 발생 가능성을 높힐수 있어 최후의 선택지로 남겨놓음.
      * ReentrantLock으로 동시성제어
      * 단일서버에서만 사용하다는 큰 단점이 존재
        * 만약 쿠폰 갯수값을 공유공간(DB, REDIS 등)에 공유하더라도 갯수가 99인 상황에 2개의 서버에서 2개의 요청이 동시에 동작한다면 동일한 경합상황 발생함.
  * 결과 : 쿠폰은 100개만 발급완료. 다만 초당 tps가 100도 나오지 않기에 멀티스레딩으로 스레드 풀 도입해 대량 요청에 대응해볼 예정. -> 효과 확인 및 왜 효과가 있는지 학습 필요
2. 다중서버 환경에서 동작
  * Redis (1의 한계 개선)
    * 다중서버 성격상 쿠폰갯수값은 여러 서버가 처리 가능한 공유저장소에 위치해야한다.
    * 고로 코드 내부에서 동시성 제어는 한계까 명확히 존재.
    * Redis의 스프링 라이브러리인 Redission을 통해 레디스 값에 동시성 제어처리.
    * Redis의 부하 가능성 존재.
    * 단일서버 환경에서도 해당 방식으로 처리 가능.
  * DB Lock (1의 한계 개선)
