# BEReview
#

|JSON|오브젝트를 표현하기 위한 문자열||
| :- | :- | :- |
||오브젝트|메모리 상의 자료구조. 스프링에서의 Bean|
||직렬화 Serialization|서로 언어 또는 아키텍처가 다른 오브젝트를 변환 또는 전송을 위해 다른 형태로 변환하는 작업. 그 다른 형태가 JSON|
|서버|네트워크 오퍼레이션을 수행하는 프로그램||
||정적 웹 서버 Static-|<p>HTTP 서버 종류 중 하나.</p><p>리소스 파일을 반환하는 서버</p><p>React 등</p>|
||동적 웹 서버 Dynamic-|<p>요청값에 따라 응답 바디가 달라지는 서버</p><p>이 구현은 비즈니스 요구사항에 따라 모두 달라짐</p><p>모든 걸 개발자가 다 짤 필요는 없고, 서블릿 엔진(톰캣 등)의 도움을 받으면 됨</p>|
||서블릿 컨테이너(=서블릿 엔진)|<p>서블릿 엔진의 도움을 받으려면 클래스 파일을 Javax.servlet.httpHttpServlet 서브 클래스를 작성해야 됨</p><p>그 클래스의 상속 및 구현은 스프링 부트가 해 줌</p>|
#
#
#
|스프링|오픈 소스의 경량 프레임워크||
| :- | :- | :- |
||프레임워크|개발자들이 확장해서 사용할 수 있는 코드|
||확장?|<p>1. 프레임워크가 제공하는 클래스나 라이브러리를 사용</p><p>2. 프레임워크가 제공하는 클래스나 인터페이스를 상속 및 구현해 우리 코드를 프레임워크의 일부로 실행하는 것</p>|
||스프링 프레임워크|<p>의존성 주입, 스프링 AOP, 스프링 ORM, 스프링Web 등…</p><p>의존성 주입 컨테이너 중 하나</p><p>오브젝트 간의 의존성을 명시하면 스프링의 IoC 컨테이너가 오브젝트를 관리해 줌</p><p></p><p>스프링을 쓰면</p><p>Servlet을 상속받지 않아도 되고</p><p>doGet을 오버라이드 하지 않아도 되고</p><p>ServletRequest를 직접 파싱하지 않아도 되고</p><p>ServletResponse를 직접 작성하지 않아도 되고 비즈니스 로직만 짜면 되기 때문에 쓰는 거임.</p>|
||의존성 주입|<p>의존?</p><p>특정 클래스에 의존하는 필드. 그 필드는 그 클래스가 존재해야 쓸 수 있다는 얘기임.</p><p></p><p>그런데 </p><p>1) 그 클래스를 바꾸고 싶을 수도 있고 </p><p>2) 그 클래스가 100개쯤 있을 수 있음. 그러면 그걸 다 치고 바꾸고 싶으면 그걸 다 바꿔야 함.</p><p>3) 단위 테스트하기가 힘듦. 단위 테스트를 할 때는 껍데기만 있는 클래스(=Mock 클래스)를 만들어서 쓰는데 이것도 어려움.</p><p></p><p>그래서 의존성을 외부에서 주입하려고 하는 거임. 어떻게 하냐면</p><p>1) 생성자를 쓰거나</p><p>2) Setter를 쓰는 거다.</p>|
||@SpringBootApplication|<p>이 클래스가 스프링부트 설정 클래스임을 의미</p><p>@Component, @ComponentScan 어노테이션 포함</p>|
||@Component|이 클래스를 자바 빈으로 등록시키라고 알려주는 어노테이션|
||@ComponentScan|이게 특정 클래스에 달려 있어야 @Component가 달려 있는 곳을 빈으로 등록할 수 있음|
||@Bean|로컬에서만 쓰이거나 엔터프라이즈 어플리케이션이거나 스프링기반이 아니라서 @Component를 못 쓸 때 @Bean을 이용해서 등록|
||@Autowired|스프링이 이게 달려있는 오브젝트를 찾아서 알아서 컨트롤러에 등록|
|REST API|URI Unified Resource Identifier, HTTP 메서드, 요청 바디로 구성||
#
#
|레이어드 아키텍처 패턴|애플리케이션을 구성하는 요소들을 수평으로 나눠 관리하는 것||
| :- | :- | :- |
||수평?|<p>레이어 없이 모든 기능을 메서드 없이 구현할 수도 있음</p><p>근데 그러면 재사용성이 떨어지니까 메서드로 쪼갬</p><p>메서드로 쪼개는 것도 복사-붙여넣기 귀찮으니까 클래스로 만듦</p><p>클래스로 만들어서 이곳저곳 쓰는 게 가장 기본적인 레이어</p>|
||계층|<p>레이어 사이에는 계층이 있고, 회사의 직급으로 생각하시면 됨.</p><p></p><p>고객-부장-차장-과장-대리-사원</p><p></p><p>요청-컨트롤러-서비스-퍼시스턴스-데이터</p>|
||엔티티 클래스|<p>기능 없이 데이터만 가지고 있는 클래스 (=모델, DTO Data Transfer Object)</p><p></p><p>1. NoArgsConstructor가 필요</p><p>2. Getter/Setter가 필요</p><p>3. 기본 키를 지정해 줘야 됨</p>|
|롬복|@Builder|<p>오브젝트 생성을 위한 디자인 패턴 Refactoring Guru 중 하나</p><p>이를 이용해 오브젝트를 생성할 수 있음</p>|
||@NoArgsConstuctor, @AllArgsConstructor||
||@Data|Getter/Setter|
|DTO 쓰는 이유|캡슐화|서비스 내부의 로직, DB 구조를 숨길 수 있음|
||클라이언트가 필요한 정보를 모델이 전부 가지고 있지 않은 경우가 있음|에러메시지 같은 것들. 그런 것들은 DTO에서 에러 필드를 만든 다음 DTO에 넣으면 됨.|
|REST|Representational State Transfer|아키텍처 스타일: 반복되는 아키텍처 디자인|
|||아키텍처 패턴: 반복되는 문제상황을 해결하기 위한 도구|
||RESTful API|6가지 제약조건을 따르는 API|
||Client-Server|<p>서버가 존재하고, 다수의 클라이언트가 네트워크를 소비하기 위해 네트워크를 통해 서버에 접근하는 구조</p><p>가장 익숙한 게 웹 앱</p>|
||Cacheable|<p>캐시가 가능한지 여부를 명시해야 됨</p><p>HTTP에서는 cache-control에서 명시할 수 있음</p>|
||Layered System|<p>클라이언트가 요청을 날릴 때 여러 개의 레이어를 거칠 수 있음. 예를 들면 인증-캐싱-로드 밸런서처럼.</p><p></p><p>레이어들은 요청 및 응답에 영향을 끼치지 않고 클라이언트는 레이어의 존재 유무를 모름</p>|
||Uniform Interface|날리는 요청이 일관적이어야 함. URI이든, 리턴타입이든. JSON으로 요청을 날리기로 했으면 전 구간에서 JSON 형식으로 리턴해야 됨|
||Stateless|<p>클라이언트가 서버에 요청을 날릴 때 이전 요청의 영향을 받지 않아야 함.</p><p></p><p>이전 요청의 영향을 받아야 하는 로그인 같은 경우라면 그 로그인 정보는 퍼시스턴스, 즉 DB 같은 곳에 상태를 저장해야 됨</p>|
||Code-On-Demand|클라이언트는 서버에 코드를 요청할 수 있고, 서버가 리턴한 코드를 실행할 수 있음.|
#
#
#
|@RestController|http 관련된 코드 및 매핑을 알아서 해 주는 어노테이션|
| :- | :- |
|@PathVariable|매개변수를 넘겨받는 방법 1|
|@RequestParam|매개변수를 넘겨받는 방법 2|
|@RequestBody|오브젝트처럼 복잡한 자료형을 넘겨받고 싶을 때 쓰는 어노테이션|
|서비스 레이어|<p>컨트롤러와 퍼시스턴스 사이에서 비즈니스 로직을 수행</p><p>1. HTTP와 긴밀히 연관된 컨트롤러에서 분리되어 있음</p><p>2. DB와 긴밀히 연관된 퍼시스턴스에서 분리되어 있음</p><p>집중하고 싶은 비즈니스 로직을 구현하기 좋음</p>|
|JPA 쓰는 이유|<p>ORM 하기 귀찮아서.</p><p>ORM Object-Relation Mapping이 뭐냐면</p><p>JDBC 깔아서</p><p>Connection으로 DB에 연결하고</p><p>쿼리 실행해서</p><p>ResultSet에 담고</p><p>While문 내에서 원하는 정보를 뽑아서 원하는 오브젝트로 바꾸는 것,.</p><p></p><p>그거를 좀 더 편하게 해 주는 게 Hibernate, JPA.</p>|
|스프링 데이터 JPA|JPA 편하게 쓰게 해 주는 거.  그 중 하나가 그게 저번에도 써 봤던 JPA provider 중 하나인 JpaRepository.|
|@Entity|JPA를 쓸 때 Entity 클래스에 달아 줌|
|@Table|테이블 이름 바꾸고 싶을 때 이용. 안 쓰면 1. @Entity, 2. 클래스의 이름을 테이블 이름으로 간주|
|@Id|기본 키에 달아 준다|
|@GeneratedValue|Id를 자동으로 생성하겠다는 뜻. 기본 Generator에 Incremental, Sequence, Identity 등이 있음|
|@GenericGenerator|커스텀 Generator를 사용하고 싶을 때 이용|
|JpaRepository<T, ID>|<p>T: 테이블에 매핑할 엔티티 클래스</p><p>ID: 그 엔티티의 기본 키 타입</p>|
|@Query|<p>JpaRepository가 제공하는 기본 쿼리 외에 다른 쿼리를 쓸 때는 국룰대로 메서드를 써 주면 됨.</p><p>국룰 주소: <https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#repositories.query-methods.query-creation></p><p></p><p>그것보다 더 복잡한 쿼리는 @Query를 이용</p>|
#
#
#
|Logger 설정|<p>@Slf4j</p><p>로그계의 JPA</p>|
| :- | :- |
|Create|<p>Validate 메서드로 검증하고</p><p>Save()로 엔티티를 저장</p><p>findByUserId로 엔티티를 검색해서 리턴</p>|
|Retrieve|JpaRepository에서 국룰대로 만든 findByUserId() 메서드를 이용|
|Update|<p>findById로 가져온 다음 setter로 하나씩 바꿈</p><p>그 다음 save()로 저장</p>|
|Delete|Delete() 메서드로 삭제|

