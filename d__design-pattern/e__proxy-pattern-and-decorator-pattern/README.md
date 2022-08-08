[Design Pattern](../README.md)
[MVC Pattern](../a__mvc-pattern/README.md) - [Template Pattern](../b__template-pattern/README.md) - [Strategy Pattern](../c__strategy-pattern/README.md) - [Template Callback](./README.md)

---

# Proxy Pattern & Decorator Pattern
프록시 패턴과 데코레이터 패턴을 알아 보기 전에 프록시에 대해 알아보자.

## Proxy
데이터의 흐름을 보면 한 쪽에서 다른 한 쪽으로 요청을 보내고 요청을 받은 다른 한 쪽은 응답을 한다. 물론 응답 없이 요청을 처리할 수 있다.  
예를 들어 웹 브라우저가 데이터를 가져오기 위해 웹 서버에게 데이터를 요청한다. 이러한 플로우에서 우리는 요청을 하는 쪽을 클라이언트(client),  
요청을 받는 쪽을 서버(server)라고 한다.  
프록시(Proxy)는 이 클라이언트와 서버 사이 중간에 위치한다. 클라이언트가 프록시를 호출하고 프록시는 요청을 다시 서버에게 보낸다.  
클라이언트가 서버에게 직접적으로 요청을 보낼 수 있지만, 프록시를 통해 간적적으로 요청을 보낼 수 있다.  
여기서 중간에 다수의 프록시들이 위치해 있다면 이를 프록시 체인이라 한다.  

## Proxy Pattern
프록시 패턴(Proxy Pattern)은 이 프록시 개념을 이용한 방법이다. 클라이언트 객체와 서버 객체 사이에 위치해 헌 갹채의 요청을 받아 다른 객체로 전달한다.  
이때, 요청에 대한 값을 보고 유효성을 검사하여 접근을 막을 수 있다. 다른 객체에 접근을 제어할 수 있다.  
또 요청에 대한 응답 값을 프록시에서 다루고 있다가 응답할 수 있다. 요청에 대한 캐시의 역할도 수행할 수 있다.  
이처럼 한 객체에서 다른 객체의 요청을 받아 접근을 제어하고 캐시를 적용하는 방법을 프록시 패턴이라고 한다.

## Decorator Pattern
데코레이터 패턴(Decorator Pattern)은 프록시 패턴과 유사한 방법이다. 다른 부분은 이 패턴을 사용하는 의도다. 프록시 패턴에서는 접근 제어, 캐시 적용 등의
기능을 수행했다면, 데코레이터 패턴은 이와 다르게 로깅, 값의 변형, 함수 실행 시간 측정 등의 부가적인 기능을 담당한다.  

## Proxy Pattern & Decorator Pattern in Java
자바에서의 프록시 패턴과 데코레이터 패턴은 인터페이스(interface) 또는 클래스(class)를 이용하여 구현할 수 있다. 인터페이스는 동일한 인터페이스 형태를 가지고  
이 인터페이스에 맞춰 구현한 후 서로 연결해준다. 클래스는 상속을 통해 인터페이스를 맞춘다.  

---

[MVC Pattern](../a__mvc-pattern/README.md) - [Template Pattern](../b__template-pattern/README.md) - [Strategy Pattern](../c__strategy-pattern/README.md) - [Template Callback](./README.md)    
[Design Pattern](../README.md)
