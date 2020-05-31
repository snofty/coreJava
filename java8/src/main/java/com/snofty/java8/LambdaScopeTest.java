package com.snofty.java8;


public class LambdaScopeTest {
    public int x = 0;
    class FirstLevel{
        public int x = 1;
        public void methodInFirstLevel(int x){


        }
    }
    public static void main(String[] args){
        LambdaScopeTest st = new LambdaScopeTest();
        LambdaScopeTest.FirstLevel fl = st.new FirstLevel();
        fl.methodInFirstLevel(23);
    }
}
