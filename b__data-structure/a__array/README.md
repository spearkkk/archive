[Data Structure](../README.md)
[Array](../a__array/README.md) - [Stack & Queue](./README.md) - [List](../c__list/README.md) - [Heap](../x__heap/README.md)  

---

# Array
배열은 같은 자료형을 가진 자료구조로서 연속된 메모리 공간을 가진다.  
따라서 배열의 첫 메모리 주소를 알고 있다면 자료형의 메모리 크기를 계산하여 인덱스로 바로 접근이 가능하다.  
메모리를 바로 접근할 수 있어 random access가 가능하다. 데이터를 읽는데 O(1) 복잡도를 가진다.  

## Static Array
배열을 생성할 때, 일정 크기의 배열을 생성한다. 고정된 크기의 배열이기 때문에 할당된 공간 이상의 데이터를 추가할 수 없다.  

## Dynamic Array
배열을 데이터를 담을 수 있는 공간이 가변적으로 늘어난다. 일반적인 배열의 크기인 size와 다르게 허용 용량인 capacity를 가지고 있다.  
만약 capacity가 부족하게 될 경우, 더 큰 capacity를 가진 배열을 생성하여 기존 배열의 데이터를 복사해서 옮기는 과정을 거친다.  

이 동적 배열에서의 삽입/삭제는 맨 뒤에서 일어날 경우 O(1)의 시간 복잡도를 가지지만,   
맨 앞이나 중간에서의 삽입/삭제는 다른 요소들을 옮겨주어야 하기 때문에 O(n)의 시간 복잡도를 가진다.  

검색에 있어서는 모든 배열의 요소를 다 찾아봐야 하기 때문에 O(n)의 복잡도를 가진다.

ref.)
- [Array](https://github.com/qkraudghgh/coding-interview/blob/master/DataStructure/Array/Array.md)
- [Array 배열 기초개념? 10분안에 정리해줌!](https://youtu.be/NFETSCJON2M)

---

[Array](../a__array/README.md) - [Stack & Queue](./README.md) - [List](../c__list/README.md) - [Heap](../x__heap/README.md)  
[Data Structure](../README.md)  
