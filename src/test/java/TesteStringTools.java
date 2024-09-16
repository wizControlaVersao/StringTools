
import com.wizsyst.apps.stringtools.StringTools;
import java.util.List;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.Assertions ;
import org.junit.jupiter.api.BeforeAll;


/**
 * Wiz Systems do Brasil <www.wizsyst.com>
 *
 * @author Jean Manenti <jmanenti@wizsyst.com>
 * @version
 * @since
 * 
 */
public class TesteStringTools {
    
    private static StringTools strTools ;
    
    @BeforeAll
    public static void init(){
        strTools = new StringTools();
    }
    
    @Test
    public void testaStringVazia( ) {        
        // Deve retornar true, String vazia
        Assertions.assertTrue( strTools.ehVazia(""));
        // Deve retornar true, String nula
        Assertions.assertTrue( strTools.ehVazia(null ));
    }
    
    @Test
    public void testaStringNaoVazia( ) {                
        // Deve retornar false, String preenchida
        Assertions.assertFalse( strTools.ehVazia("X"));
        // Deve retornar false, String não é nula
        Assertions.assertFalse( strTools.ehVazia(" XYZ    "));        
    }
    
    @Test
    public void testaStringEstivarDentroDaLista() {
        List<String> lista = List.of( "A" , "B" , "C" , "D")  ;
        // Deve retornar true, pois 'A' está dentro da lista
        Assertions.assertTrue(  strTools.contemValor("A", lista));
        // Deve retornar false, pois 'Z' não está dentro da lista
        Assertions.assertFalse(  strTools.contemValor("Z", lista));
        // Deve retornar false, pois 'a' não está dentro da lista
        Assertions.assertFalse(  strTools.contemValor("a", lista));
    }
    
    
    @Test
    public void testaStringNaoEstivarDentroDaLista() {
        List<String> lista = List.of( "A" , "B" , "C" , "D")  ;
        // Deve retornar true, pois 'X' não está dentro da lista
        Assertions.assertTrue(  strTools.naoContemValor("X", lista));
        // Deve retornar false, pois 'A' está dentro da lista
        Assertions.assertFalse(  strTools.naoContemValor("A", lista));
        // Deve retornar true, pois 'c' não está dentro da lista
        Assertions.assertTrue(  strTools.naoContemValor("c", lista));
    }
    
    
    @Test
    public void testaRetornandoDigitos() {
        
        String str = "X1Y2Z3" ;  
        // Retorna apenas os digitos 123
        Assertions.assertTrue( strTools.extraiDigitos( str).equals("123") );
        
        // Retorna uma String vazia
        Assertions.assertFalse( strTools.extraiDigitos( str).equals("XYZ") );
        
        str = "XYZ" ;        
        Assertions.assertTrue( strTools.ehVazia( strTools.extraiDigitos( str) ) );
    }
    
    @Test
    public void testaStringApenasCaracteres() {
        String str = "alpha" ;
        
        // Retorna true, contem apenas caracteres
        Assertions.assertTrue( strTools.extraiLetras(str));
        
        
        str = "alpha123" ;
        // Retorna falso, contem digitos
        Assertions.assertFalse( strTools.extraiLetras(str));
    }
    
    @Test
    public void testaStringNaoVaziaEIgual( ) {
        String str = "String" ;
        
        Assertions.assertTrue( strTools.naoVazioEIgual( str, "String"));        
        Assertions.assertFalse( strTools.naoVazioEIgual( str, "String1"));        
        Assertions.assertFalse( strTools.naoVazioEIgual( str, ""));        
        Assertions.assertTrue( strTools.naoVazioEIgual( str, "String" , false ));        
        Assertions.assertTrue( strTools.naoVazioEIgual( str, "String" , true ));        
        Assertions.assertFalse( strTools.naoVazioEIgual( str, "ctr" , false ));
    }
    
    
    @Test
    public void testaStringParaArray( ) {
        String str = "teste" ;
        
        List<String> arr = List.of("t" , "e" , "s", "t", "e");        
        Assertions.assertEquals( strTools.stringParaArray(str) , arr );
        
        arr = List.of("t" , "e" , "s", "t");
        Assertions.assertNotEquals( strTools.stringParaArray(str) , arr );
    }
    
    
    @Test
    public void testaListaCaracteresValidos() {
        
        String str = "teste" ;
        List<String> caracteresValidos = List.of( "t" , "e" , "s")  ;
        Assertions.assertTrue( strTools.contemApenasCaracteresValidos(str, caracteresValidos));
        
        caracteresValidos = List.of( "t" , "e" )  ;
        Assertions.assertFalse( strTools.contemApenasCaracteresValidos(str, caracteresValidos));
    }    
    
    @Test
    public void testaXMLTag( ){        
        Assertions.assertTrue( strTools.paraXMLTag("jean", "nome").equals("<nome>jean</nome>") );
        Assertions.assertFalse( strTools.paraXMLTag(null , "nome").equals("<nome>jean</nome>") );
    }
    
    @Test
    public void testaDivisaoPorTamanho( ) {
        String nome = "jeanmanenti" ;
        
        List<String> padrao = List.of( "jean" , "manenti") ;               
        Assertions.assertEquals(strTools.dividePorTamanho(nome, 4 , 7) , padrao  );
        
        Assertions.assertNotEquals(strTools.dividePorTamanho(nome, 4 , 4) , padrao  );
    }

    @Test
    public void testaConversaoBoolean() {        
        Assertions.assertTrue( strTools.converteParaBoolean("S"));
        Assertions.assertTrue( strTools.converteParaBoolean("Y"));
        Assertions.assertTrue( strTools.converteParaBoolean("s"));
        Assertions.assertTrue( strTools.converteParaBoolean("y"));        
        Assertions.assertFalse( strTools.converteParaBoolean("X"));
    }
    
    @Test
    public void testaPreenchimentoEsquerda() {
        
        Assertions.assertTrue(  strTools.preencheEsquerda( "jean", "7", 10).length() == 10 );
        Assertions.assertTrue(  strTools.preencheEsquerda( "jean", "7", 10).equals("777777jean") );
        
        Assertions.assertFalse(  strTools.preencheEsquerda( "jean", "7", 10).length() == 11 );
        Assertions.assertFalse(  strTools.preencheEsquerda( "jean", "7", 10).equals("877777jean") );
    }
    
    
    @Test
    public void testaPreenchimentoDireita() {
        
        Assertions.assertTrue(  strTools.preencheDireita( "jean", "7", 10).length() == 10 );
        Assertions.assertTrue(  strTools.preencheDireita( "jean", "7", 10).equals("jean777777") );
        
        Assertions.assertFalse(  strTools.preencheDireita( "jean", "7", 10).length() == 11 );
        Assertions.assertFalse(  strTools.preencheDireita( "jean", "7", 10).equals("jean877777") );
    }
    
    @Test
    public void testaNVL() {
        Assertions.assertTrue( strTools.nvl( null , "jean").equals("jean"));
        Assertions.assertFalse( strTools.nvl( "jean" , "manenti").equals("manenti"));
    }
    
    @Test
    public void testaInversaoDeUmaString( )  {        
        Assertions.assertTrue( strTools.inverte( "jean").equals("naej"));
        Assertions.assertTrue( strTools.inverte( "roma é amor").equals("roma é amor"));        
    }
    
    @Test
    public void testaRemocaoEspacos() {
        Assertions.assertTrue( strTools.removeEspacos("j e a n ").equals("jean") );
        Assertions.assertFalse( strTools.removeEspacos("j e a n ").equals("jea n") );
    }
    
    @Test
    public void testaPrimeraLetraEmMaiusculo() {        
        Assertions.assertTrue( strTools.primeiraLetraMaiuscula("roma é amor").equals("Roma É Amor")) ;
    }
    
    @Test
    public void testaIdentificadorJavaValido(){
        Assertions.assertFalse( strTools.ehUmIdentificadorJavaValido("1nome"));
        Assertions.assertTrue( strTools.ehUmIdentificadorJavaValido("nome1"));
        Assertions.assertFalse( strTools.ehUmIdentificadorJavaValido(null));
    }
    
    @Test
    public void testaNomeDeClasseValido(){
        Assertions.assertTrue( strTools.ehUmNomeDeClasseValido( "ContaPessoas"));
        Assertions.assertFalse( strTools.ehUmNomeDeClasseValido( "Conta.Pessoas"));
    }

    @Test
    public void testaConcatenacao(){
        List<String> lista = List.of( "roma" , "é" , "amor")  ;        
        Assertions.assertTrue( strTools.concatena(lista).equals("romaéamor") );        
        Assertions.assertTrue( strTools.concatena(lista , " " ).equals("roma é amor") );
    }
    
    @Test
    public void testaRemocaoCaracteres() {
        
        String[] um = { "e" };
        String[] outro = { "é" };
                
        Assertions.assertTrue( strTools.removeCaracteres( "roma e amor", um  , outro ).equals("roma é amor")) ;
    }
    
    @Test
    public void testaRemocaoAcentos(){
        String str = "çíáéóúã";        
        Assertions.assertTrue( strTools.removeAcentos( str , false).equals("ciaeoua")) ;
    }
    
    
    @Test
    public void testaListaNaoVazio() {
        Assertions.assertTrue( strTools.temTodosOsValores( List.of("a" , " b" , "c")));
        Assertions.assertFalse( strTools.temTodosOsValores( List.of("a" , " b" , "")));        
    }
    
    @Test 
    public void tastaListaTemAlgumValor() {
        Assertions.assertTrue( strTools.temAlgumValor( List.of("a" , " b" , "c")));
        Assertions.assertTrue( strTools.temAlgumValor( List.of("a" , " b" , "")));        
        Assertions.assertFalse( strTools.temAlgumValor( List.of("" , " " , "")));                
    }
    
    
    @Test 
    public void tastaListaNaoTemAlgumValor() {
        Assertions.assertFalse( strTools.naoTemValor( List.of("a" , " b" , "c")));
        Assertions.assertFalse( strTools.naoTemValor( List.of("a" , " b" , "")));        
        Assertions.assertTrue( strTools.naoTemValor( List.of("" , " " , "")));                
    }
    
    
    @Test
    public void testaTamnho() {
        Assertions.assertTrue( strTools.verificaTamanho( "jean", 1, 4, false) );
        Assertions.assertTrue( strTools.verificaTamanho( "manenti ", 1, 7, true) );
        Assertions.assertFalse( strTools.verificaTamanho( "manenti ", 1, 7, false) );
        
    }
}