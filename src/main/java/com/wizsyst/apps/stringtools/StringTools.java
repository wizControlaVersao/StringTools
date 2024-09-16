package com.wizsyst.apps.stringtools;

import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.lang.model.SourceVersion;

/**
 * Classe utilitaria para tratamento/validação de Strings
 *
 * @author Jean Manenti <jeannm@gmail.com>
 *
 */
public class StringTools {

    /**
     * Verifica se uma Sring é vazia Se for nula, ou a quantidade de espaços
     * depois do trim for zero, retorna true, caso contrário false
     *
     * @param str String a ser testada
     *
     * @return <code>true</code> ser for vazia <code>false</code> se contiver
     * informações;
     */
    public boolean ehVazia(String str) {
        return ( str == null || str.trim().length() == 0) ;
    }

    /**
     * Verifica se uma Sring não é vazia Se for nula, ou a quantidade de espaços
     * depois do trim for zero, retorna false, caso contrário true
     *
     * @param str String a ser testada
     *
     * @return <code>false</code> ser for vazia <code>true</code> se contiver
     * informações;
     */
    public boolean naoEhVazia(String str) {
        return !(str == null || str.trim().length() == 0);        
    }

    /**
     * Verifica se uma string está contida dentro de uma lista
     *
     * @param str String a ser comparada
     * @param strs Lista de Strings a serem comparadas
     *
     * @return <code>True</code> caso a String exista dentro da lista
     * <code>False</code> caso a String não exista dentro da lista
     */
    public boolean contemValor(String str, List<String> strs) {
        return strs.stream().anyMatch(str::equals);
    }

    /**
     * Verifica se uma string não está contida dentro de uma lista
     *
     * @param str String a ser comparada
     * @param strs Lista de Strings a serem comparadas
     *
     * @return <code>True</code> caso a String não exista dentro da lista
     * <code>False</code> caso a String exista dentro da lista
     */
    public boolean naoContemValor(String str, List<String> strs) {
        return !this.contemValor(str, strs);
    }

    /**
     * Verifica se uma string está contida dentro de uma lista, compara
     * ignorando se for caixa alta ou baixa se indicado
     *
     * @param str String a ser comparada
     * @param strs Lista de Strings a serem comparadas
     * @param ignoreCase Indica se deve ignorar caixa alta ou baixa
     *
     * @return <code>True</code> caso a String exista dentro da lista
     * <code>False</code> caso a String não exista dentro da lista
     */
    public boolean contemValor(String str, List<String> strs, boolean ignoreCase) {
        if (ignoreCase) {
            return strs.stream().anyMatch(str::equalsIgnoreCase);
        } else {
            return strs.stream().anyMatch(str::equals);
        }
    }

    /**
     * Verifica se uma string não está contida dentro de uma lista, compara
     * ignorando se for caixa alta ou baixa se indicado
     *
     * @param str String a ser comparada
     * @param strs Lista de Strings a serem comparadas
     * @param ignoreCase Indica se deve ignorar caixa alta ou baixa
     *
     * @return <code>True</code> caso a String não exista dentro da lista
     * <code>False</code> caso a String exista dentro da lista
     */
    public boolean naoContemValor(String str, List<String> strs, boolean ignoreCase) {
        if (ignoreCase) {
            return !this.contemValor(str, strs, ignoreCase);
        } else {
            return !this.contemValor(str, strs);
        }
    }

    /**
     * Retorna apenas os digitos ( nuúmeros ) na String, se não contiver
     * digitos, retorna uma <code>String</code> vazia
     *
     * @param str
     * @return Retorna os dígitos dentro de uma <code>String</code>
     */
    public String extraiDigitos(String str) {
        // Se for vazia, retorna a propria String
        if (ehVazia(str)) {
            return str;
        }
        return str.replaceAll("\\D+", "");
    }

    /**
     * Verifica se uma <code>String</code> contem apenas letras
     *
     * @param str
     * @return Retorna <code>true</code> se contiver apenas letras,
     * <code>false</code> caso contratio
     */
    public boolean extraiLetras(String str) {
        return str.matches("[a-zA-Z]+");
    }

    /**
     * Verifica se uma <code>String</code> mão é vazia e igual ao valor passado
     *
     * @param str
     * @param comparador
     * @return
     */
    public boolean naoVazioEIgual(String str, String comparador) {
        if (ehVazia(str)) {
            return false;
        }

        if (ehVazia(comparador)) {
            return false;
        }

        return str.equals(comparador);
    }

    /**
     *
     * @param str <code>String</code> que deverá ser comparada
     * @param comparador String que servirá para comparação
     * @param ignoreCase Indica se deve ignorar a comparação de caixa alta/aixa
     * @return <code>true</code> se forem iguais <code>false</code> se não forem
     * iguais
     */
    public boolean naoVazioEIgual(String str, String comparador, boolean ignoreCase) {

        if (ehVazia(str)) {
            return false;
        }

        if (ehVazia(comparador)) {
            return false;
        }

        if (ignoreCase) {
            return str.equalsIgnoreCase(comparador);
        } else {
            return str.equals(comparador);
        }
    }

    /**
     * Transforma uma String em uma Lista de Strings, cada posição da lista se
     * refere a um caractere da String
     *
     * @param str
     * @return <code>List</code>
     */
    public List<String> stringParaArray(String str) {
        List<String> array = new ArrayList<>();

        for (char c : str.toCharArray()) {
            array.add(String.valueOf(c));
        }
        return array;
    }

    /**
     * Verifica se a String contém apenas caracteres validos
     *
     * @param str <code>String</code> que será validada
     * @param caracteres Lista de caracteres válidos
     * @return <code>true</code> se todos os caracteres na String forem validos
     * <code>false</code> caso contrário
     */
    public boolean contemApenasCaracteresValidos(String str, List<String> caracteres) {

        if (ehVazia(str)) {
            return false;
        }

        if (caracteres == null || caracteres.isEmpty()) {
            return false;
        }

        String temp = str;

        for (String c : caracteres) {
            temp = temp.replace(c, "");
        }

        return ehVazia(temp);
    }

    /**
     * Transforma o valor em uma tag XML, retorna vazio se o valor for nulo
     *
     * @param valor
     * @param tag
     * @return
     */
    public String paraXMLTag(String valor, String tag) {
        if (naoEhVazia(valor)) {
            return "<" + tag + ">" + valor.trim() + "</" + tag + ">";
        }
        return "";
    }

    /**
     * Divide a String por tamanho
     *
     * @param str
     * @param tamanhos
     * @return
     */
    public List<String> dividePorTamanho(String str, int... tamanhos) {

        List<String> valores = new ArrayList<>();

        int posicaoAtual = 0;

        for (int tam : tamanhos) {
            valores.add(str.substring(posicaoAtual, posicaoAtual + tam));
            posicaoAtual += tam;
        }
        return valores;
    }

    /**
     * Caso o valor passado seja S,s,Y,y retorna <code>true</code>
     * <code>false</code> caso contrário
     *
     * @param valor
     * @return
     */
    public boolean converteParaBoolean(String valor) {
        if (ehVazia(valor)) {
            return false;
        }

        return contemValor(valor, List.of("S", "s", "Y", "y"));
    }

    /**
     * Remove caracteres de nova linha, ta e retorno
     *
     * @param str
     * @return
     */
    public String removeNovaLinha(String str) {
        if (naoEhVazia(str)) {
            return str.replaceAll("[\\t\\n\\r]+", " ");
        }
        return str;
    }

    /**
     * Preenche uma String com itens a esquerda. Preenche a String com o valor
     * de preenchimento, até atingir o tamanho desejado.
     *
     * @param str
     * @param strPreenchimento
     * @param tamanho
     * @return
     */
    public String preencheEsquerda(String str, String strPreenchimento, int tamanho) {
        if (ehVazia(str)) {
            return str;
        }

        if (ehVazia(strPreenchimento)) {
            return str;
        }

        if (str.length() >= tamanho) {
            return str;
        }

        String tmp = str;

        while (tmp.length() < tamanho) {
            tmp = strPreenchimento + tmp;
        }

        return tmp;
    }

    /**
     * Preenche uma String com itens a direita. Preenche a String com o valor de
     * preenchimento, até atingir o tamanho desejado.
     *
     * @param str
     * @param strPreenchimento
     * @param tamanho
     * @return
     */
    public String preencheDireita(String str, String strPreenchimento, int tamanho) {
        if (ehVazia(str)) {
            return str;
        }

        if (ehVazia(strPreenchimento)) {
            return str;
        }

        if (str.length() >= tamanho) {
            return str;
        }

        String tmp = str;

        while (tmp.length() < tamanho) {
            tmp = tmp + strPreenchimento;
        }

        return tmp;
    }

    /**
     * Se o valor passado como parâmetro for nulo, sustitui pelo segundo valor
     *
     * @param str
     * @param replace
     * @return
     */
    public String nvl(String str, String replace) {
        if (ehVazia(str)) {
            return replace;
        }

        return str;
    }

    /**
     * Retorna um UUID
     *
     * @return
     */
    public String getRandomId() {
        return UUID.randomUUID().toString();
    }

    /**
     * Inverte uma String
     *
     * @param str
     * @return
     */
    public String inverte(String str) {
        char[] orig = str.toCharArray();

        String rev = "";

        int size = orig.length - 1;

        while (size > -1) {
            rev += orig[size];
            size--;
        }

        return rev;
    }

    /**
     * Remove todos os espaççoes em uma String
     *
     * @param str
     * @return
     */
    public String removeEspacos(String str) {

        if (naoEhVazia(str)) {
            return str.replaceAll("\\s+", "");
        }

        return str;
    }

    /**
     * Converte a primeira letra de cada palavra para maiusculo
     *
     * @param frase
     * @return
     */
    public String primeiraLetraMaiuscula(String frase) {
        if (ehVazia(frase)) {
            return frase;
        }

        if (frase.contains(" ")) {
            String[] palavras = frase.split(" ");
            frase = "";

            for (int i = 0; i < palavras.length; i++) {
                if (palavras[i].length() == 1) {
                    palavras[i] = palavras[i].toUpperCase();
                } else {
                    StringBuilder stb = new StringBuilder(palavras[i]);
                    stb.setCharAt(0, Character.toUpperCase(stb.charAt(0)));

                    palavras[i] = stb.toString();
                }

                frase += palavras[i] + " ";
            }
        } else {
            if (frase.length() <= 1) {
                return frase.toUpperCase();
            } else {
                StringBuilder stb = new StringBuilder(frase);
                stb.setCharAt(0, Character.toUpperCase(stb.charAt(0)));

                frase = stb.toString();
            }
        }

        return frase.trim();
    }

    /**
     * Verifica se a str é valida como nome de método ou variavel para o Java
     *
     * @param str
     * @return
     */
    public boolean ehUmIdentificadorJavaValido(String str) {
        if (ehVazia(str)) {
            return false;
        }
        if (!Character.isJavaIdentifierStart(str.charAt(0))) {
            return false;
        }
        for (int i = 1; i < str.length(); i++) {
            if (!Character.isJavaIdentifierPart(str.charAt(i))) {
                return false;
            }
        }

        return true;
    }

    /**
     * Verifica se a String é um nome de classe valido para o Java
     *
     * @param nmClass
     * @return
     */
    public boolean ehUmNomeDeClasseValido(String nmClass) {
        return SourceVersion.isIdentifier(nmClass) && !SourceVersion.isKeyword(nmClass);
    }

    /**
     * Concatena uma lista de Strings
     *
     * @param lista
     * @return
     */
    public String concatena(List<String> lista) {

        StringBuilder bld = new StringBuilder();

        for (String S : lista) {
            bld.append(S);
        }

        return bld.toString();
    }

    /**
     * Concatena uma lista de Strings e separa as palavras pelo divisor
     * informado
     *
     * @param lista
     * @param divisor
     * @return
     */
    public String concatena(List<String> lista, String divisor) {

        StringBuilder str = new StringBuilder();

        for (int i = 0; i < lista.size(); i++) {
            str.append(lista.get(i));

            if ((i + 1) < lista.size()) {
                str.append(divisor);
            }
        }
        return str.toString();
    }

    /**
     * Remove os caracteres indicados em uma String
     *
     * @param str
     * @param chars
     * @param replaces
     * @return
     */
    public String removeCaracteres(String str, String[] chars, String[] replaces) {

        if (ehVazia(str)) {
            return str;
        }

        for (int i = 0; i < chars.length; i++) {
            str = str.replaceAll(chars[i], replaces[i]);
        }

        return str;
    }

    /**
     * Remove os acentos de uma String
     *
     * @param str
     * @param regExp
     * @return
     */
    public String removeAcentos(String str, boolean regExp) {

        if (regExp) {
            CharSequence cs = new StringBuilder(str == null ? "" : str);
            return Normalizer.normalize(cs, Normalizer.Form.NFKD).replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
        } else {
            if (ehVazia(str)) {
                return str;
            }

            String[] acentos = {"á", "Á", "é", "É", "í", "Í", "ó", "Ó", "ú", "Ú", "ç", "Ç", "â", "Â", "ê", "Ê", "î", "Î", "ô", "Ô", "û", "Û", "à", "À", "è", "È", "ì", "Ì", "ò", "Ò", "ú", "Ù", "ã", "Ã", "õ", "Õ"};
            String[] replace = {"a", "A", "e", "E", "i", "I", "o", "O", "u", "U", "c", "C", "a", "A", "e", "E", "i", "I", "o", "O", "u", "U", "a", "A", "e", "E", "i", "I", "o", "O", "u", "U", "a", "A", "o", "O"};

            for (int i = 0; i < acentos.length; i++) {
                str = str.replaceAll(acentos[i], replace[i]);
            }

            return str;
        }
    }

    /**
     * Verifica algum item da lista tem algum valor, basta ter um item com valor
     * para retornar <code>true</code>
     *
     * @param itens
     * @return
     */
    public boolean temAlgumValor(List<String> itens) {
        return itens.stream().anyMatch(this::naoEhVazia);
    }

    /**
     * Verifica se todos os itens da lista estão preenchidos
     *
     * @param itens
     * @return
     */
    public boolean temTodosOsValores(List<String> itens) {
        return itens.stream().allMatch(this::naoEhVazia);
    }

    /**
     * Verifica se todos os itens da lista estão vazios
     *
     * @param itens
     * @return
     */
    public boolean naoTemValor(List<String> itens) {
        return itens.stream().allMatch(this::ehVazia);
    }

    /**
     * Verifica se uma Strring está dentro de um tamanho estaelecido
     *
     * @param str
     * @param tamMin
     * @param tamMax
     * @param trim
     * @return
     */
    public boolean verificaTamanho(String str, int tamMin, int tamMax, boolean trim) {
        if (ehVazia(str)) {
            return false;
        }

        String x = str;

        if (trim) {
            x = x.trim();
        }

        if (tamMin > 0 && x.length() < tamMin) {
            return false;
        }

        return !(tamMax > 0 && x.length() > tamMax);
    }
}
