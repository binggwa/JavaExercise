# 자료구조 학습
***
### 자료구조
- 자료구조와 알고리즘은 상호의존적
- 알고리즘 문제를 풀기 위해 해석한 다음, 자료구조를 선택한다
- 적절한 자료구조는 보다 효율적인 알고리즘을 선택할 수 있다
- ex) 삽입, 삭제가 빈번하게 발생한다면 LinkedList를, 아니면 ArrayList를 사용
- 이런 자료구조별 장단점을 숙지하고 이해하기 위해 자바의 대표적 자료구조인 Collections를 학습하고 구현해본다
***
### 자료구조의 분류
- 선형 자료구조
  - 데이터가 일렬로 연결된 형태 ex) int[] 배열 등
  - 대표젹으로 List, Queue, Deque 가 있다.
- 비선형 자료구조
  - 데이터가 일렬로 나열된 것이 아닌, 각 요소가 여러 개의 요소와 연결된 형태
  - 대표적으로 Graph, Tree 가 있다.
- 집합(Set)
  - 집합 자료구조는 위 두 분류에 해당하지 않는다.
  - 데이터가 연결된 형식이 아니며, table에 가까운 자료구조
- 파일 자료구조
  - 순차파일, 색인파일, 직접파일이 있다
***
### Java Collection Framework
- 일정 타입의 데이터들을 쉽게 가공할 수 있도록 지원하는 자료구조들의 뼈대
- Collection은 크게 3가지 인터페이스로 나뉘어있다
  - List
  - Queue
  - Set
- Collection 모식도

<img src="C:\Users\qudrh\JavaExercise\Coursera_memo\DataStructure\Java Collections Framework\Collection.png" width="450px" height="300px" title="Collection" alt="Collection"></img><br/>

- Collection 선택기준

<img src="C:\Users\qudrh\JavaExercise\Coursera_memo\DataStructure\Java Collections Framework\CollectionSelect.png" width="450px" height="300px" title="CollectionSelect" alt="CollectionSelect"></img><br/>

