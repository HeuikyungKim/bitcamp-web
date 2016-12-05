package bitcamp.java89.ems.vo;

import java.io.Serializable;

public class Contact implements Serializable{
  private static final long serialVersionUID = 1L;
  //버전을 알려주어야함 . 버전을 알려주는 방법: 시리얼버전 만들어줌
  protected String name;
  protected String position;
  protected String tel;
  protected String email;
  public Contact() { // 기본생성자 오른쪽 source - generate constructor field
    //super();
  }
  
  public Contact(String name, String position, String tel, String email) { //오른쪽 필드 오밋체크해제
    this.name = name;
    this.position = position;
    this.tel = tel;
    this.email = email;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public String getPosition() {
    return position;
  }
  public void setPosition(String position) {
    this.position = position;
  }
  public String getTel() {
    return tel;
  }
  public void setTel(String tel) {
    this.tel = tel;
  }
  public String getEmail() {
    return email;
  }
  public void setEmail(String email) {
    this.email = email;
  }

  @Override
  public String toString() {
    return "Contact [name=" + name + ", position=" + position + ", tel=" + tel + ", email=" + email + "]";
  }


  
}
