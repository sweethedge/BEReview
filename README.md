김다정, React.js, 스프링 부트, AWS로 배우는 웹 개발 101

![a](https://user-images.githubusercontent.com/113881813/230873284-2c046de9-5da7-4db0-a6fa-3fb126fd45e0.png)

![b](https://user-images.githubusercontent.com/113881813/230873296-2faf8edd-e7f3-4fb0-b677-fa2e9f62c93e.png)


|JSON|오브젝트를 표현하기 위한 문자열||
| :- | :- | :- |
||오브젝트|메모리 상의 자료구조. 스프링에서의 Bean|
||직렬화 Serialization|서로 언어 또는 아키텍처가 다른 오브젝트를 변환 또는 전송을 위해 다른 형태로 변환하는 작업. 그 다른 형태가 JSON|
|서버|네트워크 오퍼레이션을 수행하는 프로그램||
||정적 웹 서버 Static-|<p>HTTP 서버 종류 중 하나.</p><p>리소스 파일을 반환하는 서버</p><p>React 등</p>|
||동적 웹 서버 Dynamic-|<p>요청값에 따라 응답 바디가 달라지는 서버</p><p>이 구현은 비즈니스 요구사항에 따라 모두 달라짐</p><p>모든 걸 개발자가 다 짤 필요는 없고, 서블릿 엔진(톰캣 등)의 도움을 받으면 됨</p>|
||서블릿 컨테이너(=서블릿 엔진)|<p>서블릿 엔진의 도움을 받으려면 클래스 파일을 Javax.servlet.httpHttpServlet 서브 클래스를 작성해야 됨</p><p>그 클래스의 상속 및 구현은 스프링 부트가 해 줌</p>|

2\.1

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

2\.2

|레이어드 아키텍처 패턴|애플리케이션을 구성하는 요소들을 수평으로 나눠 관리하는 것|
| :- | :- |
||수평?|<p>레이어 없이 모든 기능을 메서드 없이 구현할 수도 있음</p><p>근데 그러면 재사용성이 떨어지니까 메서드로 쪼갬</p><p>메서드로 쪼개는 것도 복사-붙여넣기 귀찮으니까 클래스로 만듦</p><p>클래스로 만들어서 이곳저곳 쓰는 게 가장 기본적인 레이어</p>|
||계층|<p>레이어 사이에는 계층이 있고, 회사의 직급으로 생각하시면 됨.</p><p></p><p>고객-부장-차장-과장-대리-사원</p><p></p><p>요청-컨트롤러-서비스-퍼시스턴스-데이터</p>|
||엔티티 클래스|<p>기능 없이 데이터만 가지고 있는 클래스 (=모델, DTO Data Transfer Object)</p><p></p><p>1. NoArgsConstructor가 필요</p><p>2. Getter/Setter가 필요</p><p>3. 기본 키를 지정해 줘야 됨</p>|
|롬복|@Builder|<p>오브젝트 생성을 위한 디자인 패턴 Refactoring Guru 중 하나</p><p>이를 이용해 오브젝트를 생성할 수 있음</p>|
||@NoArgsConstuctor, @AllArgsConstructor||
||@Data|Getter/Setter|
|DTO 쓰는 이유|캡슐화|서비스 내부의 로직, DB 구조를 숨길 수 있음|
||클라이언트가 필요한 정보를 모델이 전부 가지고 있지 않은 경우가 있음|에러메시지 같은 것들. 그런 것들은 DTO에서 에러 필드를 만든 다음 DTO에 넣으면 됨.|
|REST|Representational State Transfer|<p>REST 자체는 아키텍처 스타일임.</p><p>아키텍처 스타일: 반복되는 아키텍처 디자인</p>|
|||아키텍처 패턴: 반복되는 문제상황을 해결하기 위한 도구|
||RESTful API|6가지 제약조건을 따르는 API|
||Client-Server|<p>서버가 존재하고, 다수의 클라이언트가 네트워크를 소비하기 위해 네트워크를 통해 서버에 접근하는 구조</p><p>가장 익숙한 게 웹 앱</p>|
||Cacheable|<p>캐시가 가능한지 여부를 명시해야 됨</p><p>HTTP에서는 cache-control에서 명시할 수 있음</p>|
||Layered System|<p>클라이언트가 요청을 날릴 때 여러 개의 레이어를 거칠 수 있음. 예를 들면 인증-캐싱-로드 밸런서처럼.</p><p></p><p>레이어들은 요청 및 응답에 영향을 끼치지 않고 클라이언트는 레이어의 존재 유무를 모름</p>|
||Uniform Interface|날리는 요청이 일관적이어야 함. URI이든, 리턴타입이든. JSON으로 요청을 날리기로 했으면 전 구간에서 JSON 형식으로 리턴해야 됨|
||Stateless|<p>클라이언트가 서버에 요청을 날릴 때 이전 요청의 영향을 받지 않아야 함.</p><p></p><p>이전 요청의 영향을 받아야 하는 로그인 같은 경우라면 그 로그인 정보는 퍼시스턴스, 즉 DB 같은 곳에 상태를 저장해야 됨</p>|
||Code-On-Demand|클라이언트는 서버에 코드를 요청할 수 있고, 서버가 리턴한 코드를 실행할 수 있음.|



|@RestController|http 관련된 코드 및 매핑을 알아서 해 주는 어노테이션|
| :- | :- |
|@PathVariable|매개변수를 넘겨받는 방법 1|
|@RequestParam|매개변수를 넘겨받는 방법 2|
|@RequestBody|오브젝트처럼 복잡한 자료형을 넘겨받고 싶을 때 쓰는 어노테이션|
|서비스 레이어|<p>컨트롤러와 퍼시스턴스 사이에서 비즈니스 로직을 수행</p><p>1. HTTP와 긴밀히 연관된 컨트롤러에서 분리되어 있음</p><p>2. DB와 긴밀히 연관된 퍼시스턴스에서 분리되어 있음</p><p>집중하고 싶은 비즈니스 로직을 구현하기 좋음</p>|
|JPA 쓰는 이유|<p>ORM 하기 귀찮아서.</p><p>ORM(Object-Relation Mapping)이 뭐냐면</p><p>JDBC 깔아서</p><p>Connection으로 DB에 연결하고</p><p>쿼리 실행해서</p><p>ResultSet에 담고</p><p>While문 내에서 원하는 정보를 뽑아서 원하는 오브젝트로 바꾸는 것,.</p><p></p><p>그거를 좀 더 편하게 해 주는 게 Hibernate, JPA.</p>|
|스프링 데이터 JPA|JPA 편하게 쓰게 해 주는 거.  그 중 하나가 그게 저번에도 써 봤던 JPA provider 중 하나인 JpaRepository.|
|JPA 설정|<p>yaml이나 application.properties에서 해 주는거.</p><p>Database, show-sql, database-platform: -.MySQL8Dialect</p><p>Hibernate: ddl-auto: update</p><p></p><p>Datasource 설정: url, username, password</p>|
|@Entity|JPA를 쓸 때 Entity 클래스에 달아 줌|
|@Table|테이블 이름 바꾸고 싶을 때 이용. 안 쓰면 1. @Entity, 2. 클래스의 이름을 테이블 이름으로 간주|
|@Id|기본 키에 달아 준다|
|@GeneratedValue|Id를 자동으로 생성하겠다는 뜻. 기본 Generator에 Incremental, Sequence, Identity 등이 있음|
|@GenericGenerator|커스텀 Generator를 사용하고 싶을 때 이용|
|JpaRepository<T, ID>|<p>T: 테이블에 매핑할 엔티티 클래스</p><p>ID: 그 엔티티의 기본 키 타입</p>|
|@Query|<p>JpaRepository가 제공하는 기본 쿼리 외에 다른 쿼리를 쓸 때는 국룰대로 메서드를 써 주면 됨.</p><p>국룰 주소: <https://docs.spring.io/spring-data/jpa.docs/current/reference/html/#jpa.query-methods.query-creation></p><p></p><p>그것보다 더 복잡한 쿼리는 @Query를 이용</p>|

2\.3

|Logger 설정|<p>@Slf4j</p><p>로그계의 JPA</p>|
| :- | :- |
|Create|<p>Validate 메서드로 검증하고</p><p>Save()로 엔티티를 저장</p><p>findByUserId로 엔티티를 검색해서 리턴</p>|
|Retrieve|JpaRepository에서 국룰대로 만든 findByUserId() 메서드를 이용|
|Update|<p>findById로 가져온 다음 setter로 하나씩 바꿈</p><p>그 다음 save()로 저장</p>|
|Delete|Delete() 메서드로 삭제|

3\.1

|프론트엔드|사용자의 바로 앞에서 앱 로직을 수행하고 백엔드로 요청을 전달하는 역할|
| :- | :- |
|Node.js|<p>JS를 브라우저 밖에서 실행할 수 있게 하는 프로그램. (=JS 런타임 환경)</p><p>V8 JS 엔진 실행</p><p></p><p>이게 무슨 얘기냐면 JS로 서버를 만들 수 있다는 얘기임</p>|
|Npm Node Package Manager|Gradle/Maven같은 거.|
|Package.json|프로젝트의 메타데이터, 사용할 node.js 패키지 목록 등을 포함|
|Package-lock.json|어느 환경에서든 같은 버전의 패키지가 설치되도록 각 패키지가 사용할 버전을 고정하는 파일|
|파싱|<p>렌더링을 하기 위한 전처리 단계</p><p>1. HTML을 트리 자료구조의 형태인 DOM Document Object Model 트리로 변환</p><p>2. 리소스를 다운로드(image, css, script 등)</p><p>2-1. CSS의 경우 다운로드 하고 CSSOM CSS Object Mode 트리로 변환</p><p>3. 다운로드안 JS를 인터프리트, 컴파일, 파싱, 실행</p>|
|렌더링|<p>한마디로 말하면 화면에 보여주는 거.</p><p></p><p>파싱 이후 단계</p><p>1. DOM 트리와 CSSOM 트리를 합쳐 렌더 트리를 만듦.</p><p>2. 레이아웃을 정함:</p><p>브라우저 상 트리의 위치 및 크기를 정하는 것</p><p>3. 브라우저 스크린에 렌더트리의 각 노드를 그려줌</p><p></p><p>그러니까 리액트는 ReactDOM(Virtual DOM)을 가지고 있음.</p><p>어찌 됐든 상태(State)가 변하면 ReactDOM이 이를 감지하고 컴포넌트 함수를 다시 호출해서 변경된 부분의 HTML을 바꿔 줌</p>|
|SPA Single Page Application|<p>한번 웹 페이지를 로딩하면 유저가 임의로 새로고침하지 않는 이상 페이지를 새로 로딩하지 않는 애플리케이션</p><p></p><p>페이지가 바뀔 때 js 내에서 html이 재구성되므로 서버에 새 html 페이지를 요청하지 않음</p><p></p><p>이렇게 렌더링 하는 걸 Client-Side Rendering이라고 얘기함</p>|
|JSX|리액트가 한 파일에서 HTML과 JS를 함께 사용하기 위해 확장한 JS 문법|


3\.2

|훅|리액트의 상태와 여러가지 기능을 사용할 수 있도록 도와주는 함수. UseState같은 거.|
| :- | :- |
|UseState|<p>함수형 컴포넌트에서 상태 변수를 사용할 수 있게 해 줌</p><p></p><p>상태변수는 사용자가 무언가를 할 때마다 바뀜. 이를 추적해서 새 상태가 화면에 나타나도록 렌더링 해야 될 거임</p><p></p><p>이 오브젝트가 상태라고 알려주는 함수가 UseState 함수</p><p></p><p>배열을 반환: [A, B]</p><p>첫 번째는 오브젝트고, 두 번째는 상태를 업데이트할 수 있는 함수</p>|
|상태 변수?|시간이 지나거나, 컴포넌트의 사용자가 컴포넌트와 상호작용하는 동안 변경되는 변수|
|{}|JS로 된 변수를 JSX에서 쓰려면 변수를 {}로 묶어주면 됨|
|콜백 함수|<p>소괄호 안에 들어가는 함수</p><p>어떤 사건이 일어났을 때의 상태와 그 사건에 대한 정보를 담고 있음</p>|
|map|<p>Array 자료 개수만큼 함수안의 코드 실행해 줌</p><p>변수가 JSON이라면 JSON의 key값을 key={변수.key} 로 뽑아서 쓸 수 있음</p>|
|event.target.value|매개변수의 값이 담겨 있음|
|스프레드 연산자[…]로 새 배열 만든 이유|<p>리액트는 레퍼런스를 기준으로 재렌더링함</p><p>근데 배열의 레퍼런스는 배열에 값을 추가하더라도 변하지 않음</p><p></p><p>근데 값을 바꿨으면 변해야 되니까 아예 배열을 …으로 새로 만든 거(=초기화)임</p>|
|.filter|조건에 맞는 경우만 필터링|


3\.3

|CORS Cross-Origin Resource Sharing|처음 리소스를 제공한 도메인(=Origin)이 현재 요청하려는 도메인과 다르더라도 요청을 허락해주는 웹 보안 방침|
| :- | :- |
|useEffect|원래 리액트는 컴포넌트가 변하면 ReactDOM이 이를 감지해서 렌더링을 해 줌. 근데 상태를 업데이트하는 함수가 끼어 들어가면 렌더링을 또 하고, 이게 계속 반복되면 무한루프에 들어가는 거임. 이걸 useEffect로 방지할 수 있음.|
||useEffect(콜백함수, 디펜던시 배열)|<p>첫 렌더링(=마운팅)이 일어났을 때 실행되고, 배열의 오브젝트 값이 변할 때마다 콜백 함수를 부름</p><p></p><p>그래서 렌더링 뒤에 효과(Effect)가 발생해서 useEffect</p>|
|fetch|Promise|<p>비동기 오퍼레이션에서 사용</p><p></p><p>비동기 오퍼레이션?</p><p>원래 JS가 싱글스레드임.</p><p>무슨 얘기냐면 하나의 작업이 끝나야 다음 작업으로 갈 수 있다는 얘기</p><p></p><p>근데 그러면 웹 페이지 로딩 언제 하냐</p><p></p><p>그래서 JS 스레드 밖에서 오퍼레이트하니까 비동기 오퍼레이션</p><p></p><p>근데 JS 밖에서 실행하면 어떻게 알아봄? -> 콜백 함수로 알아본다</p>|
||Fetch 말고 XMLHttpRequest 라는 걸 써도 됨|그러면 콜백 함수 안에서 HTTP 요청을 날리고 그걸 날리기 위해서 또 콜백을 또 쓰고 하면 코드가 상당히 지저분해짐. 이걸 콜백 지옥(Callback Hell)이라고 함|
||Promise|<p>그 콜백 지옥을 피하기 위해 쓰는 방법 중 하나.</p><p></p><p>Pending, Fulfilled, Rejected 상태가 있음</p><p></p><p>- Pending</p><p>오퍼레이션이 끝나기를 기다리는 상태. 오퍼레이션이 성공적으로 끝나면 resolve함수로 끝났다는 걸 알리고 then의 매개변수로 넘어오는 함수를 실행할 수 있음</p><p>- Reject / catch</p><p>오퍼레이션 중에 문제가 생기는 경우 reject 함수를 콜하거나 catch의 매개변수로 넘어오는 함수를 실행함</p>|
||그래서 Fetch가 뭐냐면|<p>JS가 제공하는 API 서버로 http 요청을 송신 및 수신할 수 있도록 도와주는 메서드</p><p>url 또는 url, options를 메개변수로 받을 수 있고, Promise 오브젝트를 반환함.</p><p></p><p>무슨 얘기냐면 then, catch에 onResolve, onReject, onError 콜백 함수를 전달해서 응답을 처리할 수 있다는 얘기임</p>|
||onReject / onError|<p>- onReject</p><p>네트워크 오류처럼 외부에서 터지는 요청 실패를 처리</p><p>- onError</p><p>요청이 정상적으로 이루어진 후 발생할 수 있는 에러(JSON 파싱 오류 등)을 처리하는데 사용</p><p></p><p>꼭 구분하거나 하진 않고 catch()로 처리하는 경우도 많다는 것 같다</p>|


4\.1

|인증|로그인 요청 및 확인|
| :- | :- |
|인가|로그인을 한 유저에게 할 수 있는 자원을 정의하는 것|
|Basic 인증|<p>모든 HTTP 요청에 아이디와 비밀번호를 같이 보내는 것</p><p></p><p>아이디와 비밀번호를 콜론으로 이어 붙인 후 Base64로 인코딩한 문자열을 함께 보냄</p><p>단점:</p><p>1. 디코더만 있으면 바로 뚫림</p><p>2. MITM(Manipulator in the Middle) 공격에 취약함</p><p>2-1. 무슨 얘기냐면 무조건 HTTPS를 써야 한다는 뜻임</p><p>- 중간에 HTTP 요청을 가로채 문자열을 디코딩하는 것</p><p>3. 유저를 로그아웃 시킬 수 없음</p><p>4. 인증 서버 및 인증 DB에 과부하가 걸릴 확률이 높음</p><p>5. 서비스를 2개로 쪼갠다 그러자. 서비스 1에서 인증하고 서비스 2에서도 인증해야 됨</p><p>6. 인증 서버가 단일 장애점이 됨</p>|
|토큰 기반 인증|토큰|<p>사용자를 구별할 수 있는 문자열</p><p>근데 이건 서버가 만들어 줌</p><p>서버가 만든 토큰을 클라이언트가 넘겨서 인증된 사용자임을 알려 줌</p>|
||장점|<p>1. 아이디와 비밀번호를 매번 날리지 않기 때문에 Basic Auth보다 조금 더 안전함</p><p>2. 서버가 만들어주는 거라서 인가 정보를 넣어주거나 유효기간을 정할 수 있음</p><p>3. 디바이스마다 다른 토큰을 생성해서 유효기간을 다르게 정하거나 로그아웃할 수 있음</p>|
||단점|<p>1. 이것도 MITM으로 뚫릴 수 있음</p><p>2. 이것도 서버에 부하를 거는 건 Basic 인증과 똑같음</p>|
|JWT|전자서명된 토큰 중 하나|{header}.{payload}.{signature}로 구성|
||Header|<p>- Typ</p><p>Type. 토큰의 타입</p><p>- Alg</p><p>Algorithm. 토큰의 서명을 발행하기 위해 사용된 해시 알고리듬</p>|
||Payload|<p>- Sub</p><p>Subject. 토큰의 주인. Unique identifier여야 함</p><p>- Iss</p><p>Issuer. 토큰을 발행한 주체. Demo app, fb, naver…</p><p>- Iat</p><p>Issued at. 토큰이 발행된 날짜와 시간</p><p>- Exp</p><p>Expiration. 토큰이 만료되는 시간.</p>|
||Signature|토큰을 발행한 issuer가 발행한 서명. 토큰의 유효성 검사에 사용됨|
||작동 원리|<p>1. 인증한 사용자의 {header}.{payload} 작성</p><p>2. 자신의 시크릿 키로 {header}.{payload}를 서명해서 {header}.{payload}.{signature}로 이어붙인 후 Base64로 인코딩한 후 반환</p><p>3. 토큰으로 리소스 접근을 요구하면 일단 디코딩해서 {header}.{payload}로 전자 서명을 만든 뒤, signature를 비교</p>|
||장점|서버에 부하를 일으키지 않음|
|||토큰이 MITM 등으로 털릴 수 있는 건 Basic 인증과 똑같음|


4\.3

|스프링 시큐리티|서블릿 필터의 집합||
| :- | :- | :- |
||서블릿 필터|<p>서블릿 실행 전에 실행되는 클래스</p><p>HttpFilter 또는 Filter를 상속해서 doFilter 메서드를 오버라이딩함</p><p>DispatcherServlet 실행 전에 실행됨</p><p>이 필터를 통해서 원치 않는 HTTP 요청을 거절할 수 있음</p><p></p><p>이 필터를 여러 개 깔아서 순서대로 실행시킬 수도 있음(FilterChain)</p>|
||OncePerRequestFilter|<p>서블릿 필터 중 하나.</p><p>한 요청당 반드시 한 번만 실행됨</p>|
||@AuthenticationPrincipal|HttpSecurity를 구현한 클래스에서 UsernamePasswordAuthenticationToken를 생성했을 때 생성자의 첫 번째 매개변수.|
||Salting|<p>값에 의미없는 값을 더해서 암호화하는 것</p><p>값이 매번 달라지기 때문에 spring의 BcryptPasswordEncoder에서는 matches() 메서드로 두 값을 비교함</p>|

5\.1

|Server-Side Routing|특정 주소에 주소를 요청하면 그 때 웹 페이지를 렌더링하고 그 웹 페이지를 새로고침하는 것||
| :- | :- | :- |
|Client-Side Routing|<p>서버로 어떤 요청도 날리지 않는 라우팅</p><p>JS가 모든 라우팅을 해 줌</p><p></p><p>처음 주소에 들어가면 모든 리소스를 다 받아 옴</p>||
|React-router-dom|클라이언트 사이드 라우팅 라이브러리 중 하나||
||<BrowserRouter>|<p>오래된 버전의 클라이언트 사이드 라우팅의 경우 브라우저 히스토리 문제로 기능 구현이 제대로 되지 않는 경우가 있음</p><p></p><p>그 히스토리를 사용해서 브라우저-리액트 간 URL을 동기화하는 컴포넌트</p>|
||<Routes>|여러 개의 <Route>를 관리하고 가장 적합한 <Route>를 찾아주는 컴포넌트|


5\.3

|웹 스토리지|데이터를 key, value형태로 저장||
| :- | :- | :- |
||세션 스토리지|브라우저를 닫으면 사라짐|
||로컬 스토리지|브라우저 닫아도 값 남아 있음|


6\.1

|EC2 Elastic Compute Cloud|서버|
| :- | :- |
|도메인 이름 Domain Name|IP를 대신하는 이름|
|DNS Domain Name System|도메인 이름과 주소를 매핑해 놓은 시스템|
|Route 53|DNS 중 하나|
|Virtual IP|두 인스턴스가 공유하는 IP|
|Application Load Balancer|트래픽을 적절히 분배해주는 하드웨어 또는 소프트웨어|
|Target Group|AWS에서, 로드 밸런서에 연결되어 있는 인스턴스.|
|Auto Scaling Group ASG|<p>인스턴스가 죽었을 때, ASG가 적정 인스턴스 수만큼 인스턴스를 실행시킴.</p><p>최소, 최대, 적정 인스턴스 수는 정할 수 있음</p><p></p><p>알아서 scale in, scale out하도록 설정할 수도 있고.</p>|
|VPC Virtual Private Cloud|AWS 전용 가상 네트워크|
|가상 네트워크|EC2밖에서 VPC 내부로 접근하지 못함|
|AWS 일래스틱 빈스톡 ElasticBeanStalk|<p>얘가 위 표에 있는 여러 인프라를 알아서 처리해줌</p><p></p><p>이 과제에서는 RDS,  로드 밸런서, ASG, EC2, 타깃 그룹을 설정해 줌</p>|
|AWS Cloudformation|JSON 또는 YML 파일을 이용해 리소스 및 관계를 표시|
|IaC Infrastructure as Code|파일을 바탕으로 인프라를 구축하는 것|


6\.5

|Route 53|<p>MITM 공격은 Basic / Token / JWT 만으로 막을 수 없음</p><p>HTTPS 인증서가 필요</p>||
| :- | :- | :- |
||인증서|를 쓰려면 일단 자신의 도메인이 있어야 됨. 그걸 해주는 서비스가 Route 53|
||Host Zone|DNS 영역 파일|
|||<p>DNS 영역(=DNS Namespace)</p><p>니가 만든 도메인이 관리할 영역</p><p></p><p>여러 개의 레코드를 한 곳에서 관리하려고 만듦</p>|
||레코드|<p>SOA Start Of Authority 레코드</p><p>이 영역을 관리하는 관리자의 정보</p><p>NS 레코드</p><p>해당 도메인</p><p>A 레코드</p><p>해당 도메인의 서브 도메인이나 특정 IP로 연결하는 레코드</p>|
||||
||||
||||
||||

6\.6 

인증서:

Aws console > certificate manager에서 인증서 만들고

Elastic beanstalk에서 https 포트만 활성화

이 이후로는 당연히 그냥 http 도메인으로 접속 불가

Ec2 프론트엔드에서 80포트를 443포트로 redirect

