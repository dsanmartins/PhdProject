package br.ufscar.sas.cripto;

import java.util.Base64;

public class CriptoBase64 {

	public String decodeBase64Path(String path) {

		byte[] decodedBytes = Base64.getDecoder().decode(path);
		return new String(decodedBytes);
	}
	
	public String codeBase64Path(String path)
	{

		byte[] encodedBytes = Base64.getEncoder().encode(path.getBytes());
        String encodedVersion = new String(encodedBytes);
        return encodedVersion;
	}
}
