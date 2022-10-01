package digital.quintino.financeiroapi.utility;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtility {
	
	private static final String FORMAT_DDMMYYYYHHMMSS = "dd/MM/YYYY HH:mm:ss";
	
	public static String formatarData(Date date) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(FORMAT_DDMMYYYYHHMMSS);
		return simpleDateFormat.format(new Date());
	}

}
