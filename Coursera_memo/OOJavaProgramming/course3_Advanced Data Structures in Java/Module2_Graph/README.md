# 1. Intro
***
- 그래프 추상 데이터 유형(ADT)이 유용한 경우 설명
- 그래프 ADT를 다른 ADT와 비교
- 그래프와 관련된 기본 개념 정의
- 그래프 구현을 위해 Java로 클래스 작성
- 인접 행렬 표현과 인접 목록 표현을 사용하여 Java에서 그래프 구현
- 인접성 목록과 인접성 행렬 표현의 장단점을 설명
- 두 가지 방법으로 정점의 이웃을 찾는 방법을 구현
- 표현에 따라 이 방법의 성능을 평가
***
### 학습할 것
degree sequence가 무엇인지

특정 노드에서 two hops로 넘어갈 수 있는 방법은?
***
Graph 예시
```java
public abstract class Graph {
    private int numVertices;
    private int numEdges;
    
    public Graph() {
        numVertices = 0;
        numEdges = 0;
    }
    
    public int getNumVertices() {
        return numVertices;
    }
    
    public int getNumEdges() {
        return numEdges;
    }
    
    public void addVertex() {
        implementAddVertex();
        numVertices++;
    }
    
    public abstract void implementAddVertex();
    // similar for adding edges
    public abstract List<Integer> getNeighbors(int v);
}
```