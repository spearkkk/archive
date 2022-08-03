[Design Pattern](../README.md)
[MVC Pattern](../a__mvc-pattern/README.md) - [Template Pattern](./README.md) - [Strategy Pattern](../c__strategy_pattern/README.md)    

---

# Template Pattern
템플릿 패턴은 특정한 형식(템플릿)을 만든 후 이 템플릿에 맞춰 코드를 작성하는 패턴이다.  
로깅과 같은 부가적인 기능을 비즈니스 로직과 분리해서 생각할 때, 로깅은 여러 비즈니스 로직에 사용할 수 있다.  
따라서 비즈니스 로직, 핵심 기능을 구현할 때 로깅과 같은 부가 기능이 반복된다.  

이 때 부가 기능을 공통적으로 사용하기 때문에 이를 구현한 템플릿을 만들고, 핵심 기능을 구현한다.  
이를 템플릿 패턴이다. 추상 클래스를 통해 부모 클래스에서 부가 기능을 구현하고 핵심 기능을 구현할 수 있는 추상 메소드를 놓는다.
하나의 메소드를 선언하여 전체 플로우를 정의한다. 자식 클래스는 핵심 기능을 구현한다. 이미 부모 클래스에서 핵심 기능을 포함한 플로우가 정의되어 있다.
따라서 자식 클래스는 비즈니스 로직 구현에만 집중 할 수 있다.

그러나 상속을 통한 템플릿 패턴은 부모와 자식 클래스가 강하게 결합되어 있다. 부모의 클래스의 변경이 모든 자식에게 변경을 강요한다. 또한 자식에게는 불필요한
부모 클래스의 로직 등을 가지고 있다.

부모 추상 클래스로 템플릿을 만들고
자식 구현 클래스로 템플릿을 구현한다.

---

[MVC Pattern](../a__mvc-pattern/README.md) - [Template Pattern](./README.md)  - [Strategy Pattern](../c__strategy_pattern/README.md)    
[Design Pattern](../README.md)
