package appnivi.products.speso.utility;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

@Component
public class DateUtils {
	public LocalDateTime getCurrentDate() {
		return LocalDateTime.now();
	}
}
