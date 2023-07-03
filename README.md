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
        ViewPager2를 사용해야 한다. MainActivity의 xml 파일에 viewpager2 영역을 만든다. 참고로 여기서는 TabLayout(이른바 TabBar)이랑 연결 한다.(swipe 형식이 아니다.) ViewPager2에 대한 Adapter는 FragmentStateAdapter라는 것을 상속 받고 FragmentManager와 Lifecycle을 인자로 받아서 넘겨주어야 한다. 상속받은 것에서 반드시 재정의(override)해 주어야 하는 getItenCount()와 createFragment(position : Int)를 구현해준다. getItemCount는 내가 ViewPager에서 보여줄 Fragment의 총 갯수이고 createFragment(position : Int)는 해당 position에 Fragment를 생성해주는 것이다. 말 그대로 ViewPager2 영역에 대한 변환기? adapter인 것이다. <br>
        <div>
        이를 MainActivity.kt에서 코드상에서 작성하면 viewPager라는 변수에 binding.viewPager(XML에 있는 View Pager를 변수로 담아 둔 것)을 넣어준다. 매번 binding.viewPager를 쓰기 귀찮아서 하는 작업이다. viewPager(사실 binding.viewPager임)의 adapter에 앞서 만든 클래스의 객체를 생성해주면 된다. ViewPagerAdapter(supportFragmentManager, lifecycler)을 넣어준다. 이때! apply라는 것으로 ViewPagerAdapter 안에 있는 addFragment(이건 내가 재정의 한 것이 아니라 별도로 만든 것)을 통해 Fragment를 순차적으로 넣어준다.<br>
        </div>
        <div>
        참고로 TabLayoutMediator라는 것을 통해 tablayout(우리는 Tabbar)로 TabBar와 ViewPager를 연결시켜주어야 한다.
        </div>
    </li>
    <li>
        <b>FragmentManager란?</b><br>
        [구글공식문서](https://developer.android.com/guide/fragments/fragmentmanager?hl=ko)를 참고한다. <br>
        FragmentManager란 앱 Fragment에서 프래그먼트를 추가, 삭제, 교체하고 백 스택에 추가하는 당의 작업을 실행하는 클래스이다. 말 그대로 Fragment에 대한 관리 및 작업을 하는 클래스이다. <br>
        FragmentManager에는 
    </li>
    <li>
        <b>supportFragmentManager란?</b><br>
    </li>
    <li>
        <b>lifecycle이란?</b><br>
    </li>
</ol>
