package com.tobySpring.chapter1.pattern;

public abstract class TemplatePattern {

    /*
    * 기본 알고리즘 골격을 담은 메서드를 템플릿 메서라 부른다.
    * 템플릿 메서드는 서블클래스에서 오버라이드 하거나 구현할 메서드를 사용한다.
    * */
    public void templateMethod(){
    //기본 알고리즘 코드
    hookMethod();
    abstractMethod();
    }

    protected void hookMethod() {  } //선택적으로 오버라이드 가능한 훅 메서드
    public abstract void abstractMethod(); //서브클래스에서 반드시 구현해야하는 추상 메서드.

    /*
    * 슈퍼클래스의 메서드를 오버라이드하거나 구현해서 기능을 확장한다.
    * 다양한 확장 클래스를 만들거 수 있다.
    * */
    public class Sub1 extends TemplatePattern{

        /*
        *
        */
        @Override
        public void abstractMethod() {

        }
        
        /*
        * 선택적으로 Override 가능한 메서드
        * */
        @Override
        protected void hookMethod() {
            
        }
    }

}
