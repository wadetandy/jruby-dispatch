package com.bloomberg.jrubytest;

import org.jruby.Ruby;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.BufferedReader;
import javax.script.ScriptEngineManager;
import javax.script.ScriptEngine;
import javax.script.ScriptContext;
import javax.script.ScriptException;

public class Main {
    public static void main(String[] args) {
        ScriptEngineManager m = new ScriptEngineManager();
        ScriptEngine rubyEngine = m.getEngineByName("jruby");

        ScriptContext context = rubyEngine.getContext();

        try {
            File f = new File("bootstrap.rb");
            BufferedReader bf = new BufferedReader(new FileReader(f));
            rubyEngine.eval(bf, context);
        } catch (ScriptException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
