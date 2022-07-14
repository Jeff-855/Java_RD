package ejb;

import javax.ejb.Remote;

@Remote
public interface SessionBeanRemote {

  String getResult();

  String getAddress();

  String getCompanyname();
}