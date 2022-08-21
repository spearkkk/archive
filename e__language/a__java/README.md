# Java
* [Lazy Evaluation & Eager Evaluation](./a__lazy-evaluation_eager-evaluation/README.md)
* [JVM](./b__jvm/READMD.md)
* [Object Mapping](https://github.com/spearkkk/map-struct-example)


## String Java
java 의 String 은 immutable 이다.
String의 함수를 호출하면 해당 객체가 변경되는 것이 아니라,
새로운 객체가 반환되는 것이다.
new String(str)은 명시적으로 str와 동일한 문자열을 가진 객체를 생성하는 것이다.
따라서 str와 값은 값지만 jvm heap에 새로운 메모리에 할당하는 것이기 때문에 서로 다른 객체이다.
new String()(생성자)로 생성한 객체는 heap에 새로운 메모리를 할당하여 객체를 생성하는 것이기 때문에
`==` 연산자의 결과가 서로 다르다. 왜냐하면 `==` 연산자는 객체가 서로 다른지 확인하는 연산자이기 때문이다.
실제로 두 객체의 identityHashCode 값을 보면 다르다.
문자열의 값이 동일한지 확인하기 위해서는 eqauls() 함수를 이용한다. 이 함수는 문자열의 시퀀스를 확인한다.
그렇다면 "HARIBO"처럼 리터럴(literal)하게 선언한 것과 String.valueOf()로 선언한 객체는 왜 같은 객체일까?
그 이유는 둘다 리터럴로 객체를 선언한 것과 같다. String.valueOf()를 들어가보면 null 값일 때에 명시적으로 'null'를 반홚하고
이외의 값은 toString()을 호출한다. 즉 "HARIBO".toString()과 같은 상황이다.
다시 생각해보면 "HARIBO"와 "HARIBO"의 `==`이기 때문에 값이 같지 않을 수 없다.
그렇다면 리터럴로 생성된 객체는 항상 같은 객체일까?
어떻게 보면 맞다. 리터럴로 생성된 문자열은 jvm heap(1.8이상 부터)에 위치한 constant pool에서 관리되고 있다.
객체가 constant pool에 있으면 이를 사용하고 없으면 새로 생성한 후, pool에 등록하고 사용한다.
String.intern() 함수를 조금 깊게 보면 자세히 알 수 있을 듯하다.
https://www.latera.kr/blog/2019-02-09-java-string-intern/
https://blog.naver.com/adamdoha/222817943149

```java
String haribo1st = new String("HARIBO");
String haribo2nd = new String("HARIBO");
String haribo3rd = "HARIBO";
String haribo4th = String.valueOf("HARIBO");

System.out.println(haribo1st == haribo2nd);
System.out.println(haribo1st.equals(haribo2nd));

System.out.println(haribo1st == haribo3rd);
System.out.println(haribo1st.equals(haribo3rd));

System.out.println(haribo1st == haribo4th);
System.out.println(haribo1st.equals(haribo4th));

System.out.println(haribo3rd == haribo4th);
System.out.println(haribo3rd.equals(haribo4th));

```
