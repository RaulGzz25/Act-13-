package com.company;
import java.util.*;

public class Main {

    List<String> Lista = new ArrayList<String>();
    public static void main(String[] args) {
	// Se declaran los elementos del array y los métodos de ordenamiento
        Main main = new Main();
        main.loadStrings( "Azul", "Amarillo", "Rojo", "Verde", "Morado",
                "Gris", "Cafe", "Naranja", "Rosa", "Negro");
        System.out.println();

        var sortLengthByAnonimousClass = main.sortLengtAnonimousClass();
        System.out.println("Ordenamiento por longitud\n");
        System.out.println("Por clase anónima: ");
        main.showList(sortLengthByAnonimousClass);
        System.out.println();

        var sortLengthByLamda = main.sortLengtLambda();
        System.out.println("Por expresión Lambda: ");
        main.showList(sortLengthByLamda);
        System.out.println();

        var sortLengthByReference = main.sortLengtReference();
        System.out.println("Por método de referencia: ");
        main.showList(sortLengthByReference);
        System.out.println();

        var sortAlphabeticByAnonimousClass = main.sortAlphabeticAnonimousClass();
        System.out.println("Ordenamiento por orden alfabético\n");
        System.out.println("Por clase anónima: ");
        main.showList(sortAlphabeticByAnonimousClass);
        System.out.println();

        var sortAlphabeticByLambda =main.sortAlphabeticLambda();
        System.out.println("Por expresión Lambda: ");
        main.showList(sortAlphabeticByLambda);
        System.out.println();

        var sortAlphabeticByReference =main.sortAlphabeticReference();
        System.out.println("Por método de referencia: ");
        main.showList(sortAlphabeticByReference);
        System.out.println();

    }

    public void loadStrings(String... strings) {
        for (var string : strings) this.Lista.add(string);
    }

    public List<String> sortLengtAnonimousClass() {
        List<String> strings = this.Lista;
        strings.sort(new Comparator<String>() {
            @Override
            public int compare(String str1, String str2) {
                return str1.length() - str2.length();
            }
        }
        );
        return strings;
    }

    public List<String> sortLengtLambda() {
        List<String> strings = this.Lista;
        strings.sort((str1, str2) -> str1.length() - str2.length());
        return strings;
    }

    public List<String> sortLengtReference() {
        List<String> strings = this.Lista;
        SortLengt sortLengt = new SortLengt();
        strings.sort(sortLengt::compare);
        return strings;
    }

    class SortLengt implements Comparator {
        @Override
        public int compare(Object o1, Object o2) {
            return o1.toString().length() - o2.toString().length();
        }
    }

    public List<String> sortAlphabeticAnonimousClass() {
        List<String> strings = this.Lista;
        strings.sort(new Comparator<String>() {
            @Override
            public int compare(String str1, String str2) {
                return str1.compareToIgnoreCase(str2);
            }
        });
        return strings;
    }

    public List<String> sortAlphabeticLambda() {
        List<String> strings = this.Lista;
        strings.sort((str1, str2) -> str1.compareToIgnoreCase(str2));
        return strings;
    }

    public List<String> sortAlphabeticReference() {
        List<String> strings = this.Lista;
        SortAlphaetic sortAlphabetic = new SortAlphaetic();
        Collections.sort(strings, sortAlphabetic::compare);
        return strings;
    }

    class SortAlphaetic implements Comparator {
        @Override
        public int compare(Object o1, Object o2) {
            return o1.toString().compareToIgnoreCase(o2.toString());
        }
    }
    public void showList(List<String> strings){
        strings.forEach(System.out::println);
    }
}