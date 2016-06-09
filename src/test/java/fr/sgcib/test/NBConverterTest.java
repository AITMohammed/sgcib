package fr.sgcib.test;

import static org.junit.Assert.*;
import java.util.Map;
import org.junit.Test;

/**
 * Classe testant les deux conversion implémentées : Json/xml
 * 
 * @author Mohand
 *
 */
public class NBConverterTest {

	/**
	 * Test conversion resultat conversion des nombres
	 */
	@Test
	public void buildTest(){
		Map<Integer, StringBuffer> strNumberMap = NBConverter.diviseurs ();
		assertEquals(strNumberMap.get(3).toString(), NBConverter.C_FOO);
		NBConverter.contient (strNumberMap);
		assertEquals(strNumberMap.get(3).toString(), NBConverter.C_FOO+NBConverter.C_FOO);
		assertEquals(strNumberMap.get(15).toString(), NBConverter.C_FOO+NBConverter.C_BAR+NBConverter.C_BAR);
		assertEquals(strNumberMap.get(21).toString(), NBConverter.C_FOO+NBConverter.C_QIX);
		assertEquals(strNumberMap.get(33).toString(), NBConverter.C_FOO+NBConverter.C_FOO+NBConverter.C_FOO);
		assertEquals(strNumberMap.get(51).toString(), NBConverter.C_FOO+NBConverter.C_BAR);
	}
}
