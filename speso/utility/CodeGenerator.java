package appnivi.products.speso.utility;

import java.util.UUID;

import org.springframework.stereotype.Component;

@Component
public class CodeGenerator {
	public String genrateCode(String request) {
		return UUID.randomUUID().toString();
	}
}
