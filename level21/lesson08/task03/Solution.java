package com.javarush.test.level21.lesson08.task03;

/* Запретить клонирование
Разрешите клонировать класс А
Запретите клонировать класс B
Разрешите клонировать класс C
Метод main не участвует в тестировании.
*/
public class Solution {
    public static void main(String args[]){
        A a = new A(2,3);
        B b = new B(1,2,"B");
        C c = new C(2,3,"C");
        A clone = null;
        B clone1 = null;
        C clone2 =null;
        try
        {
            clone = (A) a.clone();
            clone1 = (B)b.clone();
            clone2 = (C)c.clone();

        }catch (CloneNotSupportedException e)
        {

        }
        System.out.println(a);
        System.out.println(clone);
        System.out.println(b);
        System.out.println(clone1);
        System.out.println(c);
        System.out.println(clone2);
    }
    public static class A implements Cloneable {
        private int i;
        private int j;

        public A(int i, int j) {
            this.i = i;
            this.j = j;
        }

        public int getI() {
            return i;
        }

        public int getJ() {
            return j;
        }

        @Override
        protected Object clone() throws CloneNotSupportedException
        {
            return super.clone();
        }
    }

    public static class B extends A {
        private String name;

        public B(int i, int j, String name) {
            super(i, j);
            this.name = name;
        }

        public String getName() {
            return name;
        }

        @Override
        protected Object clone() throws CloneNotSupportedException
        {
            throw new CloneNotSupportedException();
        }
    }

    public static class C extends B
    {
        public C(int i, int j, String name)
        {
            super(i, j, name);
        }
        private C duplicate(C c){
            return new C(c.getI(),c.getJ(),c.getName());
        }

        @Override
        protected Object clone() throws CloneNotSupportedException
        {
            return duplicate(this);
        }
    }
}
