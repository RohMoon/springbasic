# 3가지 디자인 패턴 - 전략 / 템플릿 메서드 / 추상 팩토리

## 템플릿 메서드 패턴
- 우리가 상속이 좋지 않다고 할 때 , 그 이유는 부모 클래스의 수정의 여파가 모든 자식에게 미치기 때문이다.
  - 하지만 템플릿 메서드 패턴에서는 이러하 부모 - 자식 간의 의존성 방향을 부모가 자식을 아는 방향으로 역전시키게 된다.  
  일반적으로는 자식이 부모의 세부구현을 알고서 이를 이용하는 쪽으로 상속이 일어나지만, 템플릿 메서드 패턴에서는 부모가 반대로 추상 메서드 인터페이스를 통해서 자식을 알게 된다.  
  - 부모가 자식이 미래에 구현해야할 오퍼레이션을 확정 지은 상태에서 자식을 이용해서 자신의 로직을 구현하고, 자식은 제한된 자신의 책임만 구현하고 부모의 지식을 몰라도 된다.

```java
package com.tobySpring.chapter1.pattern.codeSpit.templateMethodPattern;

import java.util.HashSet;

abstract class DiscountPolicy {
    private Set<DiscountCondition> conditions = new HashSet<>();

    public void addCondition(DiscountCondition condition){conditions.add(condition)}

    public Money calculateFee(Screening screening, int count, Money fee){// 템플릿 메서드
    for (DiscountCondition condition : conditions){
        if (condition.isSatisfiedBy(screening, count)) return calculateFee(fee);
    }
    return fee;
    }
    protected abstract Money calculateFee(Money fee); //훅  ?? 선택적으로 받아야하는게 훅이라고 토비의 스프링에서 이야기하는데 ??
}
```
- 디자인 패턴에서는 이러한 의존성을 간단하게 표현하기 위해 이를 2가지 용어로 정하였다.  
- 미래의 자식이 구현해야 하는 책임을 `훅`이라고 부르며, 이를 이용하는 메서드를 템플릿 메서드라고 부른다.
  - 토비에선 책임이 아닌 선택적으로 오버라이딩하는 메서드를 템플릿메서드라고 부른다
  - 코드의 기본 알고리즘을 담고 있는 메서드가 템플릿 메서드
  - 서브클래스에서 반드시 구현해야하는 것이 추상메서드이다.

- 템플릿 메서드 패턴을 이용해 AmountPolicy를 아래와 같이 구현한다.
```java
package com.tobySpring.chapter1.pattern.codeSpit.templateMethodPattern;

public class AmountPolicy extends DiscountPolicy{
    private final Money amount;
    public AmountPolicy(Money amount){
        this.amount = amount;
    }

    @Override
    protected Money calculateFee(Money fee) {
        return fee.minus(amount);
    }
}
```
- AmountPolicy는 abstract로 지정한 자신의 책임만 구현하고 있고, 나머지 모든 구현은 부모의 속성이나 super 등을 사용하고 있지 않다.
- 부모 클래스에는 `public`으로 외부에 대외적으로 공개된 메서드를 제외하면 모두 `private`로 접근을 막고 있기 때문에 부모의 변경은 자식 클래스에 여파를 끼치지 않는다.
- 이 때 `protected` 권한의 추상 메서드를 통해서 자식 클래스가 메서드를 제공해야 되는 책임을 미리 약속함으로써,  
미리 약속된 프로토콜을 통해서만 부모와 통신하도록 한정함으로써 의존성을 역전시킨 것이다.


- 따라서 템플릿 메서드 패턴은 추상 메서드라는 일종의 프로토콜을 이용해서 부모와 자식이라는 두 객체가 대화하게끔 도와주는 패턴이라고 할 수 있으며,  
상속구조에서 자식이 부모를 알게됨으로써 부모의 수정이 자식에 여파를 끼치는 구조를 부모가 추상 메서드 프로토콜을 통해서 자식을 알도록 의존성의 방향을 바꾸게 해준다.  
상속이라는 의존성의 문제를 해결해주는 패턴이라고 할 수 있다.
- 만약 상속하는 어떤 부모 클래스에서 `private`가 아닌 `protected` 혹은 `internal`속성이거나 `getter/setter`를 가지고 있따면 이미 그 단계에서 우리는 부모 클래스를 수정할 수 없게 된다.  
따라서 상속을 사용할 때는 여파가 미치지 않도록 의존성을 역전시키거나, 혹은 부모 클래스의 속성을 `private`으로 노출되지 않게 해야 한다.

- 다만 상속은, 언어 차원에서 어떠한 객체가 다른 객체에 대한 지식을 알게 하는 의존성을 생성하는 것이며, 이러한 의존성의 문제는 비단 상속만의 문제가 아니다.
  - 어떠한 객체를 아는 객체의 수가 많아지면, 해당 객체를 수정하기 힘들어지는 문제가 발생하며, 이를 단일 의존포인트라고 한다.
    - 이 때 이러한 의존성을 해결하기 위해서는, 다른 여러 객체들('자식들')이 알고 있는 하나의 객체('부모')가 자식들에 대한 지식을 사용하고, 자식들은 부모에 대한 지식을 사용하지 않도록 해야 한다.  
    템플릿 메서드의 경우에는 이러한 자식들의 지식을 하나의 추상메서드 프로토콜로써 인식하게 해준다.

