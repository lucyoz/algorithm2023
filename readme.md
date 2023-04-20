# 자료구조와 알고리즘

> 프로그래머스 </br>
> 백준 (with Do It! 알고리즘 코딩테스트 자바편) </br>
> 이것이 코딩테스트다 (나동빈 저, 한빛미디어)

### **BFS와 DFS**
- [음료수 얼려먹기](https://github.com/lucyoz/algorithm2023/blob/master/src/etc/Icecream.java): DFS 재귀이용
- [미로 탈출](https://github.com/lucyoz/algorithm2023/blob/master/src/etc/EscapeMaze.java): BFS로 간선의 비용이 같을 때 최단거리 구하기
- [게임 맵 최단거리](https://github.com/lucyoz/algorithm2023/blob/master/src/dfsNbfs/shortestDistance.java): BFS로 최단거리
- [타겟 넘버 using BFS](https://github.com/lucyoz/algorithm2023/blob/master/src/dfsNbfs/TargetNumberUsingBFS.java0): BFS
- [타겟 넘버 using BFS](https://github.com/lucyoz/algorithm2023/blob/master/src/dfsNbfs/TargetNumberUsingDFS.java0): DFS
- [DFS와 BFS (백준)](https://github.com/lucyoz/algorithm2023/blob/master/src/dfsNbfs/BaekJoon1260.java): DFS(재귀), BFS(큐)

### **정렬**
- [가장 큰 수](https://github.com/lucyoz/algorithm2023/blob/master/src/sort/LargestNumber.java): Comparator 오버라이드(내림차순)
```java
//문자열: 앞에서부터 비교, 'a-b' 순서로 해당 문자의 아스키코드 값을 뺀 결과
a.compareTo(b)    

//내림차순은 (o2+o1).compareTo(o1+o2);
//오름차순은 (o1+o2).compareTo(o1+o2);
```


### **백준**
- [어두운 굴다리](https://github.com/lucyoz/algorithm2023/blob/master/src/etc/baekjoon/BeakJoon17266.java): Parametric Search
- [구간 합 구하기 4](https://github.com/lucyoz/algorithm2023/blob/master/src/etc/baekjoon/BaekJoon11659.java): 기본 구현