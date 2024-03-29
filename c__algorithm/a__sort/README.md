[back](../README.md)

# Sort

| 20 | 38 | 18 | 9 | 44 | 22 |
| -- | -- | -- | - | -- | -- |

## Bubble Sort
- 각 반복때 마다 제일 큰 숫자를 제일 뒤에 위치시킨다.
- 반복 안에서는 앞뒤로 비교하여 큰 숫자를 뒤로 위치시킨다.

**Iteration #1**
 1. 20과 38을 비교
 
 |20|38|18|9|44|22|=>|20|38|18|9|44|22|
 |--|--|--|-|--|--|--|--|--|--|-|--|--|
 
 2. 38과 18을 비교  
 
 |20|38|18|9|44|22|=>|20|18|38|9|44|22|
 |--|--|--|-|--|--|--|--|--|--|-|--|--|
 
 3. 38과 9를 비교  
 
 |20|18|38|9|44|22|=>|20|18|9|38|44|22|
 |--|--|--|-|--|--|--|--|--|-|--|--|--|
 
 4. 38과 44를 비교  
 
 |20|18|9|38|44|22|=>|20|18|9|38|44|22|
 |--|--|-|--|--|--|--|--|--|-|--|--|--|
 
 5. 44과 22를 비교  
 
 |20|18|9|38|44|22|=>|20|18|9|38|22|44|
 |--|--|-|--|--|--|--|--|--|-|--|--|--|

**Iteration #2**
 1. 20과 18을 비교  
 
 |20|18|9|38|22|44|=>|18|20|9|38|22|44|
 |--|--|-|--|--|--|--|--|--|-|--|--|--|
 
 2. 20과 9을 비교  
 
 |18|20|9|38|22|44|=>|18|9|20|38|22|44|
 |--|--|-|--|--|--|--|--|--|-|--|--|--|
 
 3. 20과 38를 비교  
 
 |18|9|20|38|22|44|=>|18|9|20|38|22|44|
 |--|--|-|--|--|--|--|--|--|-|--|--|--|
 
 4. 38과 22를 비교  
 
 |18|9|20|38|22|44|=>|18|9|20|22|38|44|
 |--|--|-|--|--|--|--|--|--|-|--|--|--|

**Iteration #3**
 1. 18과 9를 비교  

 |18|9|20|22|38|44|=>|9|18|20|22|38|44|
 |--|--|-|--|--|--|--|--|--|-|--|--|--|
 
 2. 18과 20을 비교  
 
 |9|18|20|22|38|44|=>|9|18|20|22|38|44|
 |--|--|-|--|--|--|--|--|--|-|--|--|--|
 
 3. 20과 22를 비교  
 
 |9|18|20|22|38|44|=>|9|18|20|22|38|44|
 |--|--|-|--|--|--|--|--|--|-|--|--|--|

**Iteration #4**
1. 9와 18를 비교  

 |9|18|20|22|38|44|=>|9|18|20|22|38|44|
 |--|--|-|--|--|--|--|--|--|-|--|--|--|

2. 18과 20을 비교  

 |9|18|20|22|38|44|=>|9|18|20|22|38|44|
 |--|--|-|--|--|--|--|--|--|-|--|--|--|
 
**Iteration #5**
1. 9와 18를 비교  

 |9|18|20|22|38|44|=>|9|18|20|22|38|44|
 |--|--|-|--|--|--|--|--|--|-|--|--|--|

## Selection Sort
- 각 반복때 마다 제일 큰 숫자를 맨 뒤에 위치시킨다.
- 반복 안에서는 줄어드는 범위 안에서 제일 큰 숫자를 구하여 맨 뒤에 위치시킨다.

**Iteration #1**
 - 인덱스 0 - 5 범위 내에서 44가 제일 큰 숫자
 
 |20|38|18|9|44|22|=>|20|38|18|9|22|44|
 |--|--|--|-|--|--|--|--|--|--|-|--|--|
 
**Iteration #2**
 - 인덱스 0 - 4 범위 내에서 38이 제일 큰 숫자
 
 |20|38|18|9|22|44|=>|20|22|18|9|38|44|
 |--|--|--|-|--|--|--|--|--|--|-|--|--|

**Iteration #3**
 - 인덱스 0 - 3 범위 내에서 22가 제일 큰 숫자
 
 |20|22|18|9|38|44|=>|20|9|18|22|38|44|
 |--|--|--|-|--|--|--|--|-|--|--|--|--|
 
**Iteration #4**
 - 인덱스 0 - 2 범위 내에서 20가 제일 큰 숫자
 
 |20|9|18|22|38|44|=>|18|9|20|22|38|44|
 |--|-|--|--|--|--|--|--|-|--|--|--|--|
 
**Iteration #4**
 - 인덱스 0 - 1 범위 내에서 18이 제일 큰 숫자
 
 |18|9|20|22|38|44|=>|9|18|20|22|38|44|
 |--|-|--|--|--|--|--|-|--|--|--|--|--|

## Insertion Sort
앞에 부터 정렬하는 방식
정렬이 필요한 요소의 앞에는 모두 정렬되어 있어서 
위치에 꽂아주는 방식

**Iteration #1**
 - 인덱스 1를 기준으로 앞의 값을 비교하여 정렬
 
 |20|38|18|9|44|22|=>|20|38|18|9|44|22|
 |--|--|--|-|--|--|--|--|--|--|-|--|--|
 
**Iteration #2**
 - 인덱스 2를 기준으로 앞의 값을 비교하여 정렬
 
 |20|38|18|9|44|22|=>|18|20|38|9|44|22|
 |--|--|--|-|--|--|--|--|--|--|-|--|--|
 
**Iteration #3**
 - 인덱스 3를 기준으로 앞의 값을 비교하여 정렬
 
 |18|20|38|9|44|22|=>|9|18|20|38|44|22|
 |--|--|--|-|--|--|--|-|--|--|--|--|--|
 
**Iteration #4**
 - 인덱스 4를 기준으로 앞의 값을 비교하여 정렬
 
 |18|20|38|9|44|22|=>|9|18|20|38|44|22|
 |--|--|--|-|--|--|--|-|--|--|--|--|--|
 
**Iteration #5**
 - 인덱스 5를 기준으로 앞의 값을 비교하여 정렬
 
 |18|20|38|9|44|22|=>|9|18|20|22|38|44|
 |--|--|--|-|--|--|--|-|--|--|--|--|--|

## Quick Sort
- 피벗(pivot) 값을 선택하여 피벗 값 기준으로 작은 수를 왼쪽, 큰 수를 오른쪽으로 옮긴다.
- 옮긴후 피벗을 중심으로 나눈 후, 위의 과정을 반복한다.

![quick_sort](./quick-sort.gif)[^1]

## Heap Sort

데이터를 먼저 [Heap](../../b__data-structure/x__heap/README.md) 구조로 만든다.

---

[^1]: [https://kagus2.tistory.com/5](https://kagus2.tistory.com/5)
