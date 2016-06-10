package fr.sgcib.test;

import java.util.HashMap;
import java.util.Map;


/**
 * Conversion nombre 1 à 100 en string suivants les regles SGCIB
 * @author Mohand
 * @date 09/06/2016
 */
public class NBConverter {
	/** Constantes du programme */
	final static String C_FOO ="Foo";
	final static String C_BAR ="Bar";
	final static String C_QIX ="Qix";
	
	
	
	public static void main(String[] args) {
		
		//Traitement des diviseurs
		Map<Integer, StringBuffer> strNumberMap = diviseurs ();
		
		//Traitement des contenus
		contient (strNumberMap);

		//Affichage du résultat
        for (int i = 1; i <= 100; i++) {
            System.out.println("".equals(strNumberMap.get(i).toString()) ? i : strNumberMap.get(i).toString());
        }
	}
	
	/**
	 * Etape des diviseurs
	 * @return map des nombres 1..100 dont les valeurs sont transformees suivant les regles suivantes :</br>
	 *  <li>Si le nombre est divisible par 3 écrire “Foo” à la place de 3.</li>
	 *  <li>Si le nombre est divisible par 5 ou contient 5, écrire “Bar” à la place de 5.</li>
	 *  <li>Si le nombre est divisible par 7 ou contient 7, écrire “Qix” à la place de 7. </li>
	 *  <li>On regarde les multiples dans l'ordre.</li>
	 */
	public static Map<Integer, StringBuffer> diviseurs (){
		
		StringBuffer modifiedNb = null;
        Map<Integer, StringBuffer> strNumberMap = new HashMap<Integer, StringBuffer>();
       
		//Traitement des diviseurs
        for (int i = 1; i <= 100; i++) {
        	modifiedNb = new StringBuffer("");
            if (i % 3 == 0) {
            	modifiedNb.append(C_FOO);
            }
            if (i % 5 == 0) {
            	modifiedNb.append(C_BAR);
            }
            if (i % 7 == 0) {
            	modifiedNb.append(C_QIX);
            }
            strNumberMap.put(i, modifiedNb);
        }
        
        return strNumberMap;
	}

	/**
	 * Etape du contenu
	 * @param strNumberMap map content des chiffres 1 à 100 transformés par la methode diviseurs
	 * @return map des nombres 1..100 dont les valeurs sont transformees suivant les regles suivantes :<br>
	 *  <li>Si le nombre contient 3, écrire “Foo” à la place de 3.</li>
	 *  <li>Si le nombre contient 5, écrire “Bar” à la place de 5.</li>
	 *  <li>Si le nombre contient 7, écrire “Qix” à la place de 7. </li>
	 *  <li>On regarde le contenu dans l'ordre où il apparait.</li>
	 */
	public static void contient (Map<Integer, StringBuffer> strNumberMap){
		//Traitement contenu sur les dizaines
        for (int i = 30; i <= 39; i++) {
        	strNumberMap.put(i, strNumberMap.get(i).append(C_FOO));
        	strNumberMap.put(i + 20, strNumberMap.get(i + 20).append(C_BAR));
            strNumberMap.put(1 + 40, strNumberMap.get(i + 40).append(C_QIX));
        }

        //Traitement contenu sur les unités
        for (int i = 0; i <= 9; i++) {
        	strNumberMap.put(3 + i * 10, strNumberMap.get(3 + i * 10).append(C_FOO));
        	strNumberMap.put(5 + i * 10, strNumberMap.get(5 + i * 10).append(C_BAR));
        	strNumberMap.put(7 + i * 10, strNumberMap.get(7 + i * 10).append(C_QIX));
        }
	}
}
