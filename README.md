1

<table>
<colgroup>
<col style="width: 28%" />
<col style="width: 30%" />
<col style="width: 41%" />
</colgroup>
<thead>
<tr class="header">
<th>JSON</th>
<th>오브젝트를 표현하기 위한 문자열</th>
<th></th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td></td>
<td>오브젝트</td>
<td>메모리 상의 자료구조. 스프링에서의 Bean</td>
</tr>
<tr class="even">
<td></td>
<td>직렬화 Serialization</td>
<td>서로 언어 또는 아키텍처가 다른 오브젝트를 변환 또는 전송을 위해 다른 형태로 변환하는 작업. 그 다른 형태가 JSON</td>
</tr>
<tr class="odd">
<td>서버</td>
<td>네트워크 오퍼레이션을 수행하는 프로그램</td>
<td></td>
</tr>
<tr class="even">
<td></td>
<td>정적 웹 서버 Static-</td>
<td><p>HTTP 서버 종류 중 하나.</p>
<p>리소스 파일을 반환하는 서버</p>
<p>React 등</p></td>
</tr>
<tr class="odd">
<td></td>
<td>동적 웹 서버 Dynamic-</td>
<td><p>요청값에 따라 응답 바디가 달라지는 서버</p>
<p>이 구현은 비즈니스 요구사항에 따라 모두 달라짐</p>
<p>모든 걸 개발자가 다 짤 필요는 없고, 서블릿 엔진(톰캣 등)의 도움을 받으면 됨</p></td>
</tr>
<tr class="even">
<td></td>
<td>서블릿 컨테이너(=서블릿 엔진)</td>
<td><p>서블릿 엔진의 도움을 받으려면 클래스 파일을 Javax.servlet.httpHttpServlet 서브 클래스를 작성해야 됨</p>
<p>그 클래스의 상속 및 구현은 스프링 부트가 해 줌</p></td>
</tr>
</tbody>
</table>

2.1

<table>
<colgroup>
<col style="width: 16%" />
<col style="width: 34%" />
<col style="width: 49%" />
</colgroup>
<thead>
<tr class="header">
<th>스프링</th>
<th>오픈 소스의 경량 프레임워크</th>
<th></th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td></td>
<td>프레임워크</td>
<td>개발자들이 확장해서 사용할 수 있는 코드</td>
</tr>
<tr class="even">
<td></td>
<td>확장?</td>
<td><ol type="1">
<li><p>프레임워크가 제공하는 클래스나 라이브러리를 사용</p></li>
<li><p>프레임워크가 제공하는 클래스나 인터페이스를 상속 및 구현해 우리 코드를 프레임워크의 일부로 실행하는 것</p></li>
</ol></td>
</tr>
<tr class="odd">
<td></td>
<td>스프링 프레임워크</td>
<td><p>의존성 주입, 스프링 AOP, 스프링 ORM, 스프링Web 등…</p>
<p>의존성 주입 컨테이너 중 하나</p>
<p>오브젝트 간의 의존성을 명시하면 스프링의 IoC 컨테이너가 오브젝트를 관리해 줌</p>
<p>스프링을 쓰면</p>
<p>Servlet을 상속받지 않아도 되고</p>
<p>doGet을 오버라이드 하지 않아도 되고</p>
<p>ServletRequest를 직접 파싱하지 않아도 되고</p>
<p>ServletResponse를 직접 작성하지 않아도 되고 비즈니스 로직만 짜면 되기 때문에 쓰는 거임.</p></td>
</tr>
<tr class="even">
<td></td>
<td>의존성 주입</td>
<td><p>의존?</p>
<p>특정 클래스에 의존하는 필드. 그 필드는 그 클래스가 존재해야 쓸 수 있다는 얘기임.</p>
<p>그런데</p>
<ol type="1">
<li><p>그 클래스를 바꾸고 싶을 수도 있고</p></li>
<li><p>그 클래스가 100개쯤 있을 수 있음. 그러면 그걸 다 치고 바꾸고 싶으면 그걸 다 바꿔야 함.</p></li>
<li><p>단위 테스트하기가 힘듦. 단위 테스트를 할 때는 껍데기만 있는 클래스(=Mock 클래스)를 만들어서 쓰는데 이것도 어려움.</p></li>
</ol>
<p>그래서 의존성을 외부에서 주입하려고 하는 거임. 어떻게 하냐면</p>
<ol type="1">
<li><p>생성자를 쓰거나</p></li>
<li><p>Setter를 쓰는 거다.</p></li>
</ol></td>
</tr>
<tr class="odd">
<td></td>
<td>@SpringBootApplication</td>
<td><p>이 클래스가 스프링부트 설정 클래스임을 의미</p>
<p>@Component, @ComponentScan 어노테이션 포함</p></td>
</tr>
<tr class="even">
<td></td>
<td>@Component</td>
<td>이 클래스를 자바 빈으로 등록시키라고 알려주는 어노테이션</td>
</tr>
<tr class="odd">
<td></td>
<td>@ComponentScan</td>
<td>이게 특정 클래스에 달려 있어야 @Component가 달려 있는 곳을 빈으로 등록할 수 있음</td>
</tr>
<tr class="even">
<td></td>
<td>@Bean</td>
<td>로컬에서만 쓰이거나 엔터프라이즈 어플리케이션이거나 스프링기반이 아니라서 @Component를 못 쓸 때 @Bean을 이용해서 등록</td>
</tr>
<tr class="odd">
<td></td>
<td>@Autowired</td>
<td>스프링이 이게 달려있는 오브젝트를 찾아서 알아서 컨트롤러에 등록</td>
</tr>
<tr class="even">
<td>REST API</td>
<td>URI Unified Resource Identifier, HTTP 메서드, 요청 바디로 구성</td>
<td></td>
</tr>
</tbody>
</table>

2.2

<table>
<colgroup>
<col style="width: 27%" />
<col style="width: 31%" />
<col style="width: 41%" />
</colgroup>
<thead>
<tr class="header">
<th>레이어드 아키텍처 패턴</th>
<th colspan="2">애플리케이션을 구성하는 요소들을 수평으로 나눠 관리하는 것</th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td></td>
<td>수평?</td>
<td><p>레이어 없이 모든 기능을 메서드 없이 구현할 수도 있음</p>
<p>근데 그러면 재사용성이 떨어지니까 메서드로 쪼갬</p>
<p>메서드로 쪼개는 것도 복사-붙여넣기 귀찮으니까 클래스로 만듦</p>
<p>클래스로 만들어서 이곳저곳 쓰는 게 가장 기본적인 레이어</p></td>
</tr>
<tr class="even">
<td></td>
<td>계층</td>
<td><p>레이어 사이에는 계층이 있고, 회사의 직급으로 생각하시면 됨.</p>
<p>고객-부장-차장-과장-대리-사원</p>
<p>요청-컨트롤러-서비스-퍼시스턴스-데이터</p></td>
</tr>
<tr class="odd">
<td></td>
<td>엔티티 클래스</td>
<td><p>기능 없이 데이터만 가지고 있는 클래스 (=모델, DTO Data Transfer Object)</p>
<ol type="1">
<li><p>NoArgsConstructor가 필요</p></li>
<li><p>Getter/Setter가 필요</p></li>
<li><p>기본 키를 지정해 줘야 됨</p></li>
</ol></td>
</tr>
<tr class="even">
<td>롬복</td>
<td>@Builder</td>
<td><p>오브젝트 생성을 위한 디자인 패턴 Refactoring Guru 중 하나</p>
<p>이를 이용해 오브젝트를 생성할 수 있음</p></td>
</tr>
<tr class="odd">
<td></td>
<td>@NoArgsConstuctor, @AllArgsConstructor</td>
<td></td>
</tr>
<tr class="even">
<td></td>
<td>@Data</td>
<td>Getter/Setter</td>
</tr>
<tr class="odd">
<td>DTO 쓰는 이유</td>
<td>캡슐화</td>
<td>서비스 내부의 로직, DB 구조를 숨길 수 있음</td>
</tr>
<tr class="even">
<td></td>
<td>클라이언트가 필요한 정보를 모델이 전부 가지고 있지 않은 경우가 있음</td>
<td>에러메시지 같은 것들. 그런 것들은 DTO에서 에러 필드를 만든 다음 DTO에 넣으면 됨.</td>
</tr>
<tr class="odd">
<td>REST</td>
<td>Representational State Transfer</td>
<td><p>REST 자체는 아키텍처 스타일임.</p>
<p>아키텍처 스타일: 반복되는 아키텍처 디자인</p></td>
</tr>
<tr class="even">
<td></td>
<td></td>
<td>아키텍처 패턴: 반복되는 문제상황을 해결하기 위한 도구</td>
</tr>
<tr class="odd">
<td></td>
<td>RESTful API</td>
<td>6가지 제약조건을 따르는 API</td>
</tr>
<tr class="even">
<td></td>
<td>Client-Server</td>
<td><p>서버가 존재하고, 다수의 클라이언트가 네트워크를 소비하기 위해 네트워크를 통해 서버에 접근하는 구조</p>
<p>가장 익숙한 게 웹 앱</p></td>
</tr>
<tr class="odd">
<td></td>
<td>Cacheable</td>
<td><p>캐시가 가능한지 여부를 명시해야 됨</p>
<p>HTTP에서는 cache-control에서 명시할 수 있음</p></td>
</tr>
<tr class="even">
<td></td>
<td>Layered System</td>
<td><p>클라이언트가 요청을 날릴 때 여러 개의 레이어를 거칠 수 있음. 예를 들면 인증-캐싱-로드 밸런서처럼.</p>
<p>레이어들은 요청 및 응답에 영향을 끼치지 않고 클라이언트는 레이어의 존재 유무를 모름</p></td>
</tr>
<tr class="odd">
<td></td>
<td>Uniform Interface</td>
<td>날리는 요청이 일관적이어야 함. URI이든, 리턴타입이든. JSON으로 요청을 날리기로 했으면 전 구간에서 JSON 형식으로 리턴해야 됨</td>
</tr>
<tr class="even">
<td></td>
<td>Stateless</td>
<td><p>클라이언트가 서버에 요청을 날릴 때 이전 요청의 영향을 받지 않아야 함.</p>
<p>이전 요청의 영향을 받아야 하는 로그인 같은 경우라면 그 로그인 정보는 퍼시스턴스, 즉 DB 같은 곳에 상태를 저장해야 됨</p></td>
</tr>
<tr class="odd">
<td></td>
<td>Code-On-Demand</td>
<td>클라이언트는 서버에 코드를 요청할 수 있고, 서버가 리턴한 코드를 실행할 수 있음.</td>
</tr>
</tbody>
</table>

<table>
<colgroup>
<col style="width: 23%" />
<col style="width: 76%" />
</colgroup>
<thead>
<tr class="header">
<th>@RestController</th>
<th>http 관련된 코드 및 매핑을 알아서 해 주는 어노테이션</th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td>@PathVariable</td>
<td>매개변수를 넘겨받는 방법 1</td>
</tr>
<tr class="even">
<td>@RequestParam</td>
<td>매개변수를 넘겨받는 방법 2</td>
</tr>
<tr class="odd">
<td>@RequestBody</td>
<td>오브젝트처럼 복잡한 자료형을 넘겨받고 싶을 때 쓰는 어노테이션</td>
</tr>
<tr class="even">
<td>서비스 레이어</td>
<td><p>컨트롤러와 퍼시스턴스 사이에서 비즈니스 로직을 수행</p>
<ol type="1">
<li><p>HTTP와 긴밀히 연관된 컨트롤러에서 분리되어 있음</p></li>
<li><p>DB와 긴밀히 연관된 퍼시스턴스에서 분리되어 있음</p></li>
</ol>
<p>집중하고 싶은 비즈니스 로직을 구현하기 좋음</p></td>
</tr>
<tr class="odd">
<td>JPA 쓰는 이유</td>
<td><p>ORM 하기 귀찮아서.</p>
<p>ORM(Object-Relation Mapping)이 뭐냐면</p>
<p>JDBC 깔아서</p>
<p>Connection으로 DB에 연결하고</p>
<p>쿼리 실행해서</p>
<p>ResultSet에 담고</p>
<p>While문 내에서 원하는 정보를 뽑아서 원하는 오브젝트로 바꾸는 것,.</p>
<p>그거를 좀 더 편하게 해 주는 게 Hibernate, JPA.</p></td>
</tr>
<tr class="even">
<td>스프링 데이터 JPA</td>
<td>JPA 편하게 쓰게 해 주는 거. 그 중 하나가 그게 저번에도 써 봤던 JPA provider 중 하나인 JpaRepository.</td>
</tr>
<tr class="odd">
<td>@Entity</td>
<td>JPA를 쓸 때 Entity 클래스에 달아 줌</td>
</tr>
<tr class="even">
<td>@Table</td>
<td>테이블 이름 바꾸고 싶을 때 이용. 안 쓰면 1. @Entity, 2. 클래스의 이름을 테이블 이름으로 간주</td>
</tr>
<tr class="odd">
<td>@Id</td>
<td>기본 키에 달아 준다</td>
</tr>
<tr class="even">
<td>@GeneratedValue</td>
<td>Id를 자동으로 생성하겠다는 뜻. 기본 Generator에 Incremental, Sequence, Identity 등이 있음</td>
</tr>
<tr class="odd">
<td>@GenericGenerator</td>
<td>커스텀 Generator를 사용하고 싶을 때 이용</td>
</tr>
<tr class="even">
<td>JpaRepository&lt;T, ID&gt;</td>
<td><p>T: 테이블에 매핑할 엔티티 클래스</p>
<p>ID: 그 엔티티의 기본 키 타입</p></td>
</tr>
<tr class="odd">
<td>@Query</td>
<td><p>JpaRepository가 제공하는 기본 쿼리 외에 다른 쿼리를 쓸 때는 국룰대로 메서드를 써 주면 됨.</p>
<p>국룰 주소: <a href="https://docs.spring.io/spring-data/jpa.docs/current/reference/html/#jpa.query-methods.query-creation">https://docs.spring.io/spring-data/jpa.docs/current/reference/html/#jpa.query-methods.query-creation</a></p>
<p>그것보다 더 복잡한 쿼리는 @Query를 이용</p></td>
</tr>
</tbody>
</table>

2.3

<table>
<colgroup>
<col style="width: 28%" />
<col style="width: 71%" />
</colgroup>
<thead>
<tr class="header">
<th>Logger 설정</th>
<th><p>@Slf4j</p>
<p>로그계의 JPA</p></th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td>Create</td>
<td><p>Validate 메서드로 검증하고</p>
<p>Save()로 엔티티를 저장</p>
<p>findByUserId로 엔티티를 검색해서 리턴</p></td>
</tr>
<tr class="even">
<td>Retrieve</td>
<td>JpaRepository에서 국룰대로 만든 findByUserId() 메서드를 이용</td>
</tr>
<tr class="odd">
<td>Update</td>
<td><p>findById로 가져온 다음 setter로 하나씩 바꿈</p>
<p>그 다음 save()로 저장</p></td>
</tr>
<tr class="even">
<td>Delete</td>
<td>Delete() 메서드로 삭제</td>
</tr>
</tbody>
</table>

3.1

<table>
<colgroup>
<col style="width: 34%" />
<col style="width: 65%" />
</colgroup>
<thead>
<tr class="header">
<th>프론트엔드</th>
<th>사용자의 바로 앞에서 앱 로직을 수행하고 백엔드로 요청을 전달하는 역할</th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td>Node.js</td>
<td><p>JS를 브라우저 밖에서 실행할 수 있게 하는 프로그램. (=JS 런타임 환경)</p>
<p>V8 JS 엔진 실행</p>
<p>이게 무슨 얘기냐면 JS로 서버를 만들 수 있다는 얘기임</p></td>
</tr>
<tr class="even">
<td>Npm Node Package Manager</td>
<td>Gradle/Maven같은 거.</td>
</tr>
<tr class="odd">
<td>Package.json</td>
<td>프로젝트의 메타데이터, 사용할 node.js 패키지 목록 등을 포함</td>
</tr>
<tr class="even">
<td>Package-lock.json</td>
<td>어느 환경에서든 같은 버전의 패키지가 설치되도록 각 패키지가 사용할 버전을 고정하는 파일</td>
</tr>
<tr class="odd">
<td>파싱</td>
<td><p>렌더링을 하기 위한 전처리 단계</p>
<ol type="1">
<li><p>HTML을 트리 자료구조의 형태인 DOM Document Object Model 트리로 변환</p></li>
<li><p>리소스를 다운로드(image, css, script 등)</p></li>
</ol>
<p>2-1. CSS의 경우 다운로드 하고 CSSOM CSS Object Mode 트리로 변환</p>
<ol start="3" type="1">
<li><p>다운로드안 JS를 인터프리트, 컴파일, 파싱, 실행</p></li>
</ol></td>
</tr>
<tr class="even">
<td>렌더링</td>
<td><p>한마디로 말하면 화면에 보여주는 거.</p>
<p>파싱 이후 단계</p>
<ol type="1">
<li><p>DOM 트리와 CSSOM 트리를 합쳐 렌더 트리를 만듦.</p></li>
<li><p>레이아웃을 정함:</p></li>
</ol>
<p>브라우저 상 트리의 위치 및 크기를 정하는 것</p>
<ol start="3" type="1">
<li><p>브라우저 스크린에 렌더트리의 각 노드를 그려줌</p></li>
</ol>
<p>그러니까 리액트는 ReactDOM(Virtual DOM)을 가지고 있음.</p>
<p>어찌 됐든 상태(State)가 변하면 ReactDOM이 이를 감지하고 컴포넌트 함수를 다시 호출해서 변경된 부분의 HTML을 바꿔 줌</p></td>
</tr>
<tr class="odd">
<td>SPA Single Page Application</td>
<td><p>한번 웹 페이지를 로딩하면 유저가 임의로 새로고침하지 않는 이상 페이지를 새로 로딩하지 않는 애플리케이션</p>
<p>페이지가 바뀔 때 js 내에서 html이 재구성되므로 서버에 새 html 페이지를 요청하지 않음</p>
<p>이렇게 렌더링 하는 걸 Client-Side Rendering이라고 얘기함</p></td>
</tr>
<tr class="even">
<td>JSX</td>
<td>리액트가 한 파일에서 HTML과 JS를 함께 사용하기 위해 확장한 JS 문법</td>
</tr>
</tbody>
</table>

3.2

<table>
<colgroup>
<col style="width: 26%" />
<col style="width: 73%" />
</colgroup>
<thead>
<tr class="header">
<th>훅</th>
<th>리액트의 상태와 여러가지 기능을 사용할 수 있도록 도와주는 함수. UseState같은 거.</th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td>UseState</td>
<td><p>함수형 컴포넌트에서 상태 변수를 사용할 수 있게 해 줌</p>
<p>상태변수는 사용자가 무언가를 할 때마다 바뀜. 이를 추적해서 새 상태가 화면에 나타나도록 렌더링 해야 될 거임</p>
<p>이 오브젝트가 상태라고 알려주는 함수가 UseState 함수</p>
<p>배열을 반환: [A, B]</p>
<p>첫 번째는 오브젝트고, 두 번째는 상태를 업데이트할 수 있는 함수</p></td>
</tr>
<tr class="even">
<td>상태 변수?</td>
<td>시간이 지나거나, 컴포넌트의 사용자가 컴포넌트와 상호작용하는 동안 변경되는 변수</td>
</tr>
<tr class="odd">
<td>{}</td>
<td>JS로 된 변수를 JSX에서 쓰려면 변수를 {}로 묶어주면 됨</td>
</tr>
<tr class="even">
<td>콜백 함수</td>
<td><p>소괄호 안에 들어가는 함수</p>
<p>어떤 사건이 일어났을 때의 상태와 그 사건에 대한 정보를 담고 있음</p></td>
</tr>
<tr class="odd">
<td>map</td>
<td><p>Array 자료 개수만큼 함수안의 코드 실행해 줌</p>
<p>변수가 JSON이라면 JSON의 key값을 key={변수.key} 로 뽑아서 쓸 수 있음</p></td>
</tr>
<tr class="even">
<td>event.target.value</td>
<td>매개변수의 값이 담겨 있음</td>
</tr>
<tr class="odd">
<td>스프레드 연산자[…]로 새 배열 만든 이유</td>
<td><p>리액트는 레퍼런스를 기준으로 재렌더링함</p>
<p>근데 배열의 레퍼런스는 배열에 값을 추가하더라도 변하지 않음</p>
<p>근데 값을 바꿨으면 변해야 되니까 아예 배열을 …으로 새로 만든 거(=초기화)임</p></td>
</tr>
<tr class="even">
<td>.filter</td>
<td>조건에 맞는 경우만 필터링</td>
</tr>
</tbody>
</table>

3.3

<table>
<colgroup>
<col style="width: 17%" />
<col style="width: 26%" />
<col style="width: 55%" />
</colgroup>
<thead>
<tr class="header">
<th>CORS Cross-Origin Resource Sharing</th>
<th colspan="2">처음 리소스를 제공한 도메인(=Origin)이 현재 요청하려는 도메인과 다르더라도 요청을 허락해주는 웹 보안 방침</th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td>useEffect</td>
<td colspan="2">원래 리액트는 컴포넌트가 변하면 ReactDOM이 이를 감지해서 렌더링을 해 줌. 근데 상태를 업데이트하는 함수가 끼어 들어가면 렌더링을 또 하고, 이게 계속 반복되면 무한루프에 들어가는 거임. 이걸 useEffect로 방지할 수 있음.</td>
</tr>
<tr class="even">
<td></td>
<td>useEffect(콜백함수, 디펜던시 배열)</td>
<td><p>첫 렌더링(=마운팅)이 일어났을 때 실행되고, 배열의 오브젝트 값이 변할 때마다 콜백 함수를 부름</p>
<p>그래서 렌더링 뒤에 효과(Effect)가 발생해서 useEffect</p></td>
</tr>
<tr class="odd">
<td>fetch</td>
<td>Promise</td>
<td><p>비동기 오퍼레이션에서 사용</p>
<p>비동기 오퍼레이션?</p>
<p>원래 JS가 싱글스레드임.</p>
<p>무슨 얘기냐면 하나의 작업이 끝나야 다음 작업으로 갈 수 있다는 얘기</p>
<p>근데 그러면 웹 페이지 로딩 언제 하냐</p>
<p>그래서 JS 스레드 밖에서 오퍼레이트하니까 비동기 오퍼레이션</p>
<p>근데 JS 밖에서 실행하면 어떻게 알아봄? -&gt; 콜백 함수로 알아본다</p></td>
</tr>
<tr class="even">
<td></td>
<td>Fetch 말고 XMLHttpRequest 라는 걸 써도 됨</td>
<td>그러면 콜백 함수 안에서 HTTP 요청을 날리고 그걸 날리기 위해서 또 콜백을 또 쓰고 하면 코드가 상당히 지저분해짐. 이걸 콜백 지옥(Callback Hell)이라고 함</td>
</tr>
<tr class="odd">
<td></td>
<td>Promise</td>
<td><p>그 콜백 지옥을 피하기 위해 쓰는 방법 중 하나.</p>
<p>Pending, Fulfilled, Rejected 상태가 있음</p>
<ul>
<li><p>Pending</p></li>
</ul>
<p>오퍼레이션이 끝나기를 기다리는 상태. 오퍼레이션이 성공적으로 끝나면 resolve함수로 끝났다는 걸 알리고 then의 매개변수로 넘어오는 함수를 실행할 수 있음</p>
<ul>
<li><p>Reject / catch</p></li>
</ul>
<p>오퍼레이션 중에 문제가 생기는 경우 reject 함수를 콜하거나 catch의 매개변수로 넘어오는 함수를 실행함</p></td>
</tr>
<tr class="even">
<td></td>
<td>그래서 Fetch가 뭐냐면</td>
<td><p>JS가 제공하는 API 서버로 http 요청을 송신 및 수신할 수 있도록 도와주는 메서드</p>
<p>url 또는 url, options를 메개변수로 받을 수 있고, Promise 오브젝트를 반환함.</p>
<p>무슨 얘기냐면 then, catch에 onResolve, onReject, onError 콜백 함수를 전달해서 응답을 처리할 수 있다는 얘기임</p></td>
</tr>
<tr class="odd">
<td></td>
<td>onReject / onError</td>
<td><ul>
<li><p>onReject</p></li>
</ul>
<p>네트워크 오류처럼 외부에서 터지는 요청 실패를 처리</p>
<ul>
<li><p>onError</p></li>
</ul>
<p>요청이 정상적으로 이루어진 후 발생할 수 있는 에러(JSON 파싱 오류 등)을 처리하는데 사용</p>
<p>꼭 구분하거나 하진 않고 .catch()로 처리하는 경우도 많다는 것같다</p></td>
</tr>
</tbody>
</table>

4.1

<table>
<colgroup>
<col style="width: 13%" />
<col style="width: 20%" />
<col style="width: 65%" />
</colgroup>
<thead>
<tr class="header">
<th>인증</th>
<th colspan="2">로그인 요청 및 확인</th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td>인가</td>
<td colspan="2">로그인을 한 유저에게 할 수 있는 자원을 정의하는 것</td>
</tr>
<tr class="even">
<td>Basic 인증</td>
<td colspan="2"><p>모든 HTTP 요청에 아이디와 비밀번호를 같이 보내는 것</p>
<p>아이디와 비밀번호를 콜론으로 이어 붙인 후 Base64로 인코딩한 문자열을 함께 보냄</p>
<p>단점:</p>
<ol type="1">
<li><p>디코더만 있으면 바로 뚫림</p></li>
<li><p>MITM(Manipulator in the Middle) 공격에 취약함</p></li>
</ol>
<p>2-1. 무슨 얘기냐면 무조건 HTTPS를 써야 한다는 뜻임</p>
<ul>
<li><p>중간에 HTTP 요청을 가로채 문자열을 디코딩하는 것</p></li>
</ul>
<ol start="3" type="1">
<li><p>유저를 로그아웃 시킬 수 없음</p></li>
<li><p>인증 서버 및 인증 DB에 과부하가 걸릴 확률이 높음</p></li>
<li><p>서비스를 2개로 쪼갠다 그러자. 서비스 1에서 인증하고 서비스 2에서도 인증해야 됨</p></li>
<li><p>인증 서버가 단일 장애점이 됨</p></li>
</ol></td>
</tr>
<tr class="odd">
<td>토큰 기반 인증</td>
<td>토큰</td>
<td><p>사용자를 구별할 수 있는 문자열</p>
<p>근데 이건 서버가 만들어 줌</p>
<p>서버가 만든 토큰을 클라이언트가 넘겨서 인증된 사용자임을 알려 줌</p></td>
</tr>
<tr class="even">
<td></td>
<td>장점</td>
<td><ol type="1">
<li><p>아이디와 비밀번호를 매번 날리지 않기 때문에 Basic Auth보다 조금 더 안전함</p></li>
<li><p>서버가 만들어주는 거라서 인가 정보를 넣어주거나 유효기간을 정할 수 있음</p></li>
<li><p>디바이스마다 다른 토큰을 생성해서 유효기간을 다르게 정하거나 로그아웃할 수 있음</p></li>
</ol></td>
</tr>
<tr class="odd">
<td></td>
<td>단점</td>
<td><ol type="1">
<li><p>이것도 MITM으로 뚫릴 수 있음</p></li>
<li><p>이것도 서버에 부하를 거는 건 Basic 인증과 똑같음</p></li>
</ol></td>
</tr>
<tr class="even">
<td>JWT</td>
<td>전자서명된 토큰 중 하나</td>
<td>{header}.{payload}.{signature}로 구성</td>
</tr>
<tr class="odd">
<td></td>
<td>Header</td>
<td><ul>
<li><p>Typ</p></li>
</ul>
<p>Type. 토큰의 타입</p>
<ul>
<li><p>Alg</p></li>
</ul>
<p>Algorithm. 토큰의 서명을 발행하기 위해 사용된 해시 알고리듬</p></td>
</tr>
<tr class="even">
<td></td>
<td>Payload</td>
<td><ul>
<li><p>Sub</p></li>
</ul>
<p>Subject. 토큰의 주인. Unique identifier여야 함</p>
<ul>
<li><p>Iss</p></li>
</ul>
<p>Issuer. 토큰을 발행한 주체. Demo app, fb, naver…</p>
<ul>
<li><p>Iat</p></li>
</ul>
<p>Issued at. 토큰이 발행된 날짜와 시간</p>
<ul>
<li><p>Exp</p></li>
</ul>
<p>Expiration. 토큰이 만료되는 시간.</p></td>
</tr>
<tr class="odd">
<td></td>
<td>Signature</td>
<td>토큰을 발행한 issuer가 발행한 서명. 토큰의 유효성 검사에 사용됨</td>
</tr>
<tr class="even">
<td></td>
<td>작동 원리</td>
<td><ol type="1">
<li><p>인증한 사용자의 {header}.{payload} 작성</p></li>
<li><p>자신의 시크릿 키로 {header}.{payload}를 서명해서 {header}.{payload}.{signature}로 이어붙인 후 Base64로 인코딩한 후 반환</p></li>
<li><p>토큰으로 리소스 접근을 요구하면 일단 디코딩해서 {header}.{payload}로 전자 서명을 만든 뒤, signature를 비교</p></li>
</ol></td>
</tr>
<tr class="odd">
<td></td>
<td>장점</td>
<td>서버에 부하를 일으키지 않음</td>
</tr>
<tr class="even">
<td></td>
<td></td>
<td>토큰이 MITM 등으로 털릴 수 있는 건 Basic 인증과 똑같음</td>
</tr>
</tbody>
</table>
