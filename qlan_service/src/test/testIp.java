import java.net.UnknownHostException;

import com.viettel.qlan.utils.DataUtils;

public class testIp {

	public static void main(String[] args) throws UnknownHostException {
		// TODO Auto-generated method stub
		String a = "10.20.30.[10,30,50]|24";
		String b[] = a.split("\\|");
//		System.out.println("Host Name:- " + DataUtils.matchIp("10.20.30.40", a));
		System.out.println("Host Name:- " + b.length);
	}
}
