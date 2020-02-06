package ej1;
import java.io.IOException;
import java.security.*;

import utiles.Libreria;
public class Ejemplo4 {
	public static void main(String[] args) throws IOException {
		MessageDigest md;
        Libreria a1 = new Libreria();
        try {
            md = MessageDigest.getInstance("SHA-256");
            String clave = a1.excepcionstringcontexto("Introduza el clave");
            String texto2 = a1.excepcionstringcontexto("Introduza el texto2");
            String texto3 = a1.excepcionstringcontexto("Introduza el texto3");
            byte claveBytes[] = clave.getBytes();
            byte texto2Bytes[] = texto2.getBytes();
            byte texto3Bytes[] = texto3.getBytes();
            md.update(claveBytes);
            byte resumenClave[] = md.digest();
            md.update(texto2Bytes);
            byte resumenTexto2[] = md.digest(claveBytes);
            md.update(texto3Bytes);
            byte resumenTexto3[] = md.digest(claveBytes);
            System.out.println("Mensaje original Texto2: " + texto2);
            System.out.println("Mensaje original Texto2: " + texto3);
            System.out.println("Mensaje resumen Texto2: " + new String(resumenTexto2));
            System.out.println("Mensaje resumen Texto2: " + new String(resumenTexto3));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
	}
}