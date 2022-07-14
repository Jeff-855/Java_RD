package ejb;

import javax.ejb.Stateless;

@Stateless
public class SessionBeanBean implements SessionBeanRemote {

  public String getResult() {
  return "Hello World";
  }
  public String getAddress() {
  return "Sec-3,D-16/116,Rohini";
  }
  public String getCompanyname() {
  return "Roseindia.net Pvt.Ltd.";
  }
}
