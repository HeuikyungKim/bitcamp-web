# 자바 웹 프로젝트

## v0.4 : HTML 적용
#### 학습목표
- 서블릿에서 HTML을 출력할 수 있다.
- Refresh를 적용할 수 있다.
- 한글 입력 값이 POST로 전송되었을 때 문자가 깨지지 않도록 처리할 수 있다.
- 출력할 때 MIME 타입과 출력 문자 집합을 설정할 수 있다.
- 서블릿에서 발생된 오류 정보를 웹브라우저로 출력할 수 있다.
 
#### 서블릿 클래스 변경
- 출력 콘텐츠를 plain에서 html로 변경한다.
- ContactListServlet.java (변경)
- webapp/student/form.html (생성)
- ContactAddServlet.java (변경)
- ContactViewServlet.java (변경)
- ContactUpdateServlet.java (변경)
- ContactDeleteServlet.java (변경)


## v0.3 : HttpServlet 클래스 적용
#### 학습목표
- HttpServlet을 이용하여 서블릿을 만들 수 있다.
- doGet()과 doPost()의 메서드 호출 과정을 이해한다.
- 언제 service()를 재정의해야하고 doGet(), doPost()를 재정의해야 하는 지 안다.

#### 서블릿 클래스 변경
- AbstractServlet 클래스 제거
- AbstractServlet 대신 HttpServlet 상속 받는다.
- service() 메서드를 오버라이딩하기 보다는 doGet(), doPost()를 오버라이딩 한다.

## v0.2 : 웹 프로젝트 준비
#### 학습목표
- 테스트용 톰캣 작업 폴더를 생성할 수 있다.
- 톰캣 테스트 폴더에 웹 프로젝트를 배치할 수 있다.
- 톰캣 서버를 실행하여 배치한 웹애플리케이션을 테스트 할 수 있다.

#### 의존 라이브러리 준비
- libs 폴더 생성
- libs/mysql***.jar       : MySQL JDBC 드라이버 파일 추가
- libs/servlet***.jar     : 웹 애플리케이션을 만들 때 사용하는 클래스들.

#### Gradle 설정 파일에 의존 라이브러리 정보 추가
- 로컬 의존 라이브러리 추가 : libs 폴더에 있는 .jar 파일 추가 
- gradle eclipse 명령을 다시 실행한다 : 이클립스 설정 파일을 갱신한다.
- 이클립스에서 프로젝트를 "refresh" 한다.

#### 자바 패키지 구조
src/main/java/bitcamp/java89/ems/controller
                                /dao
                                /vo
                                /servlet
                                
#### 웹 프로젝트 소스 준비
기존 프로젝트 소스 파일을 복사해 온다.
~~~~
util
  DataSource.java
vo
  Contact.java
  Student.java  
dao
  ContactDao.java
  StudentDao.java
  impl 패키지 
    ContactMysqlDao.java
    StudentMysqlDao.java
controller
  ContactController.java
  StudentController.java     
~~~~

#### 기존 클래스 변경
- DataSource 클래스에 Singleton 패턴 적용
- DAO 클래스에 Singleton 패턴 적용
 
#### 서블릿 클래스 생성
컨트롤러 클래스를 Servlet 스펙에 맞춰 각 메서드를 분리하여 클래스로 정의한다.
즉 다시 커맨드 패턴(Command Pattern)을 적용하여 클래스를 만든다.
- servlet 패키지 생성
  - 이 패키지에 서블릿 클래스를 둔다.
- ContactController.java 클래스 분해
  - ContactListServlet.java
  - ContactViewServlet.java
  - ContactAddServlet.java
  - ContactUpdateServlet.java
  - ContactDeleteServlet.java
- StudentController.java 클래스 분해
  - StudentListServlet.java
  - StudentViewServlet.java
  - StudentAddServlet.java
  - StudentUpdateServlet.java
  - StudentDeleteServlet.java

#### 톰캣 서버에 웹 애플리케이션을 배치
톰캣 서버에 실행에 필요한 클래스들을 배치한다.
- 톰캣홈/webapps/web/WEB-INF/classes/  폴더를 생성한 후 클래스 파일을 배치한다.
- 톰캣홈/webapps/web/WEB-INF/lib/ 폴더에 의존 라이브러리 파일(*.jar)을 둔다.

#### 서블릿 실행 테스트
웹 브라우저 주소 창에 다음과 같이 명령어를 입력하여 서블릿을 실행시킨다.
~~~~
http://서버주소:8080/web/명령어?변수=값&변수=값...
예)
http://localhost:8080/web/contact/list
http://localhost:8080/web/student/add?userId=xxx&password=1111&name=홍길동&tel=1111-1111&email=hong7@test.com&working=true&birthYear=1999&school=비트대학
~~~~

## v0.1 : 프로젝트 만들기
#### 학습목표
- Gradle을 이용하여 웹프로젝트 폴더를 생성할 수 있다.
- 만든 웹 프로젝트를 이클립스로 임포트할 수 있다.

#### 프로젝트 폴더 구조
bitcamp-web/src/main/java       : 자바 소스 파일
                    /resources  : 실행할 때 참고할 설정 파일(.properties, .xml, .txt 등)
                    /webapp     : HTML, CSS, JavaScript, 그림 파일 등 웹 관련 파일
               /test/java       : 단위 테스트를 할 때 사용할 자바 소스 파일
                    /resources  : 단위 테스트를 실행할 때 참고할 설정 파일
#### Gradle 빌드 설정 파일
bitcamp-web/build.gradle        : Gradle 빌드 도구의 설정 파일

#### 이클립스 설정 파일 생성
>gradle eclipse     : Gradle 명령 실행

#### 이클립스 워크스페이스로 프로젝트 로딩
File 메뉴 --> import... --> General 노드 / Existing Projects into Workspace 선택
[다음] 클릭 --> bitcamp-web 프로젝트 폴더 선택 --> [Finish] 클릭