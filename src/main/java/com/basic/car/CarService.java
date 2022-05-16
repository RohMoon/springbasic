package com.basic.car;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.stereotype.Service;

@Service
public class CarService {

    @Autowired
    CarRepository carRepository;

    @Autowired
    ValueSample vs;


    public void setCarRepository(CarRepository carRepository){
        this.carRepository = carRepository;

    }


    public void print(){
        System.out.println("----------프린트---------");
        System.out.println(vs.getA());
        System.out.println(vs.getName());
        System.out.println(vs.isBool());
        System.out.println(vs.data);

        ExpressionParser parser = new SpelExpressionParser();
        Expression expression = parser.parseExpression("2+ 100");//표현식의 #{} 내부에 들어갈 값을 적어주면 됨.
        expression.getValue(Integer.class);// Integer 클래스로 값을 가져오겠다는 뜻, Conversion service 사용하는 것.
        System.out.println(expression.getValue(Integer.class));
    }
}
