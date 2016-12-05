# 자바 웹 프로젝트
## v0.2 : 웹 프로젝트 준비
#### 의존 라이브러리 준비
- libs 폴더 생성
- libs/mysql***.jar : MySQL JDBC 드라이버 파일 추가

#### Gradle 설정 파일에 의존 라이브러리 정보 추가
- 로컬 의존 라이브러리 추가 : libs 폴더에 있는 .jar 파일 추가 
- gradle eclipse 명령을 다시 실행한다 : 이클립스 설정 파일을 갱신한다.
- 이클립스에서 프로젝트를 "refresh" 한다.

#### 자바 패키지 구조
src/main/java/bitcamp/java89/ems/controller
                                /dao
                                /vo
                                
#### 기존 프로젝트 소스 파일을 복사해 온다.
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

## v0.1 : 프로젝트 만들기
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