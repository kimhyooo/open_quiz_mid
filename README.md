# 퀴즈 어플리케이션 

+ 메인/퀴즈/랭킹/문항추가DB연동

![111111](https://user-images.githubusercontent.com/63217411/83966172-98a9b700-a8f3-11ea-9718-ca6a22b2f69a.png)
![111111](https://user-images.githubusercontent.com/63217411/83966189-b8d97600-a8f3-11ea-9a86-ef2ffa19fed9.png)
![111111](https://user-images.githubusercontent.com/63217411/83966204-c7c02880-a8f3-11ea-8967-b8934901aba1.png)
![111111](https://user-images.githubusercontent.com/63217411/83966216-ddcde900-a8f3-11ea-8444-5c4b6fe87e32.png)
+ 개요
   +  정답과 오답만을 가리는 기존의 퀴즈 어플에서 벗어나 타이머, 점수, 랭킹 등 많은 기능을 추가하여 사용자의 사용 즐거움과 만족감을 늘였다. 
사용자가 직접 퀴즈를 만들어 볼 수 있고 그 문제를 풀어 볼 수 있는 기능을 넣어 기존의 문제 뿐만 아니라 원하는 분야의 문제를 포함하여 사용자들의 흥미를 이끌 수 있도록 하였다.


+ 기능
   +  애니메이션 스플래쉬
   +  한 화면에 한 문제씩 나오도록 구현(메인화면에서 Start 누르면 나오는 퀴즈)
   +  현재 점수가 몇 점인지 문제를 풀면 바로 보이도록
   +  몇 문항 남았는지 넣음 (ex. 2/10)
   +  3개의 버전에서 Easy버전을 눌렀을 때만 힌트를 제공한다.
   +  Hard버전은 1분, Normal버전 1분30초, Easy버전 3분으로 타이머를 구현  했고 타이머가 끝나면 튕기도록 했음.
   +  Mix버전엔 타이머를 시작, 멈춤, 초기화 3개의 버튼으로 구현
   +  사용자가 퀴즈를 만들어 저장할 수 있도록 데이터베이스에 정보저장
   +  퀴즈 데이터 수정 및 삭제 가능
   +  저장한 데이터베이스를 사용할 수 있도록 화면에 표출
   +  Edit 모드로 들어가기 위해 관리자 비밀번호 생성
   +  My Question에서 총 몇 문항이 있는지 몇 문항이 남아있는지 나타냄
   +  퀴즈 데이터가 없을 시 입장 불가가 뜨며, 문제를 다 풀었을 경우 
   +  문제를 다 풀고 정답/오답 개수 확인
   +  사용자 이름, 점수, 선택한 버전의 Top3 확인
   +  각 버전 별 랭킹 Top3 확인


