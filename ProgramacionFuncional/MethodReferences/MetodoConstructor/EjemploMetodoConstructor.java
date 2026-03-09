package ProgramacionFuncional.MethodReferences.MetodoConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class EjemploMetodoConstructor {
    public static void main(String[] args) {
        Supplier<List<String>> lista = ArrayList::new;

        List<String> l = lista.get();
    }
}
