# Clean Code 17장 - 냄새와 휴리스틱
- 주석
- 환경
- 함수
- 일반
- 자바
- 이름
- 테스트
- 결론
---

- 코드를 읽으면서 기록한 나쁜 냄새들의 목록

## 주석

### C1: 부적절한 정보
- 다른 시스템에 (소스 코드 관리 시스템, 버그 추적 시스템, 이슈 추적 시스템, 기타 기록 관리 시스템) 저장할 정보는 주석으로 적절하지 못하다.
- 변경 이력은 장황한 날짜와 따분한 내용으로 소스 코드만 번잡하게 만든다.
- **주석은 코드와 설계에 기술적인 설명을 부연하는 수단이다.**

### C2: 쓸모 없는 주석
- 오래된 주석, 엉뚱한 주석, 잘못된 주석은 더 이상 쓸모가 없다.
- 코드와 무관하게 혼자서 따로 놀며 코드를 그릇된 방향으로 이끈다.

### C3: 중복된 주석
- 코드만으로 충분한데 구구절절 설명하는 주석이 중복된 주석이다.
- 함수 서명(signature)만 달랑 기술하는 javadoc 예시를 보자.

```java
/**
 * @param sellRequest
 * @return
 * @throws ManagedComponentException
 */
public SellResponse beginSellItem(SellRequest sellRequest) throws ManagedComponentException
```

### C4: 성의 없는 주석
- 작성할 가치가 있는 주석은 잘 작성할 가치도 있다.
- 단어를 신중하게 선택하고 주절대지 않으며 당연한 소리를 반복하지 않고 간결/명료하게 작성하자

### C5: 주석 처리된 코드
- 얼마나 오래된 코드인지, 중요한 코드인지 아닌지, 알 길이 없다.
- 누군가에게 필요한 코드라 생각하기에 아무도 삭제하지 않는다.
- 주석으로 처리된 코드를 발견하면 즉각 지워버리자!
- 소스 코드 관리 시스템이 기억할 것이다.

## 환경

### E1: 여러 단계로 빌드해야 한다
- 빌드는 간단히 한 단계로 끝나야 한다.
- 한 명령으로 전체를 체크아웃해서 빌드할 수 있어야 한다.

### E2: 여러 단계로 테스트해야 한다
- 모든 단위 테스트는 한 명령으로 돌려야 한다.
- 모든 테스트를 한 번에 실행하는 능력은 아주 근본적이고 아주 중요하다.

## 함수

### F1: 너무 많은 인수
- 함수에서 인수 갯수는 작을수록 좋다.
- 아예 없으면 가장 좋다.

### F2: 출력 인수
- 출력 인수는 직관성을 정면으로 위배한다.
- 독자는 인수를 입력으로 간주하기 때문에 함수에서 뭔가의 상태를 변경해야 한다면 함수가 속한 객체의 상태를 변경하라

### F3: 플래그 인수
- boolean 인수는 함수가 여러 기능을 수행한다는 명백한 증거다. 플래그 인수는 혼란을 초래하므로 피해야 마땅하다.

### F4: 죽은 함수
- 아무도 호출하지 않는 함수는 삭제한다.
- 죽은 코드는 낭비다.

## 일반

### G1: 한 소스 파일에 여러 언어를 사용한다
- 오늘날 프로그래밍 환경은 한 소스 파일 내에서 다양한 언어를 지원한다.
- 이상적으로는 소스 파일 하나에 언어 하나만 사용하는 방식이 가장 좋다.

### G2: 당연한 동작을 구현하지 않는다
- 함수나 클래스는 다른 프로그래머가 당연하게 여길 만한 동작과 기능을 제공해야 한다.
- 당연한 동작을 구현하지 않으면 코드를 읽거나 사용하는 사람이 더 이상 함수 이름만으로 함수 기능을 직관적으로 예상하기 어렵다.
- 저자를 신뢰하지 못하므로 코드를 일일이 살피게 된다.

### G3: 경계를 올바로 처리하지 않는다
- 스스로의 직관에 의존하지 말라.
- 모든 경계 조건을 찾아내고, 모든 경계 조건을 테스트하는 테스트 케이스를 작성하라.

### G4: 안전 절차 무시
- 실패하는 테스트 케이스를 일단 제껴두고 나중으로 미루는 태도는 신용카드가 공짜 돈이라는 생각만큼 위험하다.

### G5: 중복
- 코드에서 중복을 발견할 때마다 추상화할 기회로 간주하라.
- 중복된 코드를 하위 루틴이나 다른 클래스로 분리하라.
- switch/case 문이나, if/else 문으로 똑같은 조건을 거듭 확인하는 중복에 대해서는 **다형성**으로 대체하라
- 알고리즘이 유사하나 코드가 서로 다른 중복에 대해서는 **템플릿 메서드 패턴이나 전략 패턴**으로 대체하라

### G6: 추상화 수준이 올바르지 못하다
- 추상화는 소프트웨어 개발자에게 가장 어려운 작업 중 하나다.
- 추상화로 개념을 분리할 때는 철저해야 한다.
- 모든 저차원 개념은 파생 클래스에 넣고, 모든 고차원 개념은 기초 클래스에 넣는다.
- 세부 구현과 관련한 상수, 변수, 유틸리티 함수는 기초 클래스에 넣으면 안 된다. 소스 파일, 컴포넌트, 모듈도 마찬가지다.
- 개념을 다양한 차원으로 분리해 다른 컨테이너에 넣자.
- 고차원 개념과 저차원 개념을 섞어서는 안 된다.

### G7: 기초 클래스가 파생 클래스에 의존한다
- 일반적으로 기초 클래스는 파생 클래스를 아예 몰라야 마땅하다.
- 파생 클래스 개념으로부터 분리해 독립성을 보장해야 한다.

### G8: 과도한 정보
- 잘 정의된 모듈은 인터페이스가 아주 작다.
- 클래스나 모듈 인터페이스에 노출할 함수를 제한할 줄 알아야 한다.
- 클래스가 제공하는 메서드 수는 작을수록 좋다.
- 함수가 아는 변수 수도 작을수록 좋다.
- 클래스에 들어있던 인스턴스 변수 수도 작을수록 좋다.
- 인터페이스를 매우 작게 그리고 매우 깐깐하게 만들어라.
- **정보를 제한해 결합도를 낮춰라**

### G9: 죽은 코드
- 죽은 코드란 실행 되지 않는 코드를 가리킨다.
- 옛날옛적 시스템의 모양새가 다른 시절에 짜놓은 코드다.
- 시스템에서 제거하라.

### G10: 수직 분리
- 변수와 함수는 사용되는 위치에 가깝게 정의한다.
- 지역 변수는 처음으로 사용하기 직전에 선언하며, 수직으로 가까운 곳에 위치해야 한다.
- 비공개 함수는 처음으로 호출한 직후에 정의한다. 그래야 쉽게 눈에 띈다.

### G11: 일관성 부족
- 최소 놀람의 원칙(The Principle of Least Surprise)
- 어떤 개념을 특정 방식으로 구현했다면, 유사한 개념도 같은 방식으로 구현한다.
- 명명법을 통일한다던가...

### G12: 잡동사니
- 아무도 사용하지 않는 변수, 아무도 호출하지 않는 함수, 정보를 제공하지 못하는 주석 등이 좋은 예다.
- 모두가 코드만 복잡하게 만들 뿐이니 제거해야 마땅하다.

### G13: 인위적 결합
- 서로 무관한 개념을 인위적으로 결합하지 안흔다.
- 함수, 상수, 변수를 선언할 때는 시간을 들여 올바른 위치를 고민한다.
- 그저 당장 편한 곳에 선언하고 내버려두면 안 된다.

### G14: 기능 욕심
- 클래스 메서드는 자기 클래스의 변수와 함수에 관심을 가져야지 다른 클래스의 변수와 함수에 관심을 가져서는 안 된다.
- 다른 객체의 참조자와 변경자를 이용해 객체 내용을 조작한다면 욕심이다.

### G15: 선택자 인수
- 선택자 인수는 큰 함수를 작은 함수 여럿으로 쪼개지 않으려는 게으름의 소산이다.

```java
class TestClass {
    public int calculateWeeklyPay(boolean overtime) {
        int tenthRate = getTenthRate();
        int tenthWorked = getTenthsWorked();
        int straightTime = Math.min(400, tenthWorked);
        int overTime = Math.max(0, tenthWorked - straightTime);
        int straightPay = straightTime * tenthRate;
        double overtimeRate = overTime ? 1.5 : 1.0 * tenthRate;
        int overtimePay = (int)Math.round(overTime * overtimeRate);
        return straightPay + overtimePay;
    }
}
```

- 초과근무 수당을 1.5배로 지급하면 true고 아니면 false다.
- 독자는 calculateWeeklyPay(false)라는 코드를 발견할 때마다 의미를 떠올려야 한다.
- 이렇게 구현했다면?

```java
class TestClass {
    public int straightPay() {
        return getTenthsWorked() * getTenthRate();
    }
    
    public int overTimePay() {
        int overTimeTenths = Math.max(0, getTenthsWorked() - 400);
        int overTimePay = overTimeBonus(overTimeTenths);
        return straightPay() + overTimePay;
    }
    
    private int overTimeBonus(int overTimeTenths) {
        double bonus = 0.5 * getTenthRate() * overTimeTenths;
        return (int) Math.round(bonus);
    }
}
```

- **일반적으로, 인수를 넘겨 동작을 선택하려는 대신 새로운 함수를 만드는 것이 좋다.** **(나도 너무 공감하고, 어서 회사 코드를 고쳐봐야겠다.)**

### G16: 모호한 의도
- 코드를 짤 때는 의도를 최대한 분명히 밝힌다.
- 행을 바꾸지 않고 표현한 수식, 헝가리식 표기법, 매직 번호 등은 모두 저자의 의도를 흐린다.

### G17: 잘못 배치한 책임
- 코드를 배치하는 위치를 결정하는 것은 중요하다.
- 영리하게 독자에게 직관적인 위치가 아닌 개발자에게 편한 함수에 배치한다면, 그 함수의 이름을 정확히 짓자.

### G18: 부적절한 static 함수
- 간혹 우리는 static으로 정의하면 안 되는 함수를 static으로 정의하는 실수를 범할 수 있다.
- 일반적으로 static 함수보다 인스턴스 함수가 더 좋다.
- 반드시 static으로 정의해야겠다면, 재정의할 가능성이 없는지 꼼꼼히 따져본다.

### G19: 서술적 변수
- 서술적인 변수 이름은 많이 써도 괜찮다. 일반적으로 많을수록 더 좋다.
- 계산을 몇 단계로 나누고 중간값에 좋은 변수 이름만 붙여도 해독하기 어렵던 모듈이 순식간에 읽기 쉬운 모듈로 탈바꿈한다.

### G20: 이름과 기능이 일치하는 함수
- 이름만으로 분명하지 않기에 구현을 살피거나 문서를 뒤적여야 한다면 더 좋은 이름으로 바꾸거나 아니면 더 좋은 이름을 붙이기 쉽도록 기능을 정리해야 한다.

### G21: 알고리즘을 이해하라
- 구현이 끝났다고 선언하기 전에 함수가 돌아가는 방식을 확실히 이해하는지 확인하라.
- 테스트 케이스를 모두 통과한다는 사실만으로 부족하다.
- 작성자가 알고리즘이 올바르다는 사실을 알아야 한다.

### G22: 논리적 의존성은 물리적으로 드러내라
- 한 모듈이 다른 모듈에 의존한다면 물리적인 의존성도 있어야 한다.
- 논리적인 의존성만으로는 부족하다.
- 의존하는 모듈이 상대 모듈에 대해 뭔가를 가정하면 안 된다. (논리적으로 의존하면 안 된다.)
- **의존하는 모든 정보를 명시적으로 요청하는 편이 좋다.**

```java
import java.util.List;
import java.util.ArrayList;

public class HourlyReporter {
    private HourlyReporterFormatter formatter;
    private List<LineItem> page;
    private final int PAGE_SIZE = 55;

    public HourlyReporter(HourlyReporterFormatter formatter) {
        this.formatter = formatter;
        page = new ArrayList<LineItem>();
    }
    
    public void generateReport(List<HourlyEmployee> employees) {
        for (HourlyEmployee e: employees) {
            addLineItemToPage(e);
            if (page.size() == PAGE_SIZE)
                printAndClearItemList();
        }
        if (page.size() > 0)
            printAndClearItemList();
    }
    
    private void printAndClearItemList() {
        formatter.format(page);
        page.clear();
    }
    
    private void addLineItemToPage(HourlyEmployee e) {
        LineItem item = new LineItem();
        item.name = e.getName();
        item.hours = e.getTenthsWorked() / 10;
        item.tenths = e.getTenthWorked() % 10;
        page.add(item);
    }
    
    public class LineItem {
        public String name;
        public int hours;
        public int tenths;
    }
}

```

- PAGE_SIZE 상수에 대한 논리적인 의존성이 존재한다.
- HourlyReporter 클래스는 HourlyReportFormatter 클래스가 페이지 크기를 알 거라고 가정하고 있다.
- 페이지 크기 55를 처리할 줄 안다는 사실에 의존한다.
- 만약 HourlyReportFormatter 구현 중 하나가 페이지 크기 55를 제대로 처리하지 못한다면 **오류가 생긴다.**
- HourlyReportFormatter 클레스에 getMaxPageSize()라는 메서드를 추가해 논리적인 의존성이 물리적인 의존성으로 변하도록 사용하면 된다.

### G23: If/Else 혹은 Switch/Case 문보다 다형성을 사용하라
1. switch를 선택하기 전에 다형성을 먼저 고려해보라
2. 유형보다 함수가 더 쉽게 변하는 경우는 극히 드물다. 그러므로 모든 switch 문을 의심해보라
