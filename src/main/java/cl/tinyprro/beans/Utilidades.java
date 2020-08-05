package cl.tinyprro.beans;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utilidades {

	/**
	 * Conversor de fechas para que funcione
	 * @param fecha
	 * @return
	 */
	public static Date AjustaFecha (String fecha) {
		System.out.println(fecha);
		String f[] = fecha.split("/");
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date fechaE = new Date();
		try {
			fechaE = simpleDateFormat.parse(f[0]+"/"+f[1]+"/"+f[2]);
			System.out.println(fechaE.toString());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return fechaE;
	}
}
