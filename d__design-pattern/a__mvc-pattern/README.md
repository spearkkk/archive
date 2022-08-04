[Design Pattern](../README.md)  
[MVC Pattern](./README.md) - [Template Pattern](../b__template-pattern/README.md) - [Strategy Pattern](../c__strategy-pattern/README.md) - [Template Callback](../d__template-callback-pattern/README.md)    

---

# MVC Pattern
MVC는 Model, View, Controller의 약자이다. MVC 패턴은 이 model, view, controller로 구성된 패턴을 말한다.  
그렇다면 MVC 패턴에서 MVC는 어떤 것을 담당하고 있을까?  
먼저 모델(model)은 데이터를 나타낸다. 데이터베이스 또는 파일와 같은 스토리지에 저장된 데이터를 가진 객체다. 반면에 뷰(view)는 모델로부터 가져온 데이터를  
보여주는 역할이다. 컨트롤러(controller)은 모델을 이용해 데이터를 조회하고 뷰를 통해 사용자에게 보여줄 수 있도록 사용자의 요청을 처리한다.  

- 모델: 저장소의 데이터를 표현하고 필요에 따라 비즈니스 로직을 수행한다.
- 뷰: 비즈니스 로직와는 관계없이 단순히 사용자에게 필요한 정보를 어떻게 표현할지만 담당한다.
- 컨트롤러: 사용자 요청에 따라 모델과 뷰 사이에서 흐름을 제어한다.


### Reference
- [https://bsnippet.tistory.com/13](https://bsnippet.tistory.com/13)
- [https://m.blog.naver.com/jhc9639/220967034588](https://m.blog.naver.com/jhc9639/220967034588)

---

[MVC Pattern](./README.md) - [Template Pattern](../b__template-pattern/README.md) - [Strategy Pattern](../c__strategy-pattern/README.md) - [Template Callback](../d__template-callback-pattern/README.md)    
[Design Pattern](../README.md)    
