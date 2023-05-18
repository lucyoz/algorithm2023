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
- [무인도 여행](https://github.com/lucyoz/algorithm2023/blob/master/src/etc/Travelisland2.java): bfs 이용

### **정렬**
- [가장 큰 수](https://github.com/lucyoz/algorithm2023/blob/master/src/sort/LargestNumber.java): Comparator 오버라이드(내림차순)
```java
//문자열: 앞에서부터 비교, 'a-b' 순서로 해당 문자의 아스키코드 값을 뺀 결과
a.compareTo(b)    

//내림차순은 (o2+o1).compareTo(o1+o2);
//오름차순은 (o1+o2).compareTo(o1+o2);
```

### **스택&큐**
- [프로세스](https://github.com/lucyoz/algorithm2023/blob/master/src/stackNqueue/Process.java): 큐와 우선순위 큐 이용
- [두 큐 합 같게 만들기](https://github.com/lucyoz/algorithm2023/blob/master/src/stackNqueue/SumQueue.java): 큐
- [기능개발](https://github.com/lucyoz/algorithm2023/blob/master/src/stackNqueue/DevelopmentFunction.java)
- [기능개발2](https://github.com/lucyoz/algorithm2023/blob/master/src/stackNqueue/DevelopmentFunction2.java)
- [기능개발(큐이용)](https://github.com/lucyoz/algorithm2023/blob/master/src/stackNqueue/DevelopmentFunctionUsingQueue.java)

### **브루트포스**
- [모음사전](https://github.com/lucyoz/algorithm2023/blob/master/src/bruteForce/vowels.java): 규칙 찾아 적용
- [카펫](https://github.com/lucyoz/algorithm2023/blob/master/src/bruteForce/Carpet.java)
- [소수 찾기](https://github.com/lucyoz/algorithm2023/blob/master/src/bruteForce/FindPrimeNumber.java)
- [최소직사각형](https://github.com/lucyoz/algorithm2023/blob/master/src/bruteForce/LeastRectangle.java)

### **해시**
- [의상](https://github.com/lucyoz/algorithm2023/blob/master/src/hash/Clothes.java): Map이용
- [롤케이크 자르기](https://github.com/lucyoz/algorithm2023/blob/master/src/hash/CuttingRollCake.java): Set 이용 -> for문 돌 때마다 초기화했더니 -> 시간 초과
- [롤케이크 자르기2](https://github.com/lucyoz/algorithm2023/blob/master/src/hash/CuttingRollCake2.java): Map과 Set 이용 -> 통과

### **탐욕법 Greedy**
- [구명보트](https://github.com/lucyoz/algorithm2023/blob/master/src/greedy/LifeBoat.java): ArrayDeque 이용

### **기타**
**1. KAKAO**
- [k진수에서 소수 개수 구하기](https://github.com/lucyoz/algorithm2023/blob/master/src/etc/kakao/FindPrimeInK.java): 2022 KAKAO BLIND RECRUITMENT
- [주차 요금 계산](https://github.com/lucyoz/algorithm2023/blob/master/src/etc/kakao/ParkingFee4.java): Map, Set 이용

**2. 기타**
- [행렬 테두리 회전하기](https://github.com/lucyoz/algorithm2023/blob/master/src/etc/RotateBorder.java): 2021 Dev-Matching: 웹 백엔드 개발자 
- [숫자 변환하기](https://github.com/lucyoz/algorithm2023/blob/master/src/etc/AlterXtoY.java): DP 이용
- [연속 부분 수열 합의 개수](https://github.com/lucyoz/algorithm2023/blob/master/src/etc/ConsecutiveNumberSubSequence.java): Set 이용
- [연속된 부분 수열의 합](https://github.com/lucyoz/algorithm2023/blob/master/src/etc/SumOfConsecutiveNumberSubSequence.java): 투포인터 이용
- [뒤에 있는 큰 수 찾기](https://github.com/lucyoz/algorithm2023/blob/master/src/etc/FindMaxBehindNum.java): stack 이용
- [피로도](https://github.com/lucyoz/algorithm2023/blob/master/src/etc/Fatigue.java): DFS(재귀) 이용 -> boolean[] visited 
- [피로도2](https://github.com/lucyoz/algorithm2023/blob/master/src/etc/Fatigue2.java): DFS(재귀) -> visited배열 없이
- [튜플](https://github.com/lucyoz/algorithm2023/blob/master/src/etc/Tuple.java): String split, Set 이용
- [방문 길이](https://github.com/lucyoz/algorithm2023/blob/master/src/etc/LengthOfOnesVisit.java): 3차원 배열, dir
- [n^2배열 자르기](https://github.com/lucyoz/algorithm2023/blob/master/src/etc/CuttingArray.java): (이중 for문으로 메모리 초과)
- [n^2배열 자르기2](https://github.com/lucyoz/algorithm2023/blob/master/src/etc/CuttingArray2.java)
- [JadenCase 문자열 만들기](https://github.com/lucyoz/algorithm2023/blob/master/src/etc/JadenCase.java): StringTokenizer
- [스킬트리](https://github.com/lucyoz/algorithm2023/blob/master/src/etc/SkillTree.java)
- [숫자 카드 나누기](https://github.com/lucyoz/algorithm2023/blob/master/src/etc/DistributeCard.java)
- [마법의 엘리베이터](https://github.com/lucyoz/algorithm2023/blob/master/src/etc/MagicalElevator.java)
- [요격 시스템](https://github.com/lucyoz/algorithm2023/blob/master/src/etc/InterceptSystem.java)

**3. 연습문제**
- [할인행사](https://github.com/lucyoz/algorithm2023/blob/master/src/etc/discountEvent.java)
### **백준**
- [어두운 굴다리](https://github.com/lucyoz/algorithm2023/blob/master/src/etc/baekjoon/BeakJoon17266.java): Parametric Search
- [구간 합 구하기 4](https://github.com/lucyoz/algorithm2023/blob/master/src/etc/baekjoon/BaekJoon11659.java): 기본 구현