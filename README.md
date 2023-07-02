# 'WhatsApp Clone _ Android'는 무엇을 하는 건가요?
[참고 영상](https://www.youtube.com/watch?v=3V3W3HjYzog&list=PL6Rs84MkNq7lC7NitsR5fsi8rZLZaMppa&index=1)을 보고 따라만들면서 궁금한 점을 새롭게 정리해보면서 학습.

# QA 정리
<ol>
    <li>
        <b>List와 ArrayList 차이</b><br>
        <b>ArrayList</b>는 Kotlin에서 '동적 배열'을 만들기 위해 사용한다. '동적 배열'은 전제 조건(약속된 규격?)으로 배열의 크기를 늘리거나 줄일 수 있는 것을 의미한다. 또한, functionalities를 읽고 쓰는 것을 제공한다. ArrayList는 중복 항목을 포함할 수 있고, 타고나길(본질적으로) non-synchronized이다.(동기화 되지 않는다.) 우리는 ArrayList를 사용해서 특정 요소의 인덱스에 접근할 수 있고 ArrayList를 string(문자열)이나 또 다른 배열, 많은 functionalities로 바꿀 수 있다.<br>
        <b>Array</b>는 실질적으로 모든 프로그래밍 언어에 가장 기본적으인 자료 구조 중 하나이다. Array의 숨겨진 idea는 하나의 변수 이름 아래에 같은 종류의 데이터 타입의 여러 아이템을 저장하는 것이다.<br>
        Array는 메모리 상에 연속적으로 저장되며, index를 이용해 접근할 수 있고, mutable(값이 바뀔 수 있고), 크기는 고정되어 있다.
    </li>
    <li>
        <b>companion object와 static</b><br>
        Kotln에서는 static 대신 class 내에 companion object{}를 넣어 해당 안에 들어간 것들이 {클래스 이름}.{필드/함수 이름}으로 사용된다.
        -> 추가 학습 필요
    </li>
    <li>
        <b>ViewPager1 is deprecated</b><br>
    </li>
    <li>
        <b>is deprecated</b><br>
    </li>
</ol>