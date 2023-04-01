# BEReview

|JSON|오브젝트를 표현하기 위한 문자열||
| :- | :- | :- |
||오브젝트|메모리 상의 자료구조|
||직렬화 Serialization|서로 언어 또는 아키텍처가 다른 오브젝트를 변환 또는 전송을 위해 다른 형태로 변환하는 작업. 그 다른 형태가 JSON|
|서버|네트워크 오퍼레이션을 수행하는 프로그램||
||정적 웹 서버 Static-|<p>HTTP 서버 종류 중 하나.</p><p>리소스 파일을 반환하는 서버</p><p>React 등</p>|
||동적 웹 서버 Dynamic-|<p>요청값에 따라 응답 바디가 달라지는 서버</p><p>이 구현은 비즈니스 요구사항에 따라 모두 달라짐</p><p>모든 걸 개발자가 다 짤 필요는 없고, 서블릿 엔진(톰캣 등)의 도움을 받으면 됨</p>|
||서블릿 컨테이너(=서블릿 엔진)|<p>서블릿 엔진의 도움을 받으려면 클래스 파일을 Javax.servlet.httpHttpServlet 서브 클래스를 작성해야 됨</p><p>그 클래스의 상속 및 구현은 스프링 부트가 해 줌</p>|
  #
  #
|스프링|오픈 소스의 경량 프레임워크||
| :- | :- | :- |
||프레임워크|개발자들이 확장해서 사용할 수 있는 코드|
||확장?|<p>1. 프레임워크가 제공하는 클래스나 라이브러리를 사용</p><p>2. 프레임워크가 제공하는 클래스나 인터페이스를 상속 및 구현해 우리 코드를 프레임워크의 일부로 실행하는 것</p>|
||스프링 프레임워크|<p>의존성 주입, 스프링 AOP, 스프링 ORM, 스프링Web 등…</p><p>의존성 주입 컨테이너 중 하나</p>|
||의존성 주입|<p>의존?</p><p>특정 클래스에 의존하는 필드. 그 필드는 그 클래스가 존재해야 쓸 수 있다는 얘기임.</p><p></p><p>그런데 </p><p>1) 그 클래스를 바꾸고 싶을 수도 있고 </p><p>2) 그 클래스가 100개쯤 있을 수 있음. 그러면 그걸 다 치고 바꾸고 싶으면 그걸 다 바꿔야 함.</p><p>3) 단위 테스트하기가 힘듦. 단위 테스트를 할 때는 껍데기만 있는 클래스(=Mock 클래스)를 만들어서 쓰는데 이것도 어려움.</p><p></p><p>그래서 의존성을 외부에서 주입하려고 하는 거임. 어떻게 하냐면</p><p>1) 생성자를 쓰거나</p><p>2) Setter를 쓰는 거다.</p>|
  #
  #
|Logger 설정|<p>@Slf4j</p><p>로그계의 JPA</p>|
| :- | :- |
|Create|<p>Validate 메서드로 검증하고</p><p>Save()로 엔티티를 저장</p><p>findByUserId로 엔티티를 검색해서 리턴</p>|
|Retrieve|JpaRepository에서 국룰대로 만든 findByUserId() 메서드를 이용|
|Update|<p>findById로 가져온 다음 setter로 하나씩 바꿈</p><p>그 다음 save()로 저장</p>|
|Delete|Delete() 메서드로 삭제|

