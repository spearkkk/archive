[Git](../a__git/README.md) - [Data Structure](../b__data-structure/README.md) - [Algorithm](../c__algorithm/README.md) - [Design Pattern](../d__design-pattern/README.md) - [Language](../e__language/README.md) - [Spring](../f__spring/README.md) - [Transfer](../x__transfer/README.md) - [ETC](../z__etc/README.md)  - [Exit](../README.md)

---

# Spring

Spring Framework는 무엇일까?  
애플리케이션을 만들기 쉽게 틀을 제공한다. 다시 말하자면, 애플리케이션을 개발할 때 사용자의 요청을 다루거나 데이터 베이스에 접속해야 한다.  
대부분의 애플리케이션이 공통적으로 수행하는 기능을 쉽게 제공해준다. 이로써 엔지니어들이 비즈니스 로직에만 집중할 수 있도록 도와준다.  

특히 스프링 프레임워크에서는 POJO(Plain Old Java Object)[^1]와 같이 순수하게 자바 객체를 가지고 개발할 수 있도록 지원하고 있다.  
이를 가능하게 하는 것 스프링이 IoC(Inversion of Control)[^2]를 지원하기 때문이다.  
스프링 컨테이너가 객체들의 생명주기를 담당하고 각 객체들은 자신이 담당하는 핵심 로직만 수행할 수 있기 때문이다.

## IoC와 DI
IoC(Inversion of Control)는 객체의 생성과 파괴 등과 같은 객체에 대한 제어권을 다른 객체에 위임하는 것을 일컫는다.  
우리가 하나의 객체에서 다른 객체를 접근할 때를 생각해보자. A객체에서 B객체를 접근할 때, B의 객체는 살아있어야 한다. 따라서 B객체를 생성해야 한다.  
그러나 B객체에 대한 생성을 다른 누군가가 해주고 있다 하자. 그러면 A객체는 더 이상 B객체에 대한 생성을 관여하지 않아도 된다.  
이미 위임 받은 객체가 B객체를 생성했기 때문이다. 이렇게 제어권을 실제 사용하는 객체가 아닌 다른 객체에 위임하는 것을 IoC라 한다.  

그렇다면 생성된 B객체는 어떻게 A객체에서 접근할 수 있을까?  
A객체에서 B객체를 사용하기 위해 B에 대한 변수를 가지고 있을 것이다. 객체 생성에 대한 위임을 했기 때문에 B객체 생성은 관여하지 않는다.  
그 대신 위임받은 객체가 B객체를 생성하고 이 생성한 객체를 A객체가 참조할 수 있도록 주입을 해준다. 이를 DI(Dependency Injection)이라 한다.  

스프링 프레임워크는 IoC를 지원하기 위해 DI라는 방식을 사용하고 있다.
추가적으로 스프링에서는 DI를 생성자, 메소드(setter), 멤버 변수로 지원하고 있다.   

## AOP
AOP(Aspect Oriented Programming)는 관점 지향 프로그래밍이다. OOP(Object Oriented Programming)은 객체 지향 프로그래밍으로 객체 중심으로  
프로그래밍을 했듯이, AOP는 관점 중심으로 프로그래밍을 하는 것이다. 관점을 중심으로 생각해볼때 비즈니스 핵심 플로우에서 로깅을 한다거나 함수 수행 시간을 측정한다거나  
하는 부분은 비즈니스 관점에서 부가적인 부분이다. 또한 로깅, 함수 수행 시간 측정의 관점에서 본다면 이는 다른 로직에서도 충분히 사용될 수 있다.  
관점 지향 프로그래밍은 로깅, 함수 수행 시간 측정 부분을 추출해서 프로그래밍을 한다고 볼 수 있다.  

그렇다면 스프링은 AOP를 어떻게 지원하고 있을까? 스프링은 DI를 통해 객체 간의 의존성을 주입하고 있다.  
여기서 A객체에 B객체를 주입할 때, B객체를 실행하는 B의 프록시 객체를 실제 A객체에 주입하고 있다.  
즉, A객체가 B객체의 메소드를 호출을 한다는 것은 A객체가 B의 프록시 객체의 메소드를 호출하는 것이다. 
B의 프록시 객체는 실제 B객체의 메소드를 실행 전/후의 포인트를 가로채 AOP의 기능을 수행한다.

## ORM과 JPA, 그리고 Hibernate
ORM(Object Relational Mapping)은 애플리케이션의 객체와 데이터베이스의 테이블 사이를 매핑시켜주는 개념을 일컫는다.  
따라서 자바에서만 사용하는 개념이 아니다. 다른 언어도 ORM을 위한 프레임워크가 있다.  
기존에는 데이터베이스에서 데이터를 조회하고 변경하기 위해서는 쿼리를 작성했다. 그러나 테이블과 매핑된 객체가 애플리케이션에 있다면 어떻게 될까?  
객체에 대한 조회와 업데이트를 쿼리가 아닌 객체의 메소드로 표현할 수 있다.  
이로써 애플리케이션에 데이터베이스를 다룰 때, 쿼리가 아닌 메소드로 가능하게 되면서 보다 더 직관적이고 편해졌다.  

그렇다면 이 ORM을 위해서 스프링은 어떻게 했을까? 스프링은 ORM을 위해 JPA(Java Persistent API)라는 표준 인터페이스를 만들었다.  
이 JPA에 맞춰 구현한 구현체가 있다면 그 구현체는 스프링 생태계에서 사용될 수 있다.  
Hibernate는 JPA 표준 인터페이스를 구현한 여러 구현체들 중 하나이다.


## Spring MVC, MVC 1과 MVC 2의 차이
[MVC](../d__design-pattern/a__mvc-pattern/README.md)

spring mvc 구조 흐름에 대해 상세히 말해주세요.

https://kotlinworld.com/326


## Spring Boot의 등장, Spring MVC와의 차이


### Reference
- [Spring Boot vs. Spring MVC](./spring-boot_vs_spring-mvc.pdf)

[^1] 특정 기술과 환경에 종속되어 있는 객체가 아니라 이와 상관없이 필요에 따라 재활용될 수 있는 객체이다.
[^2] 한 객체 내에서 다른 객체를 직접적으로 제어하는 것이 아니라 이를 위임해서 다른 객체가 담당하는 것이다.
[^3] 객체와 테이블 사이를 매핑해주는 것이다.

---

[Git](../a__git/README.md) - [Data Structure](../b__data-structure/README.md) - [Algorithm](../c__algorithm/README.md) - [Design Pattern](../d__design-pattern/README.md) - [Language](../e__language/README.md) - [Spring](../f__spring/README.md) - [Transfer](../x__transfer/README.md) - [ETC](../z__etc/README.md)  - [Exit](../README.md)
