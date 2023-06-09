# 자료구조와 알고리즘

> 프로그래머스 </br>
> 백준 (with Do It! 알고리즘 코딩테스트 자바편) </br>
> 이것이 코딩테스트다 (나동빈 저, 한빛미디어)

### **BFS와 DFS**
- [음료수 얼려먹기](https://github.com/lucyoz/algorithm2023/blob/master/src/etc/Icecream.java): DFS 재귀이용
- [미로 탈출](https://github.com/lucyoz/algorithm2023/blob/master/src/etc/EscapeMaze.java): BFS로 간선의 비용이 같을 때 최단거리 구하기
- [게임 맵 최단거리](https://github.com/lucyoz/algorithm2023/blob/master/src/dfsNbfs/ShortestDistance.java): BFS로 최단거리
- [타겟 넘버 using BFS](https://github.com/lucyoz/algorithm2023/blob/master/src/dfsNbfs/TargetNumberUsingBFS.java): BFS
- [타겟 넘버 using BFS](https://github.com/lucyoz/algorithm2023/blob/master/src/dfsNbfs/TargetNumberUsingDFS.java): DFS
- [DFS와 BFS (백준)](https://github.com/lucyoz/algorithm2023/blob/master/src/dfsNbfs/BaekJoon1260.java): DFS(재귀), BFS(큐)
- [무인도 여행](https://github.com/lucyoz/algorithm2023/blob/master/src/etc/Travelisland2.java): bfs 이용

### **정렬**
- [가장 큰 수](https://github.com/lucyoz/algorithm2023/blob/master/src/sort/LargestNumber.java): Comparator 오버라이드(내림차순)
- [H-Index](https://github.com/lucyoz/algorithm2023/blob/master/src/sort/HIndex.java)
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
- [주식가격](https://github.com/lucyoz/algorithm2023/blob/master/src/stackNqueue/Stock.java): 스택 이용
- [다리를 지나는 트럭](https://github.com/lucyoz/algorithm2023/blob/master/src/stackNqueue/TruckOnBridge.java): LinkedList<int[]>

### **브루트포스**
- [모음사전](https://github.com/lucyoz/algorithm2023/blob/master/src/bruteForce/Vowels.java): 규칙 찾아 적용
- [카펫](https://github.com/lucyoz/algorithm2023/blob/master/src/bruteForce/Carpet.java)
- [소수 찾기](https://github.com/lucyoz/algorithm2023/blob/master/src/bruteForce/FindPrimeNumber.java)
- [최소직사각형](https://github.com/lucyoz/algorithm2023/blob/master/src/bruteForce/LeastRectangle.java)
- [전력망을 둘로 나누기](https://github.com/lucyoz/algorithm2023/blob/master/src/bruteForce/DividePowerGrid.java): bfs 이용하여 연결된 전력망 갯수 세기

### **해시**
- [의상](https://github.com/lucyoz/algorithm2023/blob/master/src/hash/Clothes.java): Map이용
- [롤케이크 자르기](https://github.com/lucyoz/algorithm2023/blob/master/src/hash/CuttingRollCake.java): Set 이용 -> for문 돌 때마다 초기화했더니 -> 시간 초과
- [롤케이크 자르기2](https://github.com/lucyoz/algorithm2023/blob/master/src/hash/CuttingRollCake2.java): Map과 Set 이용 -> 통과

### **탐욕법 Greedy**
- [구명보트](https://github.com/lucyoz/algorithm2023/blob/master/src/greedy/LifeBoat.java): ArrayDeque 이용
- [큰 수 만들기](https://github.com/lucyoz/algorithm2023/blob/master/src/greedy/MakeBigNum.java)

### **기타**
**1. KAKAO**
- [k진수에서 소수 개수 구하기](https://github.com/lucyoz/algorithm2023/blob/master/src/etc/kakao/FindPrimeInK.java): 2022 KAKAO BLIND RECRUITMENT
- [주차 요금 계산](https://github.com/lucyoz/algorithm2023/blob/master/src/etc/kakao/ParkingFee4.java): Map, Set 이용
- [오픈채팅방](https://github.com/lucyoz/algorithm2023/blob/master/src/etc/kakao/OpenKakaoTalk.java): Hash Map
- [뉴스 클러스터링](https://github.com/lucyoz/algorithm2023/blob/master/src/etc/kakao/NewsClustering.java): 다중집합의 교집합, 합집합 구하기
- [캐시](https://github.com/lucyoz/algorithm2023/blob/master/src/etc/kakao/MapCache.java): 캐시, LRU 알고리즘
- [압축](https://github.com/lucyoz/algorithm2023/blob/master/src/etc/kakao/LZWCompression.java)
- [n진수 게임](https://github.com/lucyoz/algorithm2023/blob/master/src/etc/kakao/BaseN.java)
- [파일명 정렬](https://github.com/lucyoz/algorithm2023/blob/master/src/etc/kakao/SortByFileName.java)
- [수식 최대화](https://github.com/lucyoz/algorithm2023/blob/master/src/etc/kakao/Expression.java)
- [방금그곡](https://github.com/lucyoz/algorithm2023/blob/master/src/etc/kakao/MusicInfos.java)
- [메뉴 리뉴얼](https://github.com/lucyoz/algorithm2023/blob/master/src/etc/kakao/RenewalMenu.java)
- [거리두기 확인하기](https://github.com/lucyoz/algorithm2023/blob/master/src/etc/kakao/SocialDistancing.java): dfs 이용
- [문자열 압축](https://github.com/lucyoz/algorithm2023/blob/master/src/etc/kakao/CompressionString.java): 문자열 순차적으로 비교
- [괄호 변환](https://github.com/lucyoz/algorithm2023/blob/master/src/etc/kakao/MakeNewBracketString.java): 스택,재귀,문자열 자르기 등 사용

**2. 기타**
- [행렬 테두리 회전하기](https://github.com/lucyoz/algorithm2023/blob/master/src/etc/RotateBorder.java): 2021 Dev-Matching: 웹 백엔드 개발자
- [방문 길이](https://github.com/lucyoz/algorithm2023/blob/master/src/etc/LengthOfOnesVisit.java): 3차원 배열, dir
- [n^2배열 자르기](https://github.com/lucyoz/algorithm2023/blob/master/src/etc/CuttingArray.java): (이중 for문으로 메모리 초과)
- [n^2배열 자르기2](https://github.com/lucyoz/algorithm2023/blob/master/src/etc/CuttingArray2.java)
- [2개 이하로 다른 비트](https://github.com/lucyoz/algorithm2023/blob/master/src/etc/OtherBit.java): 비트 연산 or ! 짝홀수로 나누어 규칙 풀이 !
- [영어 끝말잇기](https://github.com/lucyoz/algorithm2023/blob/master/src/etc/WordRelay.java)
- [예상 대진표](https://github.com/lucyoz/algorithm2023/blob/master/src/etc/TournamentSchedule.java)
- [괄호 회전하기](https://github.com/lucyoz/algorithm2023/blob/master/src/etc/RotateBracket.java): Arrays copy, Stack 이용
- [점프와 순간이동](https://github.com/lucyoz/algorithm2023/blob/master/src/etc/JumpNTeleport.java): 2진법과 유사
- [삼각 달팽이](https://github.com/lucyoz/algorithm2023/blob/master/src/etc/TriangleSnails.java)
- [쿼드압축 후 개수 세기](https://github.com/lucyoz/algorithm2023/blob/master/src/etc/QuadCompression.java)
- [배달](https://github.com/lucyoz/algorithm2023/blob/master/src/etc/Delivery.java): 다익스트라 알고리즘
- [멀쩡한 사각형](https://github.com/lucyoz/algorithm2023/blob/master/src/etc/FineSquare.java): 공약수 생각

**3. 연습문제**
- [할인행사](https://github.com/lucyoz/algorithm2023/blob/master/src/etc/DiscountEvent.java)
- [숫자 변환하기](https://github.com/lucyoz/algorithm2023/blob/master/src/etc/AlterXtoY.java): DP 이용
- [연속 부분 수열 합의 개수](https://github.com/lucyoz/algorithm2023/blob/master/src/etc/ConsecutiveNumberSubSequence.java): Set 이용
- [연속된 부분 수열의 합](https://github.com/lucyoz/algorithm2023/blob/master/src/etc/SumOfConsecutiveNumberSubSequence.java): 투포인터 이용
- [뒤에 있는 큰 수 찾기](https://github.com/lucyoz/algorithm2023/blob/master/src/etc/FindMaxBehindNum.java): stack 이용
- [피로도](https://github.com/lucyoz/algorithm2023/blob/master/src/etc/Fatigue.java): DFS(재귀) 이용 -> boolean[] visited
- [피로도2](https://github.com/lucyoz/algorithm2023/blob/master/src/etc/Fatigue2.java): DFS(재귀) -> visited배열 없이
- [튜플](https://github.com/lucyoz/algorithm2023/blob/master/src/etc/Tuple.java): String split, Set 이용
- [JadenCase 문자열 만들기](https://github.com/lucyoz/algorithm2023/blob/master/src/etc/JadenCase.java): StringTokenizer
- [스킬트리](https://github.com/lucyoz/algorithm2023/blob/master/src/etc/SkillTree.java)
- [숫자 카드 나누기](https://github.com/lucyoz/algorithm2023/blob/master/src/etc/DistributeCard.java)
- [마법의 엘리베이터](https://github.com/lucyoz/algorithm2023/blob/master/src/etc/MagicalElevator.java)
- [요격 시스템](https://github.com/lucyoz/algorithm2023/blob/master/src/etc/InterceptSystem.java)
- [호텔 대실](https://github.com/lucyoz/algorithm2023/blob/master/src/etc/Hotel.java): 누적합 이용
- [귤 고르기](https://github.com/lucyoz/algorithm2023/blob/master/src/etc/SelectTangerine.java)
- [택배상자](https://github.com/lucyoz/algorithm2023/blob/master/src/etc/ParcelBox.java)
- [124 나라의 숫자](https://github.com/lucyoz/algorithm2023/blob/master/src/etc/Country124.java): 3진법 변형, 나머지 처리 주의
- [줄 서는 방법](https://github.com/lucyoz/algorithm2023/blob/master/src/etc/LineUp.java): Lv2, Lv3
- [2 x n 타일링](https://github.com/lucyoz/algorithm2023/blob/master/src/etc/Tiling.java): 피보나치 변형
- [멀리 뛰기](https://github.com/lucyoz/algorithm2023/blob/master/src/etc/StandingLongJump.java): 피보나치 변형
- [행렬의 곱셈](https://github.com/lucyoz/algorithm2023/blob/master/src/etc/MultiplicationOfMatrices.java): 삼중 for문
- [점 찍기](https://github.com/lucyoz/algorithm2023/blob/master/src/etc/practice/Dot.java)
- [혼자 놀기의 달인](https://github.com/lucyoz/algorithm2023/blob/master/src/etc/practice/PlayingAlone.java)
- [가장 큰 정사각형 찾기](https://github.com/lucyoz/algorithm2023/blob/master/src/etc/practice/BiggestSquare.java): DP
- [테이블 해시 함수](https://github.com/lucyoz/algorithm2023/blob/master/src/etc/practice/TableHashFunction.java): 정렬 오버라이드, 런타임에러 -> ArrayList로 해결

### **백준**
- [어두운 굴다리](https://github.com/lucyoz/algorithm2023/blob/master/src/etc/baekjoon/BeakJoon17266.java): Parametric Search
- [구간 합 구하기 4](https://github.com/lucyoz/algorithm2023/blob/master/src/etc/baekjoon/BaekJoon11659.java): 기본 구현