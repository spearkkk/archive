# Lazy Evaluation & Eager Evaluation
Lazy evaluation 은 실제 값을 필요로 할 때, 연산을 하는 것이다. 따라서 값이 필요로 하지 않는 상황이면 연산을 하지 않는다.  
이와 다르게 eager evaluation 은 실제 값이 필요와 상관없이 연산을 하여 값을 구한다.  
따라서 Eager evaluation 보다 lazy evaluation 을 통해 프로그램을 구성하면 불필요한 연산(리소스 사용)를 하지 않을 수 있다.  
그렇다면 자바(java)에서 lazy evaluation 은 어떻게 사용할 수 있을까?

### Eager Evaluation
아래와 같이 `getBoolean` 메소드를 통해 boolean 값을 가지고 온다고 생각해보자.    
이때의 코드는 'first'와 'second', 총 두번 메소드를 호출한다.
```java
public class Main {
    public static void main(String args[]) {
        try {
            boolean first = getBoolean("first");
            boolean second = getBoolean("second");

            boolean result = first && second;
            System.out.println("result: " + result);
        } catch (InterruptedException e) {
            // nothing
        }
    }

    private static boolean getBoolean(String name) throws InterruptedException {
        System.out.println("[" + name + "] thread sleep...");
        Thread.sleep(1000L);
        System.out.println("[" + name + "] thread awake...");

        return false;
    }
}
```

### Lazy Evaluation
위의 코드를 변경하여 아래와 같이 작성하면 어떻게 될까?  
'first' 의 값이 먼저 확인하기 때문에 'second'는 실행하지 않는다. 즉, 총 한번 메소드를 호출한다.
```java
public class Main {
    public static void main(String args[]) {
        try {
            boolean result = getBoolean("first") && getBoolean("second");
            System.out.println("result: " + result);
        } catch (InterruptedException e) {
            // nothing
        }
    }

    private static boolean getBoolean(String name) throws InterruptedException {
        System.out.println("[" + name + "] thread sleep...");
        Thread.sleep(1000L);
        System.out.println("[" + name + "] thread awake...");

        return false;
    }
}
```
  
그러나 위의 코드를 아래와 같이 변경하면 어떻게 될까?  
매개변수로 넘길 때, 매개 변수의 값을 먼저 가져오기 때문에 'first' 값만으로도 결과를 알 수 있으나 실제 메소드는 총 두번 호출한다.
```java
public class Main {
    public static void main(String args[]) {
        try {
            boolean result = and(getBoolean("first"), getBoolean("second"));
            System.out.println("result: " + result);
        } catch (InterruptedException e) {
            // nothing
        }
    }

    private static boolean and(boolean first, boolean second) {
        return first && second;
    }

    private static boolean getBoolean(String name) throws InterruptedException {
        System.out.println("[" + name + "] thread sleep...");
        Thread.sleep(1000L);
        System.out.println("[" + name + "] thread awake...");

        return false;
    }
}
```

첫 번째로 변경한 코드는 변수를 사용하지 않고 메소드를 직접 호출하였고, 'first'의 값에 따라 'second'를 호출이 안될 수도 있었다.  
그러나 두 번째로 변경한 코드는 매개변수로 넘길 때, 메소드를 호출하도록 했고 결과 값을 이를 입력받은 곳에서 사용하도록 했다.  
매개변수로 넘길 때에는 메소드의 로직과 상관없이 값을 가져오는 것을 알 수 있었다.  
  
그렇다면 이를 아래와 같이 변경하면 여전히 메소드를 두번 호출할까?  
```java
import java.util.function.Supplier;

public class Main {
    public static void main(String args[]) {
        boolean result = and(() -> getBoolean("first"), () -> getBoolean("second"));
        System.out.println("result: " + result);
    }

    private static boolean and(Supplier<Boolean> first, Supplier<Boolean> second) {
        return first.get() && second.get();
    }

    private static boolean getBoolean(String name) {
        System.out.println("[" + name + "] thread sleep...");
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            // nothing
        }
        System.out.println("[" + name + "] thread awake...");

        return false;
    }
}
```
메소드를 직접호출하지 않고 Supplier로 한번 감싼 후 매개 변수로 전달했다.  
이 때의 메소드는 총 한번 호출한다.  

### Reference
- https://tourspace.tistory.com/77
- https://sabarada.tistory.com/153
